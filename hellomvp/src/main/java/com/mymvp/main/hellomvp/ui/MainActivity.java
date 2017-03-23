package com.mymvp.main.hellomvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mymvp.main.hellomvp.R;
import com.mymvp.main.hellomvp.bean.Person;
import com.mymvp.main.hellomvp.presenter.Presenter;
import com.mymvp.main.hellomvp.view.MvpView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv= (TextView) findViewById(R.id.tv_demo);
        new Presenter(new MvpView() {
            @Override
            public void showView(List<Person> list) {
                tv.setText(list.toString());
            }
        }).load();
    }
}
