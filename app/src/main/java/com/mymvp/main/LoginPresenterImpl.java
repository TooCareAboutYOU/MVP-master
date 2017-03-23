package com.mymvp.main;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginModel.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    /**
     * 校验用户名和密码
     *
     * */
    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null){
            loginView.showProgress();
        }
        loginModel.login(username,password,this);
    }

    @Override
    public void onDestroy() {
        loginView=null;
    }

    /**
     * 用户名错误
     * */
    @Override
    public void onUsernameError() {
        if (loginView != null){
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    /**
     * 密码错误
     * */
    @Override
    public void onPasswordError() {
        if (loginView != null){
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null){
            loginView.navigateToHome();
        }
    }
}
