package com.Task.Assignment.service;


import com.Task.Assignment.dto.ProductRequest;
import com.Task.Assignment.dto.ProductResponse;
import com.Task.Assignment.entity.Product;
import com.Task.Assignment.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse create(ProductRequest request) {

        Product product = Product.builder()
                .productName(request.getProductName())
                .createdBy("SYSTEM")
                .createdOn(LocalDateTime.now())
                .build();

        Product saved = productRepository.save(product);

        return mapToResponse(saved);
    }



    @Override
    public ProductResponse getById(Integer id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        return mapToResponse(product);
    }

    @Override
    public Page<ProductResponse> getAll(int page, int size) {

        return productRepository
                .findAll(PageRequest.of(page, size))
                .map(this::mapToResponse);
    }

    @Override
    public ProductResponse update(Integer id, ProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product.setProductName(request.getProductName());
        product.setModifiedBy("SYSTEM");
        product.setModifiedOn(LocalDateTime.now());

        return mapToResponse(productRepository.save(product));
    }

    @Override
    public void delete(Integer id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        productRepository.delete(product);
    }

    private ProductResponse mapToResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .createdBy(product.getCreatedBy())
                .build();
    }
}