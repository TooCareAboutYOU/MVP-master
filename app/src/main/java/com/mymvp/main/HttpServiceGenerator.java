package com.mymvp.main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 链接：http://www.jianshu.com/p/a3fed8138457
 * Created by admin on 2017/12/13.
 * API_BASE_URL 用来配置api主地址
 * READ_TIMEOUT 用来配置读取超时时间
 * WRIT_TIMEOUT 用来配置写超时时间
 * CONNECT_TIMEOUT 用来配置连接超时时间
 8 addConverterFactory() 用来设置解析器，此处我们设置的是gson的解析
 * addInterceptor() 用来设置日志拦截器
 */

public class HttpServiceGenerator {

    public static final String API_BASE_URL = "";
    public static int READ_TIMEOUT = 60;
    public static int WRIT_TIMEOUT = 60;
    public static int CONNECT_TIMEOUT = 60;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
            .writeTimeout(WRIT_TIMEOUT,TimeUnit.SECONDS)//设置写的超时时间
            .connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS);

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        if (authToken != null) {
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpClient
                // 日志拦截器
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

}
