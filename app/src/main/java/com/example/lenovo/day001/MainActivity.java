package com.example.lenovo.day001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lenovo.day001.adapter.MyAdapter;
import com.example.lenovo.day001.bean.WanBean;
import com.example.lenovo.day001.contract.Contract;
import com.example.lenovo.day001.model.Model;
import com.example.lenovo.day001.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

//王庆
public class MainActivity extends AppCompatActivity implements Contract.View {

    private static final String TAG = MainActivity.class.getName();
    private RecyclerView mLv;
    private ArrayList<WanBean.DataEntity.DatasEntity> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Contract.Presenter presenter =new Presenter(new Model(),this);
        presenter.getData();
    }

    private void initView() {
        mLv = (RecyclerView) findViewById(R.id.lv);
        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);
        mLv.setLayoutManager(new LinearLayoutManager(this));
        mLv.setAdapter(adapter);

    }

    @Override
    public void onSuccess(WanBean bean) {
        List<WanBean.DataEntity.DatasEntity> datas = bean.getData().getDatas();
        list.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: "+msg );
    }
}
