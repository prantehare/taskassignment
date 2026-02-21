package com.Task.Assignment.service;




import com.Task.Assignment.dto.ProductRequest;
import com.Task.Assignment.dto.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponse create(ProductRequest request);

    ProductResponse getById(Integer id);

    Page<ProductResponse> getAll(int page, int size);

    ProductResponse update(Integer id, ProductRequest request);

    void delete(Integer id);
}