package com.example.junittest.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    private Integer id;

    private String name;

    private String price;

    public Item() {
    }

    public Item(String name, String price) {
        this.name = name;
        this.name = price;
    }

    public Item(Integer id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
