package com.mohit.chatappminor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Blog {
    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
