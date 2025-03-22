package com.example.listapp.service;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.listapp.dao.IDao;
import com.example.listapp.model.Star;

import java.util.ArrayList;
import java.util.List;

public class StarService implements IDao<Star> {
    private List<Star> stars = new ArrayList<>();
    private static StarService instance;

    private StarService() {}

    public static StarService getInstance() {
        if (instance == null) instance = new StarService();
        return instance;
    }

    @Override
    public boolean create(Star o) { return stars.add(o); }
    @Override
    public boolean update(Star o) {
        for (Star s : stars) {
            if (s.getId() == o.getId()) {
                s.setStar(o.getStar());
            }
        }
        return true;
    }
    @Override
    public boolean delete(Star o) { return stars.remove(o); }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Star findById(int id) { return stars.stream().filter(s -> s.getId() == id).findFirst().orElse(null); }
    @Override
    public List<Star> findAll() { return stars; }
}
