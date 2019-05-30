package com.example.lenovo.day001.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.day001.R;
import com.example.lenovo.day001.bean.WanBean;

import java.util.ArrayList;

/**
 * Created by LENOVO on 2019/5/29.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;
    private ArrayList<WanBean.DataEntity.DatasEntity> list;

    public MyAdapter(Context context, ArrayList<WanBean.DataEntity.DatasEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =View.inflate(context, R.layout.lv_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         holder.txt.setText(list.get(position).getTitle());
         holder.athor.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getEnvelopePic())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txt;
        private TextView athor;
        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            txt=itemView.findViewById(R.id.txt);
            athor=itemView.findViewById(R.id.athor);
        }
    }
}
