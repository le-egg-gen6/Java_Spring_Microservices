package com.myproject.userservice.payload.request;

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
public class RefreshRequest {

    private String token;

}
