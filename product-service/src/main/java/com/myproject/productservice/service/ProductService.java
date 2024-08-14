package com.myproject.productservice.service;

import com.myproject.productservice.payload.request.ProductRequest;
import com.myproject.productservice.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();

}
