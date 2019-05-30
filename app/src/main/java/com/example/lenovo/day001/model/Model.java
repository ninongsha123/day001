package com.example.lenovo.day001.model;

import com.example.lenovo.day001.Myserver;
import com.example.lenovo.day001.bean.WanBean;
import com.example.lenovo.day001.contract.Contract;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LENOVO on 2019/5/29.
 */

public class Model implements Contract.Model {
    @Override
    public void getData(final Contract.CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Myserver.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Myserver myserver = retrofit.create(Myserver.class);
        Observable<WanBean> wan = myserver.getWan();
        wan.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WanBean bean) {
                       callBack.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                          callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
