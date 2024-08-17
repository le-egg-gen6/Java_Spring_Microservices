package com.myproject.userservice.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nguyenle
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogoutRequest {

    private String token;

}
