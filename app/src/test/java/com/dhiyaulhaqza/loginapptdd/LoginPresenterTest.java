package com.dhiyaulhaqza.loginapptdd;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by dhiyaulhaqza on 5/31/17.
 */
public class LoginPresenterTest {

    @Test
    public void checkIfLoginAttemptIsExceeded() {
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertEquals(1, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(2, loginPresenter.incrementLoginAttempt());
        Assert.assertEquals(3, loginPresenter.incrementLoginAttempt());

        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void checkIfLoginAttemptIsNotExceeded()  {
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded());
    }

}