package com.mymvp.main;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by admin on 2017/12/13.
 */

public interface BalanceService {

    @GET("balance")
    Call<GetBalanceResponse> getBalance(@Header("AccessToken") String accessToken);

    @POST("balance/detail")
    Call<GetTradeDetailResponse> getDetail(@Header("AccessToken") String accessToken , @Body GetTradeDetailRequest tradeDetailRequest);

}
