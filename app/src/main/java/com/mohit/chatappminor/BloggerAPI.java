package com.mohit.chatappminor;

import retrofit2.Call;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class BloggerAPI {
    public static final String key = "AIzaSyCTWjNd_bjTxVndgkj7HKDdqSMsJC0LH_M";
    public static PostService postService = null;
    public static final String url = "https://www.googleapis.com/blogger/v3/blogs/176799618324544617/posts/";

    public interface PostService {
        @GET
        Call<PostList> getPostList(@Url String str);
    }

    public static PostService getService() {
        if (postService == null) {
            postService = (PostService) new Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build().create(PostService.class);
        }
        return postService;
    }
}
