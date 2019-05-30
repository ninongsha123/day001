package com.example.lenovo.day001.presenter;

import com.example.lenovo.day001.bean.WanBean;
import com.example.lenovo.day001.contract.Contract;

/**
 * Created by LENOVO on 2019/5/29.
 */

public class Presenter implements Contract.Presenter, Contract.CallBack {

    private Contract.Model model;
    private Contract.View view;

    public Presenter(Contract.Model model, Contract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData() {
        if (model!=null){
            model.getData(this);
        }
    }

    @Override
    public void onSuccess(WanBean bean) {
        view.onSuccess(bean);
    }

    @Override
    public void onFail(String msg) {
       view.onFail(msg);
    }
}
