package com.dhiyaulhaqza.loginapptdd;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dhiyaulhaqza.loginapptdd.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private ActivityLoginBinding binding;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        presenter = new LoginPresenter(this);
    }

    @Override
    public void showMessageErrorMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Login success~", Toast.LENGTH_SHORT).show();
    }

    public void btnLoginClick(View view) {
        String username = binding.etUsername.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();

        presenter.doLogin(username, password);
    }
}
