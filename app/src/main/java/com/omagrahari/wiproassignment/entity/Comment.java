package com.omagrahari.wiproassignment.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omprakash on 13,January,2020
 */
public class Comment {
    @SerializedName("id")
    String id;
    @SerializedName("authorname")
    String authorname;
    @SerializedName("_content")
    String _content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }
}
