package com.mohit.chatappminor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Replies {
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    @SerializedName("totalItems")
    @Expose
    private String totalItems;

    public String getTotalItems() {
        return this.totalItems;
    }

    public void setTotalItems(String str) {
        this.totalItems = str;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public void setSelfLink(String str) {
        this.selfLink = str;
    }
}
