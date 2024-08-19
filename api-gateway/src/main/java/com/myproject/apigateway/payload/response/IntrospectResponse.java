package com.myproject.apigateway.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nguyenle
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntrospectResponse {

    private boolean valid;

}
