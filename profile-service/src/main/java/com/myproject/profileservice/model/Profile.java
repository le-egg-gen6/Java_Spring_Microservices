package com.myproject.profileservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author nguyenle
 */
@Entity
@Table(name = "t_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String city;

}
