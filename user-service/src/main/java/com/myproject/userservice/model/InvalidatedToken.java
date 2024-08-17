package com.myproject.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author nguyenle
 */
@Entity
@Table(name = "t_invalidated_token")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InvalidatedToken {

    @Id
    private String id;

    private Date expiryTime;

}
