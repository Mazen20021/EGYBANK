package com.egypay.egypay.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private Double balance;
}
