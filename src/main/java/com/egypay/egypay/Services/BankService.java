package com.egypay.egypay.Services;

import com.egypay.egypay.Models.Entities.BankEntity;
import com.egypay.egypay.Repo.BankRepoINT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankService implements BankServiceINT{

    BankRepoINT bankRepoINT;

    public BankEntity findBankEntityBySwift(String swift)
    {
        return bankRepoINT.findBankEntityBySwift(swift);
    }
}
