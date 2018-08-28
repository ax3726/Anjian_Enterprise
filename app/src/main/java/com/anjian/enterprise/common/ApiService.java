package com.anjian.enterprise.common;


import com.anjian.enterprise.model.main.LoginModel;
import com.anjian.enterprise.model.main.UserInfoModel;
import com.anjian.enterprise.model.manage.StandardModel;
import com.lm.lib_common.model.BaseBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


/**
 * Created by lm on 2017/11/22.
 * Description:
 * 人口密集场所是 /app/pdpInfo 开头的  出租屋是/app/letInfo开头的  其他场所是/app/otpInfo 开头的
 */

public interface ApiService {

    @GET()
    Flowable<ResponseBody> downloadFile(@Url String url);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/login")
    Flowable<LoginModel> login(@Body RequestBody body);

    //获取用户信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/user/info")
    Flowable<UserInfoModel> getUserInfo(@Query("token") String token);

    //获取标准化信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/enterpriseInfo/listFilePage")
    Flowable<StandardModel> getListFilePage(@Body RequestBody body, @Query("token") String token);


}
