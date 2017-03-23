package com.mymvp.main.hellomvp.view;

import com.mymvp.main.hellomvp.bean.Person;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public interface MvpView {
    void showView(List<Person> list);
}
