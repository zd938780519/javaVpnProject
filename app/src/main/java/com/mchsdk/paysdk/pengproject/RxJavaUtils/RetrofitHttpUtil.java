package com.mchsdk.paysdk.pengproject.RxJavaUtils;


public class RetrofitHttpUtil {
    public static ApiService getApiService() {
        return RetrofitHelper.getRetrofit().create(ApiService.class);
    }
}
