package vn.iotstar.nongsan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.TextView;
=======
>>>>>>> 590da5777b5ef5d9c160aa5fed2f6c9187b636af

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import vn.iotstar.nongsan.R;
import vn.iotstar.nongsan.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
<<<<<<< HEAD

=======
>>>>>>> 590da5777b5ef5d9c160aa5fed2f6c9187b636af
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        init();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.linkToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init(){
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
