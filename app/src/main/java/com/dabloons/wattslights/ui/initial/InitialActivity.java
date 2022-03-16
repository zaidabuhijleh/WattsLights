package com.dabloons.wattslights.ui.initial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dabloons.wattslights.R;
import com.dabloons.wattslights.databinding.ActivityLoginBinding;
import com.dabloons.wattslights.ui.login.LoginActivity;
import com.dabloons.wattslights.ui.login.RegisterActivity;
import com.dabloons.wattslights.ui.main.MainActivity;
import com.dabloons.wattslights.databinding.ActivityInitialBinding;

public class InitialActivity extends AppCompatActivity {

    private ActivityInitialBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInitialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        final Button initialLoginButton = binding.initialSignin;
        final Button initialRegisterButton = binding.registerInit;

        initialLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InitialActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        initialRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InitialActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}