package com.myproject.orderservice.service;

import com.myproject.orderservice.dto.OrderRequest;

public interface OrderService {

    void placeOrder(OrderRequest orderRequest);

}
