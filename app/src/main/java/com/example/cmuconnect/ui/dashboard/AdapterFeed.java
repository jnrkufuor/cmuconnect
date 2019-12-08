package com.example.cmuconnect.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.cmuconnect.Model.ModelFeed;
import com.example.cmuconnect.R;

import java.util.ArrayList;

public class AdapterFeed extends RecyclerView.Adapter<AdapterFeed.MyViewHolder> {

    private Context context;
    private ArrayList<ModelFeed> feeds = new ArrayList();
    RequestManager rm;

    public AdapterFeed(Context context, ArrayList<ModelFeed> feeds){
        this.feeds = feeds;
        this.context = context;
        rm = Glide.with(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed,parent,false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ModelFeed mf = feeds.get(position);

        holder.comments.setText(String.valueOf(mf.getComments()));
        holder.upvotes.setText(String.valueOf(mf.getUpvotes()));
        holder.likes.setText(String.valueOf(mf.getLikes()));
        holder.community.setText(mf.getCommunity());
        holder.status.setText(mf.getStatus());
        holder.timestamp.setText(mf.getTimestamp());
        holder.name.setText(mf.getName());

        rm.load(mf.getProPic()).into(holder.profilepic);

        if(mf.getStatusPic()==0)
        {
            holder.statuspic.setVisibility(View.GONE);
        }
        else
        {
            holder.statuspic.setVisibility(View.VISIBLE);
            rm.load(mf.getStatusPic()).into(holder.statuspic);
        }

//        holder.profilepic.setText(mf.getComments());
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, community, likes, comments, status, timestamp, upvotes;
        ImageView profilepic, statuspic;
        public MyViewHolder(View v)
        {
            super(v);
            upvotes = v.findViewById(R.id.upvote_no);
            profilepic = v.findViewById(R.id.profile_img);
            statuspic =  v.findViewById(R.id.status_image);
            name = v.findViewById(R.id.profile_name);
            community = v.findViewById(R.id.community);
            likes = v.findViewById(R.id.likes_no);
            comments = v.findViewById(R.id.comments_no);
            status = v.findViewById(R.id.status);
            timestamp = v.findViewById(R.id.timestamp);

        }
    }
}
