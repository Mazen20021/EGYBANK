package com.egypay.egypay.Services;

import com.egypay.egypay.Models.DTO.FavBankDTO;
import com.egypay.egypay.Models.Entities.FavBankEntity;

public interface FavBankServiceINT {
    FavBankEntity findBySwiftcode(String swiftcode);
}
