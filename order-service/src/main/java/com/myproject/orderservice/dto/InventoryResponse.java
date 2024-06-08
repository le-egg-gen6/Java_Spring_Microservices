package com.myproject.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {

    @JsonProperty("skuCode")
    private String skuCode;

    @JsonProperty("isInStock")
    private boolean isInStock;

}
