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
import com.unique.bean.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzf on 2018/5/15.
 */
public class item4_adapter extends RecyclerView.Adapter<item4_adapter.ViewHolder>{

    private List<Work> mWorkList;

    public item4_adapter(List<Work> works) {

        mWorkList  = works;
    }

    @NonNull
    @Override
    public item4_adapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_item4, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(), "可惜了，我并没有内容", Toast.LENGTH_SHORT).show();
            }
        });

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull item4_adapter.ViewHolder holder, int position) {

        Work work = mWorkList.get(position);
        holder.workAuthor.setText(work.getAuthor());
        holder.workIntroduce.setText(work.getIntroduce());
        holder.workName.setText(work.getName());
        holder.workImage.setImageResource(work.getImageurl());

    }

    @Override
    public int getItemCount() {
        return mWorkList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView workImage;
        TextView workName;
        TextView workIntroduce;
        TextView workAuthor;

        public ViewHolder(View itemView) {
            super(itemView);

            workImage = itemView.findViewById(R.id.image);
            workName = itemView.findViewById(R.id.name);
            workIntroduce = itemView.findViewById(R.id.introduce);
            workAuthor = itemView.findViewById(R.id.author);

        }
    }
}
