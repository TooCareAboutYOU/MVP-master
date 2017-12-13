package com.mymvp.main;

import android.content.Context;

import retrofit2.Call;

/**
 * Created by admin on 2017/12/13.
 */

public class BalanceModel {

    private static BalanceModel balanceModel;
    private BalanceService mBalanceService;

    /**
     * Singleton
     */
    public static BalanceModel getInstance(Context context) {
        if (balanceModel == null) {
            balanceModel = new BalanceModel(context);
        }
        return balanceModel;
    }

    public BalanceModel(Context context) {
        mBalanceService =  HttpsServiceGenerator.createService(BalanceService.class);
    }

    public Call<GetBalanceResponse> getBalanceResponseCall(String accessToken) {
        Call<GetBalanceResponse> balanceResponseCall = mBalanceService.getBalance(accessToken);
        return balanceResponseCall;
    }

}
