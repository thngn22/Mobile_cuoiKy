package vn.iotstar.nongsan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.iotstar.nongsan.R;

import vn.iotstar.nongsan.databinding.ActivitySignupBinding;
import vn.iotstar.nongsan.models.viewModels.SignupViewModel;


public class SignupActivity extends AppCompatActivity {
    SignupViewModel viewModel;
    ActivitySignupBinding binding;
    String name, phone, email, password, confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        //initData();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton();
            }
        });
        binding.redirectLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    public void initData() {
        binding.etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (binding.etEmail.getText().toString().length() == 0) {

                }
            }
        });
    }

    public void onClickButton() {
        name = binding.etName.getText().toString();
        phone = binding.etPhone.getText().toString();
        email = binding.etEmail.getText().toString();
        password = binding.etPassword.getText().toString();
        confirm_password = binding.etPassword1.getText().toString();

        if (isPasswordMatching(password, confirm_password)) {
            viewModel = new ViewModelProvider(this).get(SignupViewModel.class);
            viewModel.signupModelMutableLiveData(name, email, password, phone).observe(this, signupModel -> {
                if (signupModel.getStatus() == 201) {
                    Toast.makeText(this, signupModel.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("logg", "Sign up successfully");
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(this, signupModel.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("logg", signupModel.getMessage());
                }
            });
        }
    }

    public boolean isPasswordMatching(String password, String confirmPassword) {
        Pattern pattern = Pattern.compile(password, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(confirmPassword);

        if (!matcher.matches()) {

            Toast.makeText(SignupActivity.this, "Password not match!", Toast.LENGTH_SHORT).show();

            return false;
        }
        return true;
    }
}
