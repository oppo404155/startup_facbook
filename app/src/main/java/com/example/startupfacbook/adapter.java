package com.example.startupfacbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
    private List<post_model> post_model_list = new ArrayList<>();

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,null,false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        post_model postModel = post_model_list.get(position);
        holder.user_description.setText(postModel.getBody());
        holder.user_title.setText(postModel.getTitle());
        holder.user_id.setText(String.valueOf(postModel.getUserId()));


    }

    @Override
    public int getItemCount() {
        return post_model_list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView user_id;
        TextView user_title;
        TextView user_description;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            user_id = itemView.findViewById(R.id.userIDTV);
            user_title = itemView.findViewById(R.id.titleTV);
            user_description = itemView.findViewById(R.id.bodyTV);


        }
    }

    public void setlist(List<post_model> list) {
        this.post_model_list = list;
        notifyDataSetChanged();

    }
}
