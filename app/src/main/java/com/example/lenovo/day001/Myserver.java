package com.example.lenovo.day001;

import com.example.lenovo.day001.bean.WanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by LENOVO on 2019/5/29.
 */

public interface Myserver {
    String Url ="http://www.wanandroid.com/article/list/0/";

    @GET("json")
    Observable<WanBean> getWan();
}
