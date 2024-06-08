package com.myproject.productservice.util;

import com.myproject.productservice.model.Product;
import com.myproject.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class SampleDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() < 1) {
            Product product = new Product();
            product.setName("Iphone 15 Promax");
            product.setDescription("Supperrrr iphone made by apple");
            product.setPrice(BigDecimal.valueOf(2000));
            productRepository.save(product);
        }
    }
}
