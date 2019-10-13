package com.example.pagingexample;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer,Item>> liveItemDataSource = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        liveItemDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Item>> getLiveItemDataSource() {
        return liveItemDataSource;
    }
}
