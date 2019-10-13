package com.example.pagingexample;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Item> {
    private static final Integer FIRST_PAGE = 1;
    public static final Integer PAGE_SIZE = 50;
    public static final String SITE_NAME = "stackoverflow" ;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {
        RetrofitClient.getInstance()
                .getJsonPlaceHolderApi()
                .getAnswers(FIRST_PAGE,PAGE_SIZE,SITE_NAME)
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if(response.body() != null){
                            callback.onResult(response.body().getItems(),null,FIRST_PAGE+1);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {

        RetrofitClient.getInstance()
                .getJsonPlaceHolderApi()
                .getAnswers(params.key,PAGE_SIZE,SITE_NAME)
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if(response.body()!=null){
                            callback.onResult(response.body().getItems(),params.key > 1 ? params.key -1 : null);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {

        RetrofitClient.getInstance()
                .getJsonPlaceHolderApi()
                .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if(response.body()!=null){
                            callback.onResult(response.body().getItems(),response.body().isHasMore()?params.key+1:null);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {

                    }
                });

    }
}
