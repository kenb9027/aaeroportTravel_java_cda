package fr.m2i.business;

import java.util.ArrayList;
import java.util.UUID;

public class Airport {

    private Long id;
    private String name;

    private ArrayList<Fly> flies;

    public Airport() {
        super();
        this.flies = new ArrayList<Fly>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " Airport";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Fly> getFlies() {
        return flies;
    }

    public void setFlies(ArrayList<Fly> flies) {
        this.flies = flies;
    }
}
