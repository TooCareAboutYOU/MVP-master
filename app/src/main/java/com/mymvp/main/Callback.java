package com.mymvp.main;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by admin on 2017/12/13.
 */

public abstract class Callback<T extends Object> implements retrofit2.Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.raw().code() == 200){
            Log.i("internet response","200");
            onSuccess(response);
        }else if (response.raw().code() == 404){
            Log.i("internet response","404");
            onNotFound();
        }
    }

    @Override
    public  void onFailure(Call<T> call, Throwable t) {

    }


    public abstract void onSuccess(Response<T> response);

    public void onNotFound(){
        return;
    }
}
