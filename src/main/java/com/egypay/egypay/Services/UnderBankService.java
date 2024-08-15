package com.egypay.egypay.Services;

import com.egypay.egypay.Config.Mapper;
import com.egypay.egypay.Models.DTO.BankDTO;
import com.egypay.egypay.Models.DTO.BankDTOBalance;
import com.egypay.egypay.Models.Entities.BankEntity;
import com.egypay.egypay.Repo.UnderBankRepoINT;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnderBankService implements UnderBankServiceINT{

    private final UnderBankRepoINT UnderbankRepoINT;
    private Double balance = 0D;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BankDTO bankDTO = new BankDTO();
    private final Mapper mapper = new Mapper();

    public BankEntity findBankEntityByName(String name) {return UnderbankRepoINT.findBankEntityByName(name);}

    public boolean save(BankEntity bankEntity) {UnderbankRepoINT.save(bankEntity);return true;}

    public BankDTOBalance getBalance(String requestBody) {
        if (requestBody.contains(UnderbankRepoINT.findBankEntityByName(bankDTO.getName()).getToken()))
        {
            double balance = UnderbankRepoINT.findBankEntityByName(bankDTO.getName()).getBalance();
            BankDTOBalance bd = new BankDTOBalance();
            bd.setBalance(balance);
            return bd;
        } else {
            return null;
        }
    }

    public String Deposit(String requestBody) {
        try {
            if (!requestBody.contains(UnderbankRepoINT.findBankEntityByName(bankDTO.getName()).getToken()))
            {
                return "-3";
            }else
            {
                JsonNode rootNode = objectMapper.readTree(requestBody);
                JsonNode amountNode = rootNode.path("amount");

                if (amountNode.isMissingNode()) {return "-1";}
                else if(amountNode.asDouble() < 100000.0 || amountNode.asDouble() < 0) {return "-2";}
                else
                {
                    balance = UnderbankRepoINT.findBankEntityByName(bankDTO.getName()).getBalance();
                    balance += amountNode.asDouble();
                    UnderbankRepoINT.findBankEntityByName(bankDTO.getName()).setBalance(balance);
                    UnderbankRepoINT.save(mapper.getmap().map(UnderbankRepoINT.findBankEntityByName(bankDTO.getName()), BankEntity.class));
                    balance = UnderbankRepoINT.findBankEntityByName(bankDTO.getName()).getBalance();
                    BankDTOBalance bd = new BankDTOBalance();
                    bd.setBalance(balance);
                    return "0";
                }
            }
        } catch (Exception e) {return "-3";}
    }

    public String Withdraw(String requestBody) {
        try {
            if (!requestBody.contains(UnderbankRepoINT.findBankEntityByName(bankDTO.getName()).getToken()))
            {
                return "-3";
            }else
            {
                JsonNode rootNode = objectMapper.readTree(requestBody);
                JsonNode amountNode = rootNode.path("amount");
                balance = UnderbankRepoINT.findBankEntityByName("EGY").getBalance();

                if (amountNode.isMissingNode()) {return "-1";}
                else if(amountNode.asDouble() > 1000000000) {return "-4";}
                else if(amountNode.asDouble() > balance) {return "-2";}
                else if(amountNode.asDouble() <= balance && amountNode.asDouble() > 0) {
                    balance -= amountNode.asDouble();
                    UnderbankRepoINT.findBankEntityByName("EGY").setBalance(balance);
                    UnderbankRepoINT.save(mapper.getmap().map(UnderbankRepoINT.findBankEntityByName("EGY"), BankEntity.class));
                    balance = UnderbankRepoINT.findBankEntityByName("EGY").getBalance();
                    BankDTOBalance bd = new BankDTOBalance();
                    bd.setBalance(balance);
                    return "0";
                }
            }
        } catch (Exception e) {return "-3";}
        return "-5";
    }

}
