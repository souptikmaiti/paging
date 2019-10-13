package com.example.pagingexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("answers")
    Call<StackApiResponse> getAnswers(@Query("page") Integer page,
                                      @Query("pagesize") Integer pageSize,
                                      @Query("site") String site);

}
