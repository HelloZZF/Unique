package com.unique.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.unique.R;
import com.unique.bean.Env;
import com.unique.bean.Work;

import java.util.List;

/**
 * Created by zzf on 2018/9/13.
 */
public class item5_adapter extends RecyclerView.Adapter<item5_adapter.ViewHolder>{

    private List<Env> mEnvList;

    public item5_adapter(List<Env> envs) {

        mEnvList  = envs;
    }

    @NonNull
    @Override
    public item5_adapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_item5, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull item5_adapter.ViewHolder holder, int position) {

        Env env = mEnvList.get(position);
        holder.envImage.setImageResource(env.getImageurl());


    }

    @Override
    public int getItemCount() {
        return mEnvList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView envImage;


        public ViewHolder(View itemView) {
            super(itemView);

            envImage = itemView.findViewById(R.id.image5);

        }
    }
}
