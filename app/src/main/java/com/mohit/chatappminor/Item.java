package com.mohit.chatappminor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("blog")
    @Expose
    private Blog blog;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("labels")
    @Expose
    private List<String> labels = null;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("replies")
    @Expose
    private Replies replies;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("url")
    @Expose
    private String url;

    public String getKind() {
        return this.kind;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Blog getBlog() {
        return this.blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getPublished() {
        return this.published;
    }

    public void setPublished(String str) {
        this.published = str;
    }

    public String getUpdated() {
        return this.updated;
    }

    public void setUpdated(String str) {
        this.updated = str;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public void setSelfLink(String str) {
        this.selfLink = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Replies getReplies() {
        return this.replies;
    }

    public void setReplies(Replies replies) {
        this.replies = replies;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(List<String> list) {
        this.labels = list;
    }
}
