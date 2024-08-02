package com.kittu13.product_service.services;

import com.kittu13.product_service.dto.ProductRequest;
import com.kittu13.product_service.model.Product;
import com.kittu13.product_service.repository.ProductRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRespository productRespository;

    public void createProd(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription()).
                price(productRequest.getPrice()).build();
        productRespository.save(product);
        log.info("save to db");
    }

    public List<Product> getProducst() {
        return productRespository.findAll();
    }
}
