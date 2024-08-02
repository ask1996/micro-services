package com.kittu13.product_service.repository;

import com.kittu13.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends MongoRepository<Product, String> {
}
