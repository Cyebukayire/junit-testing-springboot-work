package com.example.junittest.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    private Integer id;

    private Integer itemsCounter;

    private String totalPrice;

    private  Integer item_id;

    private Integer item_price;

    public Cart() {
    }

    public Cart(Integer id, Integer item_id, Integer item_price) {
        this.id = id;
        this.item_id = item_id;
        this.item_price = item_price;
    }

    public Cart(Integer id, Integer itemsCounter, String totalPrice) {
        this.id = id;
        this.itemsCounter = itemsCounter;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getItemsCounter() { return itemsCounter; }

    public void setItemsCounter(String items_counter) {
        this.itemsCounter = itemsCounter;
    }


    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }


}


