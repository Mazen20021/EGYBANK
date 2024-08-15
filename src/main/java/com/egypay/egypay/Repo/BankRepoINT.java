package com.egypay.egypay.Repo;

import com.egypay.egypay.Models.Entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepoINT extends JpaRepository<BankEntity, Long> {
    BankEntity findBankEntityBySwift(String swift);
}
