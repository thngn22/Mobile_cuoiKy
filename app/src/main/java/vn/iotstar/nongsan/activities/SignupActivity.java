package vn.iotstar.nongsan.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ActivitySignupBinding;
import vn.iotstar.nongsan.models.viewModels.ProductDetailViewModel;
import vn.iotstar.nongsan.models.viewModels.SignupViewModel;
import vn.iotstar.nongsan.repository.SignupRepository;

public class SignupActivity extends AppCompatActivity {
    SignupViewModel viewModel;
    ActivitySignupBinding binding;
    String phone, email, password, confirm_password;

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
        phone = binding.etPhone.getText().toString();
        email = binding.etEmail.getText().toString();
        password = binding.etPassword.getText().toString();
        confirm_password = binding.etPassword1.getText().toString();

        if (isPasswordMatching(password, confirm_password)) {
            viewModel = new ViewModelProvider(this).get(SignupViewModel.class);
            viewModel.signupModelMutableLiveData(email, password, phone).observe(this, signupModel -> {
                if (signupModel.getStatus() == 200) {
                    Toast.makeText(this, signupModel.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
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
