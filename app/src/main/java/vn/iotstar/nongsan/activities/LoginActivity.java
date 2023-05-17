package vn.iotstar.nongsan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ActivityLoginBinding;
import vn.iotstar.nongsan.models.User;
import vn.iotstar.nongsan.models.viewModels.LoginViewModel;
import vn.iotstar.nongsan.models.viewModels.SignupViewModel;
import vn.iotstar.nongsan.preference.SharedPreference;

public class LoginActivity extends AppCompatActivity {
    LoginViewModel viewModel;
    ActivityLoginBinding binding;
    String password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton();
            }
        });

        binding.linkToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);

            }
        });
        binding.fgtPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickButton() {

        email = binding.etEmailLogin.getText().toString();
        password = binding.etPasswordLogin.getText().toString();
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.loginModelMutableLiveData(email, password).observe(this, loginModel -> {
            if (loginModel.getStatus() == 200) {
                Toast.makeText(this, loginModel.getMessage(), Toast.LENGTH_SHORT).show();
                JSONObject obj = null;
                try {
                    obj = new JSONObject(String.valueOf(loginModel.getMetadata()));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JSONObject array = null;
                try {
                    array = obj.getJSONObject("user");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                try {

                    String id = array.getString("id");
                    String name = array.getString("name");
                    String email = array.getString("email");
                    String phone = array.getString("phone");
                    String image = array.getString("image");
                    User user = new User(id, name, email, phone, image);
                    SharedPreference.getInstance(getApplicationContext()).userLogin(user);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                Log.d("logg", "Sign in successfully, welcome back " );



                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                String name = loginModel.getMetadata().get(0).toString();
//                String phone = loginModel.getMetadata().get(3).toString();
//                intent.putExtra("username", name);
//                intent.putExtra("mail", email);
//                intent.putExtra("phone", phone);
                startActivity(intent);

                } else {
                Toast.makeText(this, loginModel.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("logg", loginModel.getMessage());
            }
        });
    }

}


