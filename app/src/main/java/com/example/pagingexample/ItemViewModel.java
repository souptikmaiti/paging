package com.example.pagingexample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import static com.example.pagingexample.ItemDataSource.PAGE_SIZE;

public class ItemViewModel extends ViewModel {
    private LiveData<PagedList<Item>> livePagedList;
    private LiveData<PageKeyedDataSource<Integer,Item>> liveItemDataSource;

    public ItemViewModel() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveItemDataSource = itemDataSourceFactory.getLiveItemDataSource();

        PagedList.Config config = new PagedList.Config.Builder()     //used to build PagedList
                .setEnablePlaceholders(false)
                .setPageSize(PAGE_SIZE)
                .build();

        livePagedList = new LivePagedListBuilder(itemDataSourceFactory,config).build();
    }

    public LiveData<PagedList<Item>> getLivePagedList() {
        return livePagedList;
    }
}
