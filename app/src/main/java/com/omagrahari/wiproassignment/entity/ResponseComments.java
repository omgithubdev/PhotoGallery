package com.omagrahari.wiproassignment.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by omprakash on 13,January,2020
 */
public class ResponseComments {
    @SerializedName("comments")
    Comments comments;

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }
}
