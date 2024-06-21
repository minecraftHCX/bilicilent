package com.RobinNotBad.BiliClient.adapter.user;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.RobinNotBad.BiliClient.R;
import com.RobinNotBad.BiliClient.activity.user.info.UserInfoActivity;
import com.RobinNotBad.BiliClient.model.UserInfo;
import com.RobinNotBad.BiliClient.util.GlideUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

//关注列表
//2023-08-29

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.Holder> {

    final Context context;
    final ArrayList<UserInfo> userList;

    public UserListAdapter(Context context, ArrayList<UserInfo> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.cell_user_list,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(userList.get(position).name);
        holder.desc.setText(userList.get(position).sign);

        if(userList.get(position).avatar.isEmpty()) {
            holder.avatar.setVisibility(View.GONE);
            holder.desc.setSingleLine(false);
        }
        else Glide.with(context).asDrawable().load(GlideUtil.url(userList.get(position).avatar))
                .placeholder(R.mipmap.akari)
                .apply(RequestOptions.circleCropTransform())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.avatar);

        if(userList.get(position).mid != -1) {
            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent()
                        .setClass(context, UserInfoActivity.class)
                        .putExtra("mid", userList.get(position).mid);
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        final TextView name;
        final TextView desc;
        final ImageView avatar;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            desc = itemView.findViewById(R.id.userDesc);
            avatar = itemView.findViewById(R.id.userAvatar);
        }
    }
}
