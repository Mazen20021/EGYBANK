package com.egypay.egypay.Services;

import com.egypay.egypay.Models.Entities.FavBanksEntity;
import com.egypay.egypay.Repo.FavBankRepoINT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavBankService implements FavBankServiceINT {

    private final FavBankRepoINT favBankRepo;

    public FavBanksEntity findFavBanksEntityBySwiftCode(String swiftCode)
    {
       return favBankRepo.findFavBanksEntityBySwiftCode(swiftCode);
    }
}
