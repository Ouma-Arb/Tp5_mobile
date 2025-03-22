package com.example.listapp.model;

public class Star {
    private int id;
    private String name;
    private String img;
    private float star;
    private static int comp;

    public Star(String name, String img, float star) {
        this.id = ++comp;
        this.name = name;
        this.img = img;
        this.star = star;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getImg() { return img; }
    public float getStar() { return star; }

    public void setStar(float star) { this.star = star; }
}