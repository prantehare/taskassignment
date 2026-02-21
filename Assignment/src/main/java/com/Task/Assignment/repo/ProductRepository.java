package com.Task.Assignment.repo;




import com.Task.Assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductRepository extends
        JpaRepository<Product, Integer>,
        JpaSpecificationExecutor<Product> {

    Optional<Product> findByProductName(String productName);

    boolean existsByProductName(String productName);
}