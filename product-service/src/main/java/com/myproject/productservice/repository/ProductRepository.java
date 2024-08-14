package com.myproject.productservice.repository;

import com.myproject.productservice.model.Product;
import com.myproject.productservice.payload.request.ProductRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
