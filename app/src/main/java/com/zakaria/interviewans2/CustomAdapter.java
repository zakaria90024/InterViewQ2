package com.zakaria.interviewans2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.target.Target;
import com.zakaria.interviewans2.main.model.Post;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<com.zakaria.interviewans2.ViewHolder> {

    MainActivity readActivity;
    public List<Post> posts;

    public CustomAdapter(MainActivity readActivity, List<Post> posts) {
        this.readActivity = readActivity;
        this.posts = posts;
    }
    public void setData(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public com.zakaria.interviewans2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //for passing/inflate layoute
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        com.zakaria.interviewans2.ViewHolder viewHolder = new com.zakaria.interviewans2.ViewHolder(itemView);

        //handle item click here
        viewHolder.setOnClickListener(new com.zakaria.interviewans2.ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(readActivity);
                String[] option = {"Update", "Delete"};
                builder.setItems(option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        if(which == 0){
//                            //update is called
//                            Integer id = posts.get(position).getId();
//                            String name = posts.get(position).getName();
//
//                            //Intent to start activity
//                            Intent intent = new Intent(readActivity, MainActivity.class);
//                            //put data in intent
//                            intent.putExtra("id", id);
//                            intent.putExtra("name", name);
//                            intent.putExtra("email", email);
//                            intent.putExtra("number", number);
//                            intent.putExtra("cash", cash);
//                            intent.putExtra("address", address);
//                            intent.putExtra("state", state);
//                            intent.putExtra("zip", zip);
//                            intent.putExtra("role", role);
//                            intent.putExtra("time", time);
//                            //start activity
//                            readActivity.startActivity(intent);
//
//                        }
//                        if (which == 1) {
//                            Post post = posts.get(position);
//                            Integer id = post.getId();
//                            readActivity.deleteData(id);
//                        }
                    }
                }).create().show();

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.zakaria.interviewans2.ViewHolder holder, int position) {
        //name, email, number, cash, address, state, zip, role;
        Post post = posts.get(position);
        String title = post.getTitle();
        String thumbnel = post.getThumbnailUrl();

        holder.name.setText(title);

        //holder..setText(monako_details);

        //String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/category/";
        //String imageUrl = IMAGE_BASE_URL + dress_image_url;

        GlideUrl url = new GlideUrl(thumbnel, new LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build());

        Glide
                .with(readActivity)
                .load(url)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageViewthumb);
    }

    @Override
    public int getItemCount()  {
        return posts.size();
    }
}
