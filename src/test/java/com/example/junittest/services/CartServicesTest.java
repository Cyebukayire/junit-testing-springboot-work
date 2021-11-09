package com.example.junittest.services;


import com.example.junittest.models.Cart;
import com.example.junittest.repository.CartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CartServicesTest {

    @Mock
    CartRepository cartRepository;

    @InjectMocks
    CartService cartService;


    @Test
    public void returnCarts(){
        when(cartRepository.findAll()).thenReturn(Arrays.asList(new Cart(1,2,"5000"),new Cart(2,3,"900"),new Cart(3,4,"300")));
        assertEquals("300",cartService.getAllCarts().get(2).getTotalPrice());
    }

    @Test
    public  void createCart(){
        when(cartRepository.save(ArgumentMatchers.any(Cart.class))).thenReturn(new Cart(1,2,"44544"));
        assertEquals("4454",cartService.createCart(4,1,"4454").getTotalPrice());
    }

    @Test
    public void deleteCart(){
        Cart st = new Cart(5,3,"12000");
        when(cartRepository.findById(st.getId())).thenReturn(Optional.of(st));

        cartService.deleteCart(st.getId());

        verify(cartRepository).deleteById(st.getId());

    }

    @Test
    public void updateCart(){
        Cart st = new Cart(6,6,"3400000");
        Cart newST = new Cart(6, 7,"900000");
        given(cartRepository.findById(st.getId())).willReturn(Optional.of(st));

        cartService.updateCart(st.getId(),newST);
        verify(cartRepository).save(newST);
        verify(cartRepository).findById(st.getId());
    }

    @Test
    public void returnCart(){
        Cart cart = new Cart();
        cart.setId(2);

        when(cartRepository.findById(cart.getId())).thenReturn(Optional.of(cart));

        Cart expected = cartService.detailCart(Cart.getId());

        assertThat(expected).isSameAs(cart);

        verify(cartRepository).findById(cart.getId());
    }

}
