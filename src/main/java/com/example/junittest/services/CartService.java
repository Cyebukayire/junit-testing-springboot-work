package com.example.junittest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }

    public Cart createCart(Integer id, Integer itemsCounter, Integer totalPrice){
        Cart cart = new Cart(id, itemsCounter, totalPrice);

        return cartRepository.save(cart);
    }

    public void deleteCart(Integer id){
        cartRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("Cart not found with id"+ id));
        cartRepository.deleteById(id);
    }

    public Cart updateCart(Integer id, Cart cart){
        cartRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cart not found with id"+ id));

        cart.setId(id);

        return cartRepository.save(cart);

    }

    public Cart detailCart(Integer id){
        return cartRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Cart with id "+id+ " not found!"));
    }

//    public Cart addToCart(Integer id)
}
