package com.egypay.egypay.Repo;

import com.egypay.egypay.Models.Entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnderBankRepoINT extends JpaRepository<BankEntity , Integer> {
    BankEntity findBankEntityByName(String name);

}
