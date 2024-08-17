package com.myproject.userservice.payload.request;

import com.myproject.userservice.annotation.validator.DobConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author nguyenle
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateRequest {

    private String password;
    private String firstName;
    private String lastName;

    @DobConstraint(min = 18, message = "INVALID_DOB")
    private LocalDate dob;

    private List<String> roles;

}
