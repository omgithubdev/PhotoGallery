package com.omagrahari.wiproassignment.network;

import com.omagrahari.wiproassignment.entity.ResponseComments;
import com.omagrahari.wiproassignment.entity.ResponsePhotos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by omprakash on 12,January,2020
 */
public interface ApiReference {

    @GET("services/rest/?method=flickr.photos.getRecent&nojsoncallback=1&format=json")
    Call<ResponsePhotos> getRecent(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("services/rest/?method=flickr.photos.comments.getList&nojsoncallback=1&format=json")
    Call<ResponseComments> getComments(@Query("api_key") String apiKey, @Query("photo_id") String id);
}
