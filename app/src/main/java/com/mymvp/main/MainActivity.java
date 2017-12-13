package com.mymvp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void httpLoginRequest(String phone, String password) {

//        final Call<GetBalanceResponse> callLogin = loginModel.getLoginResponseCall(loginRequest);
//        callLogin.enqueue(new Callback<GetBalanceResponse>() {
//            @Override
//            public void onFailure(Call<GetBalanceResponse> calllist, Throwable t) {
//                callLogin.cancel();
//            }
//
//            @Override
//            public void onSuccess(Response<GetBalanceResponse> response) {
//                GetBalanceResponse loginResponse = response.body();
//
//                callLogin.cancel();
//            }
//
//            @Override
//            public void onNotFound() {
//                super.onNotFound();
//                callLogin.cancel();
//            }
//        });
    }

    private void httpBalanceRequest(String accessToken) {
        BalanceModel balanceModel = BalanceModel.getInstance(getApplicationContext());
        final Call<GetBalanceResponse> balanceResponseCall = balanceModel.getBalanceResponseCall(accessToken);
        balanceResponseCall.enqueue(new Callback<GetBalanceResponse>() {
            @Override
            public void onResponse(Call<GetBalanceResponse> calllist, Response<GetBalanceResponse> response) {
                GetBalanceResponse balanceResponse = response.body();

                balanceResponseCall.cancel();
            }

            @Override
            public void onFailure(Call<GetBalanceResponse> calllist, Throwable t) {
                balanceResponseCall.cancel();
            }

            @Override
            public void onSuccess(Response<GetBalanceResponse> response) {

            }

            @Override
            public void onNotFound() {
                super.onNotFound();
                balanceResponseCall.cancel();
            }
        });
    }

}
