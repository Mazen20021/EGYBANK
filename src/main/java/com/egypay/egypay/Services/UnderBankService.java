package com.egypay.egypay.Services;

import com.egypay.egypay.Config.Mapper;
import com.egypay.egypay.Models.DTO.BankDTO;
import com.egypay.egypay.Models.DTO.BankDTOBalance;
import com.egypay.egypay.Models.DTO.responseDto;
import com.egypay.egypay.Models.Entities.BankEntity;
import com.egypay.egypay.Repo.UnderBankRepoINT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service

@RequiredArgsConstructor
public class UnderBankService implements UnderBankServiceINT{

    private final UnderBankRepoINT UnderbankRepoINT;
    private  Double balance = 0D;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BankDTO bankDTO = new BankDTO();
    private final Mapper mapper = new Mapper();

    public BankEntity findBankEntityByName(String name)
    {
        return UnderbankRepoINT.findBankEntityByName(name);
    }

    public boolean save(BankEntity bankEntity)
    {
        UnderbankRepoINT.save(bankEntity);
        return true;
    }

    public BankDTOBalance getBalance(String requestId) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        BankEntity bankEntity = UnderbankRepoINT.findBankEntityByName(bankDTO.getName());

        if (passwordEncoder.matches(requestId, bankEntity.getRequestId())) {
            double balance = bankEntity.getBalance();
            BankDTOBalance bd = new BankDTOBalance();
            bd.setBalance(balance);
            return bd;
        } else {
            return null;
        }
    }

    public String Deposit(String requestedId , responseDto responseDto) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        BankEntity bankEntity = UnderbankRepoINT.findBankEntityByName(bankDTO.getName());

        try {
            if (!passwordEncoder.matches(requestedId, bankEntity.getRequestId()))
            {
                return "-3";
            }else
            {
              Double amount = responseDto.getAmount();

                if(amount < 100000.0 || amount < 0.0)
                {
                    return "-2";
                }
                else
                {
                    balance = UnderbankRepoINT.findBankEntityByName(bankDTO.getName()).getBalance();
                    balance += amount;
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

    public String Withdraw(String requestedId , responseDto responseDto) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        BankEntity bankEntity = UnderbankRepoINT.findBankEntityByName(bankDTO.getName());
        try {
            System.out.println(requestedId +" "+ responseDto.getAmount());
            if (!passwordEncoder.matches(requestedId, bankEntity.getRequestId()))
            {
                return "-3";
            }else
            {
                Double amount = responseDto.getAmount();
                balance = UnderbankRepoINT.findBankEntityByName(bankEntity.getName()).getBalance();

                 if(amount > 1000000000)
                {
                    return "-4";
                }
                else if(amount > balance)
                {
                    return "-2";
                }
                else if(amount > 0 && amount <= balance)
                {
                    balance -= amount;
                    UnderbankRepoINT.findBankEntityByName(bankEntity.getName()).setBalance(balance);
                    UnderbankRepoINT.save(mapper.getmap().map(UnderbankRepoINT.findBankEntityByName(bankEntity.getName()), BankEntity.class));
                    balance = UnderbankRepoINT.findBankEntityByName(bankEntity.getName()).getBalance();
                    BankDTOBalance bd = new BankDTOBalance();
                    bd.setBalance(balance);
                    return "0";
                }
            }
        } catch (Exception e)
        {
            return "-3";
        }
        return "-5";
    }

}
