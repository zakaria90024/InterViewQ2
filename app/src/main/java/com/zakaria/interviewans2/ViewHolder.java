package com.zakaria.interviewans2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    ImageView imageViewthumb;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        //for onclock
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v,getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());
                return false;
            }
        });

        name = itemView.findViewById(R.id.textView_title);
        imageViewthumb = itemView.findViewById(R.id.imageView_id);

    }

    private ViewHolder.ClickListener mClickListener;
    //interface for click listener
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    public void setOnClickListener(com.zakaria.interviewans2.ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }


}
