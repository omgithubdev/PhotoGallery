package com.omagrahari.wiproassignment.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by omprakash on 13,January,2020
 */
public class Comments {
    @SerializedName("photo_id")
    String photo_id;
    @SerializedName("comment")
    ArrayList<Comment> comment = new ArrayList<>();

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }
}
