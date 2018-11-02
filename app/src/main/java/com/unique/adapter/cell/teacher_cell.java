package com.unique.adapter.cell;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.unique.R;
import com.unique.adapter.base.RVBaseAdapter;
import com.unique.adapter.base.RVBaseCell;
import com.unique.adapter.base.RVBaseViewHolder;
import com.unique.bean.Teacher;

import java.util.List;

/**
 * Created by zzf on 2018/5/17.
 */
public class teacher_cell extends RVBaseCell{

    private ObjectAnimator animator;

    private List<Teacher> mTeachers;

    private AlertDialog.Builder mDialog;

    private Context mContext;

    public teacher_cell(List<Teacher> teachers, Context context) {
        super(teachers);
        mTeachers = teachers;
        mContext = context;
    }

    @Override
    public int getItemType() {
        return 88;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType, RVBaseAdapter.OnItemClickListener listener) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_teacher, parent, false);
        return new RVBaseViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(final RVBaseViewHolder holder, final int position) {
        View view = holder.getView(R.id.teacher_layout);
        if (animator == null) {

        animator = ObjectAnimator.ofFloat(view, "rotationX", 180F, 0F)
                .setDuration(600);
        }


        holder.getImageView(R.id.icon).setImageResource(mTeachers.get(position).getIcon());
        holder.getTextView(R.id.name).setText(mTeachers.get(position).getName());
        holder.getTextView(R.id.introduce).setText(mTeachers.get(position).getIntroduce());
        holder.getTextView(R.id.time).setText(mTeachers.get(position).getTime());

        mDialog = new AlertDialog.Builder(mContext);
        Button yyButton = holder.getButton(R.id.yy);
        yyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.setTitle("请确认信息");
                mDialog.setMessage("授课老师: " + mTeachers.get(position).getName() + "\n" +"上课时间: " + mTeachers.get(position).getTime());
                mDialog.setCancelable(false);
                mDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "预约成功", Toast.LENGTH_SHORT).show();
                    }
                });
                mDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mContext, "预约取消", Toast.LENGTH_SHORT).show();
                    }
                });
                mDialog.show();
            }
        });
        Button dyButton = holder.getButton(R.id.dy);
        dyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "订阅成功", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void startAnimator() {

        if (animator != null)
            animator.start();
    }
}
