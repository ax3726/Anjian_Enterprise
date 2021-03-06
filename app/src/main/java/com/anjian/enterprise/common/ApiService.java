package com.anjian.enterprise.common;


import com.anjian.enterprise.model.home.HomeBannerModel;
import com.anjian.enterprise.model.home.HomeNewsModel;
import com.anjian.enterprise.model.main.LoginModel;
import com.anjian.enterprise.model.main.UserInfoModel;
import com.anjian.enterprise.model.manage.OnlineModel;
import com.anjian.enterprise.model.manage.QiYeCheckListModel;
import com.anjian.enterprise.model.manage.RiskModel;
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

    //广告轮播
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/cms/listHotSpot")
    Flowable<HomeBannerModel> getHomeBanner(@Query("token") String token);

    //获取新闻接口
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/cms/listPage")
    Flowable<HomeNewsModel> getHomeNews(@Body RequestBody body, @Query("token") String token);

    //获取标准化信息
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/enterpriseInfo/listFilePage")
    Flowable<StandardModel> getListFilePage(@Body RequestBody body, @Query("token") String token);

    //添加现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeExamine/add")
    Flowable<BaseBean> addQiYeCheck(@Body RequestBody body, @Query("token") String token);

    //现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeExamine/list")
    Flowable<QiYeCheckListModel> getQiYeCheckList(@Body RequestBody body, @Query("token") String token);


    //更新现场检查列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/localeExamine/update")
    Flowable<BaseBean> updateQiYeCheck(@Body RequestBody body, @Query("token") String token);

    //新增2.风险辨识
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/dangerIdentification/add")
    Flowable<BaseBean> addDangerIdentification(@Body RequestBody body, @Query("token") String token);

    //风险管控的列表
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/dangerIdentification/list/{id}")
    Flowable<RiskModel> getDangerIdentificationList(@Path("id") String id, @Query("token") String token);

    //今日待办
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/dangerIdentification/findNeedExamine/{id}")
    Flowable<RiskModel> getToDayList(@Path("id") String id, @Query("token") String token);


    //检查是否在检查周期里
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/dangerIdentification/status/{id}")
    Flowable<BaseBean> checkStatus(@Path("id") String id, @Query("token") String token);

    //在线咨询
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("security-monitor/app/sysArea/{id}")
    Flowable<OnlineModel> online(@Path("id") String id, @Query("token") String token);


    //增加风险确认
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("security-monitor/app/dangerIdentificationRecord/add")
    Flowable<BaseBean> addDangerIdentificationRecord(@Body RequestBody body, @Query("token") String token);
}
