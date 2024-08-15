package com.egypay.egypay.Models.DTO;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FavBanksDTO {
    private Long id;
    private String name;
    private String SwiftCode;
    private String IBAN;
    private Double balance;
    private String token;
//    List<BankDTO> bankDTOList;
}
