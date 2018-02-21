package com.apps.uca.androidretrofittest.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.apps.uca.androidretrofittest.R;
import com.apps.uca.androidretrofittest.models.PostPage;
import com.apps.uca.androidretrofittest.models.Posts;

public class isiAdapter extends RecyclerView.Adapter<isiAdapter.ViewHolder> {

        private List<Posts> data;

        public isiAdapter(PostPage data) {
            this.data = data.getData();
        }

        @Override
        public isiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_posts, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(isiAdapter.ViewHolder holder, int position) {
            Posts posts = data.get(position);

            if(posts.getMessage() != null){
                holder.message.setText(posts.getMessage());
            }else{
                holder.message.setText("");
            }

            if(posts.getMessage() != null){
                holder.story.setText(posts.getStory());
            }else{
                holder.story.setText(posts.getStory());
            }


            holder.createdTime.setText(posts.getCreatedTime());
            holder.id.setText(posts.getId());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView createdTime;
            TextView message;
            TextView story;
            TextView id;

            public ViewHolder(View itemView) {
                super(itemView);

                createdTime = itemView.findViewById(R.id.createdTime);
                message = itemView.findViewById(R.id.message);
                story = itemView.findViewById(R.id.story);
                id = itemView.findViewById(R.id.id);
            }
        }
    }

