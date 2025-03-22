package com.example.listapp;


import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listapp.adapter.StarAdapter;
import com.example.listapp.model.Star;
import com.example.listapp.service.StarService;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StarAdapter adapter;
    private StarService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recycle_view);
        service = StarService.getInstance();

        service.create(new Star("Leonardo DiCaprio", "https://image.tmdb.org/t/p/original/ts9l18VkDSooRGDWIeQegNVHciC.jpg", 5.0f));
        service.create(new Star("Angelina Jolie", "https://image.tmdb.org/t/p/original/bXNxIKcJ5cNNW8QFrBPWcfTSu9x.jpg", 4.5f));
        service.create(new Star("John Cena", "https://image.tmdb.org/t/p/original/rgB2eIOt7WyQjdgJCOuESdDlrjg.jpg", 5.0f)); // Updated with a different image link




        adapter = new StarAdapter(this, service.findAll());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);  // Inflate your menu here
        return true;
    }
}