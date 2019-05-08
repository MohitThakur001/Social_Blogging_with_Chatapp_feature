package com.mohit.chatappminor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostList {
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;

    public String getKind() {
        return this.kind;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> list) {
        this.items = list;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public void setNextPageToken(String str) {
        this.nextPageToken = str;
    }
}
