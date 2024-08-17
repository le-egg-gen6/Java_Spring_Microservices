package com.myproject.userservice.payload.request;

import com.myproject.userservice.annotation.validator.DobConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class UserCreateRequest {

    @Size(min = 4, message = "INVALID_USERNAME")
    private String username;

    @Size(min = 6, message = "INVALID_PASSWORD")
    private String password;

    @Email(message = "INVALID_EMAIL")
    @NotBlank
    private String email;

    private String firstName;

    private String lastName;

    @DobConstraint(min = 10, message = "INVALID_DOB")
    private LocalDate dob;

    private String city;

}
