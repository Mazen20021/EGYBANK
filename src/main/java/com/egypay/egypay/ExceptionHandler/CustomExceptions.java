package com.egypay.egypay.ExceptionHandler;

import com.egypay.egypay.Models.DTO.BankDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptions extends RuntimeException{

    private String code;
    private String message;
    private BankDTO bankDTO;
}
