package com.example.startupfacbook;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface data_access {
    @GET("posts")
    Observable<List<post_model>> getposts();

    @POST("posts")
    void setpost(post_model post_model);
}
