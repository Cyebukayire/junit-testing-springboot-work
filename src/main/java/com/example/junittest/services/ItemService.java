package com.example.junittest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItem(){
        return itemRepository.findAll();
    }

    public Item createItem(String name, String price, Integer id){
        Item item = new Item(id, name, price);

        return itemRepository.save(item);
    }

    public void deleteItem(Integer id){
        itemRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("Item not found with id"+ id));
        itemRepository.deleteById(id);
    }

    public Item updateItem(Integer id, Item item){
        itemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Item not found with id"+ id));

        item.setId(id);

        return itemRepository.save(item);

    }

    public Item detailItem(Integer id){
        return itemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Item with id "+id+ " not found!"));
    }
}
