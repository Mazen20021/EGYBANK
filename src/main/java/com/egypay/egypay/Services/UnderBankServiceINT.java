package com.egypay.egypay.Services;

import com.egypay.egypay.Models.DTO.BankDTOBalance;
import com.egypay.egypay.Models.Entities.BankEntity;

public interface UnderBankServiceINT {
    BankEntity findBankEntityByName(String name);
    boolean save(BankEntity bankEntity);
    BankDTOBalance getBalance(String request);
    String Deposit(String requestBody);
    String Withdraw(String requestBody);
}
