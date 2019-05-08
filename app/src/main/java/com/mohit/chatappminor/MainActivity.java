package com.mohit.chatappminor;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    PostAdapter adapter;
    int currentItems;
    private DrawerLayout drawerLayout;
    Boolean isScrolling = Boolean.valueOf(false);
    List<Item> items = new ArrayList();
    LinearLayoutManager manager;
    private NavigationView navigationView;
    ProgressBar progress;
    RecyclerView recyclerView;
    int scrollOutItems;
    String token = "";
    private Toolbar toolbar;
    int totalItems;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        this.recyclerView = (RecyclerView) findViewById(R.id.postListRecycler);
        this.progress = (ProgressBar) findViewById(R.id.spin_kit);
        this.manager = new LinearLayoutManager(this);
        this.adapter = new PostAdapter(this.items, this);
        this.recyclerView.setLayoutManager(this.manager);
        this.recyclerView.setAdapter(this.adapter);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle((CharSequence) "Blogger");

        this.recyclerView.addOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    MainActivity.this.isScrolling = Boolean.valueOf(true);
                }
            }

            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                MainActivity.this.currentItems = MainActivity.this.manager.getChildCount();
                MainActivity.this.totalItems = MainActivity.this.manager.getItemCount();
                MainActivity.this.scrollOutItems = MainActivity.this.manager.findFirstCompletelyVisibleItemPosition();
                if (MainActivity.this.isScrolling.booleanValue() && MainActivity.this.currentItems + MainActivity.this.scrollOutItems == MainActivity.this.totalItems) {
                    MainActivity.this.isScrolling = Boolean.valueOf(false);
                    MainActivity.this.getData();
                }
            }
        });
        getData();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_icon, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.actionBarDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        if (menuItem.getItemId() == R.id.chat) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://tlk.io/alpha_tech")));
        }
        return super.onOptionsItemSelected(menuItem);
    }



    @SuppressLint("WrongConstant")
    private void getData() {
        String str = "https://www.googleapis.com/blogger/v3/blogs/176799618324544617/posts?key=AIzaSyCTWjNd_bjTxVndgkj7HKDdqSMsJC0LH_M";
        if (this.token != "") {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&pageToken=");
            stringBuilder.append(this.token);
            str = stringBuilder.toString();
        }
        if (this.token != null) {
            this.progress.setVisibility(0);
            BloggerAPI.getService().getPostList(str).enqueue(new Callback<PostList>() {
                public void onResponse(Call<PostList> call, Response<PostList> response) {
                    PostList postList = (PostList) response.body();
                    MainActivity.this.token = postList.getNextPageToken();
                    MainActivity.this.items.addAll(postList.getItems());
                    MainActivity.this.adapter.notifyDataSetChanged();
                    MainActivity.this.progress.setVisibility(8);
                }

                public void onFailure(Call<PostList> call, Throwable th) {
                    MainActivity.this.progress.setVisibility(8);
                    Snackbar.make(MainActivity.this.findViewById(R.id.b), (CharSequence) "Error: No Internet Connection! ", -2).setAction((CharSequence) "Refresh", new View.OnClickListener() {
                        public void onClick(View view) {
                            Snackbar.make(MainActivity.this.drawerLayout, (CharSequence) "Successfully refreshed!", -1).show();
                            MainActivity.this.getData();
                        }
                    }).setActionTextColor(-16711936).show();
                }
            });
        }
    }
}