package com.bytelogs.antarikshdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by jeeva on 21/09/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{

    private Context context;
    private List<Article> data;

    public NewsAdapter(Context context, List<Article> data){
            this.context = context;
            this.data = data;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_news,parent,false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {

        Article news = data.get(position);
        holder.newsTitle.setText(news.getTitle());
        Glide.with(holder.newsImage.getContext()).load(news.getUrlToImage()).into(holder.newsImage);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{

        ImageView newsImage;
        TextView newsTitle;

        public NewsHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView)itemView.findViewById(R.id.newsImage);
            newsTitle = (TextView)itemView.findViewById(R.id.newsTitle);
        }
    }
}
