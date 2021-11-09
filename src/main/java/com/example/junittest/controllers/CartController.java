package com.example.junittest.controllers;


import com.example.junittest.models.Cart;
import com.example.junittest.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService CartService;

    @GetMapping("/get-all")
    public List<Cart> getAll(){
        return cartService.getAllCarts();
    }

    @PostMapping("/add-Cart")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.createCart(cart.getId(), cart.getItemsCounter(), cart.getTotalPrice());
    }
}
