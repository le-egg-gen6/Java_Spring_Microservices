package com.myproject.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {

    @JsonProperty("skuCode")
    private String skuCode;

    @JsonProperty("isInStock")
    private boolean isInStock;

}
