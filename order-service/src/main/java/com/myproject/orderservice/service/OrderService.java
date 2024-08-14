package com.myproject.orderservice.service;

import com.myproject.orderservice.dto.request.OrderRequest;

public interface OrderService {

    void placeOrder(OrderRequest orderRequest);

}
