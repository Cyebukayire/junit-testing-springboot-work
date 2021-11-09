package com.example.junittest.services;


import com.example.junittest.models.Item;
import com.example.junittest.repository.ItemRepository;
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
public class ItemServicesTest {

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemService itemService;


    @Test
    public void returnItems(){
        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1,"apple","5000"),new Item(2,"mango","900"),new Item(3,"banana","300")));
        assertEquals("300",itemService.getAllItems().get(2).getPrice());
    }

    @Test
    public  void createItem(){
        when(itemRepository.save(ArgumentMatchers.any(Item.class))).thenReturn(new Item(1,"Annabelle","Transsexual Woman"));
        assertEquals("23000",itemService.createItem("coconut","23000",4).getPrice());
    }

    @Test
    public void deleteItem(){
        Item st = new Item(5,"pawpaw","12000");
        when(itemRepository.findById(st.getId())).thenReturn(Optional.of(st));

        itemService.deleteItem(st.getId());

        verify(itemRepository).deleteById(st.getId());

    }

    @Test
    public void updateItem(){
        Item st = new Item(6,"watch","34000");
        Item newST = new Item(6, "apple watch","900000");
        given(itemRepository.findById(st.getId())).willReturn(Optional.of(st));

        itemService.updateItem(st.getId(),newST);
        verify(itemRepository).save(newST);
        verify(itemRepository).findById(st.getId());
    }

    @Test
    public void returnItem(){
        Item item = new Item();
        item.setId(2);

        when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));

        Item expected = itemService.detailItem(item.getId());

        assertThat(expected).isSameAs(item);

        verify(itemRepository).findById(item.getId());
    }

}
