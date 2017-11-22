package com.mymvp.main.hellomvp.model;

import com.mymvp.main.hellomvp.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class Model {

    public void setData(IModel.OnCompleteListener listener){

        List<Person> list=new ArrayList<Person>();
        for (int i = 0; i < 5; i++) {
            Person person=new Person();
            person.setName("老"+(i+1));
            person.setAge("1"+i);
            person.setSex("女");
            person.setHeight("17"+i);
            list.add(person);
        }

        listener.onLoad(list);
    }
}
