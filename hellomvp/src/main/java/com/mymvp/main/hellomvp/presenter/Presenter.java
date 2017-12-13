package com.mymvp.main.hellomvp.presenter;

import com.mymvp.main.hellomvp.model.Model;
import com.mymvp.main.hellomvp.model.IModel;
import com.mymvp.main.hellomvp.bean.Person;
import com.mymvp.main.hellomvp.view.IView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class Presenter {

    private Model model;
    private IView mIView;

    public Presenter(IView iView) {
        this.model = new Model();
        this.mIView = iView;
    }

    public void load(){
        model.setData(new IModel.OnCompleteListener() {
            @Override
            public void onLoad(List<Person> list) {
                mIView.showView(list);
            }
        });
    }

    public void detachView(){
        this.mIView=null;
    }
}
