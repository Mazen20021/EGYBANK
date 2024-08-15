package com.egypay.egypay.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BankDTO {
    private Long id;
    private final String name = "EGY";
    private String address;
    private String swift;
    private String iban ;
    private Double balance;
    private String Token;
}
