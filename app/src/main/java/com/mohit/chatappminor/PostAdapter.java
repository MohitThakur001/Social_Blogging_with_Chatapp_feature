package com.mohit.chatappminor;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class PostAdapter extends Adapter<PostAdapter.PostViewHolder> {
    private Context context;
    private List<Item> items;

    public class PostViewHolder extends ViewHolder {

        ImageView postImages;
        TextView postTopic;

        public PostViewHolder(@NonNull View view) {
            super(view);
            this.postTopic = (TextView) view.findViewById(R.id.postTitle);
            this.postImages = (ImageView) view.findViewById(R.id.postImage);
        }
    }

    public PostAdapter(List<Item> list, Context context) {
        this.items = list;
        this.context = context;
    }

    @NonNull
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PostViewHolder(LayoutInflater.from(this.context).inflate(R.layout.loading_post_item, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        final Item item = (Item) this.items.get(i);
        postViewHolder.postTopic.setText(item.getTitle());
        Document parse = Jsoup.parse(item.getContent());
        Glide.with(this.context).load(((Element) parse.select("img").get(0)).attr("src")).into(postViewHolder.postImages);
        postViewHolder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PostAdapter.this.context, DetailActivity.class);
                intent.putExtra(URL, item.getUrl());
                PostAdapter.this.context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return this.items.size();
    }
}
