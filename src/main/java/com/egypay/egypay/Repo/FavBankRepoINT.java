package com.egypay.egypay.Repo;

import com.egypay.egypay.Models.DTO.FavBankDTO;
import com.egypay.egypay.Models.Entities.FavBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavBankRepoINT extends JpaRepository <FavBankEntity , Integer> {
    FavBankEntity findBySwiftcode(String swiftcode);
}
