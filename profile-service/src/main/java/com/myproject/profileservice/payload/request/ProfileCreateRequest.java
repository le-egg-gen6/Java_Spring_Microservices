package com.myproject.profileservice.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author nguyenle
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileCreateRequest {

    private String userId;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String city;

}
