package com.egypay.egypay.Services;

import com.egypay.egypay.Config.Mapper;
import com.egypay.egypay.Models.DTO.BankDTO;
import com.egypay.egypay.Models.DTO.FavBankDTO;
import com.egypay.egypay.Models.Entities.BankEntity;
import com.egypay.egypay.Models.Entities.FavBankEntity;
import com.egypay.egypay.Repo.BankRepoINT;
import com.egypay.egypay.Repo.FavBankRepoINT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavBankService implements FavBankServiceINT{

    private final FavBankRepoINT favBankRepo;
    private final BankRepoINT bankRepo;
    private final Mapper mapper = new Mapper();

    @Override
    public FavBankEntity findBySwiftcode(String swiftcode) {
        return favBankRepo.findBySwiftcode(swiftcode);
    }


}
