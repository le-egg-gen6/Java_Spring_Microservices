package com.myproject.orderservice.service.impl;

import com.myproject.orderservice.dto.request.OrderRequest;
import com.myproject.orderservice.model.Order;
import com.myproject.orderservice.model.OrderLineItems;
import com.myproject.orderservice.repository.OrderLineItemsRepository;
import com.myproject.orderservice.repository.OrderRepository;
import com.myproject.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderLineItemsRepository orderLineItemsRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream().map(orderLineItemsDto -> {
                    OrderLineItems item = new OrderLineItems();
                    item.setPrice(orderLineItemsDto.getPrice());
                    item.setQuantity(orderLineItemsDto.getQuantity());
                    item.setSkuCode(orderLineItemsDto.getSkuCode());
                    return item;
                }).toList();
        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }
}
