package com.mymvp.main.hellomvp.model;

import com.mymvp.main.hellomvp.bean.Person;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public interface IModel {

    public interface OnCompleteListener{
        void onLoad(List<Person> list);
    }
}
