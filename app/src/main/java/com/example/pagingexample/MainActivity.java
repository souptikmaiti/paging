package com.example.pagingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton btnGet;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGet = findViewById(R.id.btnGet);
        recyclerView = findViewById(R.id.recyclerHolder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        btnGet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getAnswers();
            }
        });
    }

    private void getAnswers(){
        final ItemAdapter itemAdapter = new ItemAdapter(MainActivity.this);
        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        itemViewModel.getLivePagedList().observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(PagedList<Item> items) {
                itemAdapter.submitList(items);
            }
        });
        recyclerView.setAdapter(itemAdapter);
    }
}
