package com.anjian.enterprise.common;




import com.anjian.enterprise.utils.MD5;
import com.lm.lib_common.net.DownloadResponseBody;
import com.lm.lib_common.net.GsonConverterFactory;
import com.lm.lib_common.net.LoggerInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;



/**
 * Created by Administrator on 2017/9/21.
 */

public class Api {

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static ApiService apiService;


    public static ApiService getApi() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(Link.SEREVE)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }

    public static String getKeyStr(Map<String, String> params) {
        List<Map.Entry<String, String>> list =
                new ArrayList<Map.Entry<String, String>>(params.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return (o1.getKey().compareTo(o2.getKey()));
            }
        });
        String signStr = "gzqnkj";
        for (Map.Entry<String, String> map : list) {
            signStr = signStr + map.getKey() + map.getValue();
        }
        signStr = signStr + "gzqnkj";
        return MD5.toMD5Sign(signStr);

    }
  /*  *//**
     * 从 {@link Request#header(String)} 中取出 NoSign
     *
     * @param   {@link Request}
     * @return NoSign
     *//*
    private static String obtainNoSignNameFromHeaders(Request request) {
        List<String> headers = request.headers(NO_SIGN);
        if (headers == null || headers.size() == 0)
            return null;
        if (headers.size() > 1)
            throw new IllegalArgumentException("Only one NoSign-Name in the headers");
        return request.header(NO_SIGN);
    }*/

    public static OkHttpClient getOkHttpClient(final DownloadResponseBody.DownLoadListener... downLoadListener) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
               .addInterceptor(new LoggerInterceptor("msg", true))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS);

        if (downLoadListener.length > 0) {
            builder.addNetworkInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response originalResponse = chain.proceed(chain.request());
                    DownloadResponseBody downloadResponseBody = new DownloadResponseBody(originalResponse.body(), downLoadListener[0]);
                    return originalResponse.newBuilder().body(downloadResponseBody).build();
                }
            });
        }
        return builder.build();
    }

    public static ApiService getDownLoadApi(String url, final DownloadResponseBody.DownLoadListener downLoadListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getOkHttpClient(downLoadListener))
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();

        return retrofit.create(ApiService.class);
    }
}
