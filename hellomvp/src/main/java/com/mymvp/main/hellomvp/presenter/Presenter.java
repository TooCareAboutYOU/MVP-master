package com.mymvp.main.hellomvp.presenter;

import com.mymvp.main.hellomvp.model.Model;
import com.mymvp.main.hellomvp.model.MvpModel;
import com.mymvp.main.hellomvp.bean.Person;
import com.mymvp.main.hellomvp.view.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class Presenter {

    private Model model;
    private MvpView mvpView;

    public Presenter(MvpView mvpView) {
        this.model = new Model();
        this.mvpView = mvpView;
    }

    public void load(){
        model.setData(new MvpModel.OnCompleteListener() {
            @Override
            public void onLoad(List<Person> list) {
                mvpView.showView(list);
            }
        });
    }
}
