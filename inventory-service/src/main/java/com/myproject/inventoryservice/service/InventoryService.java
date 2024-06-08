package com.myproject.inventoryservice.service;

import com.myproject.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    List<InventoryResponse> isInStock(List<String> skuCode);

}
