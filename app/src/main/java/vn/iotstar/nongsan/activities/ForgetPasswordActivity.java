package vn.iotstar.nongsan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity extends AppCompatActivity {

    ActivityForgetPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forget_password);
        binding.backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}