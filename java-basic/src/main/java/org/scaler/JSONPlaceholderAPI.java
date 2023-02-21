package org.scaler;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface JSONPlaceholderAPI {

    @GET("posts")
    Call<List<Post>> getPosts();
}

