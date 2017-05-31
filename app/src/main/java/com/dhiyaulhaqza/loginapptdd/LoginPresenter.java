package com.dhiyaulhaqza.loginapptdd;

/**
 * Created by dhiyaulhaqza on 5/31/17.
 */

public class LoginPresenter {

    private LoginView loginView;
    public static final int MAX_LOGIN_ATTEMPT = 3;
    private int loginAttempt;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public int incrementLoginAttempt()  {
        loginAttempt = loginAttempt + 1;
        return loginAttempt;
    }

    public boolean isLoginAttemptExceeded() {
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }

    public void doLogin(String username, String password)   {
        if (isLoginAttemptExceeded())   {
            loginView.showMessageErrorMessage("Login Attempt Exceeded");
            return;
        }

        if (username.equals("ulhaq") && password.equals("password"))    {
            loginView.onSuccess();
            return;
        }

        incrementLoginAttempt();
        loginView.showMessageErrorMessage("Username or password not match");
    }
}
