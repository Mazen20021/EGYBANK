package com.egypay.egypay.Models.DTO;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class FavBankDTO {
    private int id;
    private String name;
    private String swiftcode;
    private String iban;
    private Double balance;
    private String amount;
}
