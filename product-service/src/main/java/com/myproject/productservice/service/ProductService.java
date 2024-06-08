package com.myproject.productservice.service;

import com.myproject.productservice.dto.ProductRequest;
import com.myproject.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

}
