package com.Task.Assignment.service;


import com.Task.Assignment.entity.Item;
import com.Task.Assignment.repo.ItemRepository;
import com.Task.Assignment.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ProductRepository productRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ProductRepository productRepository) {
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Item> getItemsByProduct(Integer productId) {

        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Product not found");
        }

        return itemRepository.findByProductId(productId);
    }
}