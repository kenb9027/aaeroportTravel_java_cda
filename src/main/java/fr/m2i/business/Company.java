package fr.m2i.business;

import java.util.ArrayList;
import java.util.UUID;

public class Company {

    private Long id;
    private String name;

    private ArrayList<Fly> flies ;

    public Company() {
        super();
        this.flies = new ArrayList<Fly>();
    }

    public Company(String name) {
        this();
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company " + name ;
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
