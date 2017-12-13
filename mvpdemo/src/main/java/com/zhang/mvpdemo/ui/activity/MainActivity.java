package com.zhang.mvpdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zhang.mvpdemo.R;
import com.zhang.mvpdemo.bean.LoginBean;
import com.zhang.mvpdemo.mvp.presenter.LoginPresenter;
import com.zhang.mvpdemo.mvp.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private Button btnlogin;
    private EditText etpwd, etaccout;
    private ProgressBar mProgressBar;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new LoginPresenter(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login();
            }
        });
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        btnlogin = (Button) findViewById(R.id.btn_login);
        etpwd = (EditText) findViewById(R.id.et_pwd);
        etaccout = (EditText) findViewById(R.id.et_accout);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public LoginBean getLoginData() {
        return new LoginBean(etaccout.getText().toString(), etpwd.getText().toString());
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "登录成功了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onLoading(boolean isFinish) {
        if (isFinish) {
            mProgressBar.setVisibility(View.VISIBLE);
        }else {
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
