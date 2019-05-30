package com.example.lenovo.day001.contract;

import com.example.lenovo.day001.bean.WanBean;

/**
 * Created by LENOVO on 2019/5/29.
 */

public interface Contract {
    interface Model {
        void getData(CallBack callBack);
    }

    interface View {
        void onSuccess(WanBean bean);

        void onFail(String msg);
    }

    interface Presenter {
        void getData();
    }
    interface CallBack{
        void onSuccess(WanBean bean);

        void onFail(String msg);
    }
}
