package com.Task.Assignment.service;



import com.Task.Assignment.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItemsByProduct(Integer productId);
}