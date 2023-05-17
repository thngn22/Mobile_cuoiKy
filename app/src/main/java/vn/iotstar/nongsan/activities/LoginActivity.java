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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ActivityLoginBinding;
import vn.iotstar.nongsan.models.Tokens;
import vn.iotstar.nongsan.models.User;
import vn.iotstar.nongsan.models.viewModels.LoginViewModel;
import vn.iotstar.nongsan.models.viewModels.SignupViewModel;
import vn.iotstar.nongsan.preference.SharedPreference;
import vn.iotstar.nongsan.utils.UtilsTokens;
import vn.iotstar.nongsan.utils.UtilsUser;

public class LoginActivity extends AppCompatActivity {
    LoginViewModel viewModel;
    ActivityLoginBinding binding;
    String id, email, name, password, phone, image, accessToken, refreshToken;

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

        email = binding.etEmailLogin.getText().toString().trim();
        password = binding.etPasswordLogin.getText().toString().trim();

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.loginModelMutableLiveData(email, password).observe(this, loginModel -> {
            if (loginModel.getStatus() == 200) {
                Toast.makeText(this, loginModel.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("logg", String.valueOf(loginModel.getMetadata().size()));
                HashMap<String, HashMap<String, String>> hashMap = new HashMap<>(loginModel.getMetadata());

                for (String key : hashMap.keySet()) {
                    Log.d("logg", key + " ngoai " + hashMap.get(key).get("id"));
                    if (key == "user") {
                        id = hashMap.get(key).get("id");
                        name = hashMap.get(key).get("name");
                        email = hashMap.get(key).get("email");
                        phone = hashMap.get(key).get("phone");
                        image = hashMap.get(key).get("image");

                    } else {
                        accessToken = hashMap.get(key).get("accessToken");
                        refreshToken = hashMap.get(key).get("refreshToken");
                    }
                }

                UtilsUser.user = new User(id, name, email, phone, image);
                UtilsTokens.tokens = new Tokens(accessToken, refreshToken);

                Log.d("logg", "Sign in successfully, welcome back ");


                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("username", name);
                intent.putExtra("mail", email);
                intent.putExtra("phone", phone);
                intent.putExtra("image", image);
                startActivity(intent);

            } else {
                Toast.makeText(this, loginModel.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("logg", loginModel.getMessage());
            }
        });
    }

}


