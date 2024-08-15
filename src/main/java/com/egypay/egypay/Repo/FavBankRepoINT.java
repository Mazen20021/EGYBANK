package com.egypay.egypay.Repo;

import com.egypay.egypay.Models.Entities.FavBanksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavBankRepoINT extends JpaRepository<FavBanksEntity, Integer> {
    FavBanksEntity findFavBanksEntityBySwiftCode(String swiftCode);
}
