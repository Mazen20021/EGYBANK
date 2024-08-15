package com.egypay.egypay.Services;

import com.egypay.egypay.Models.Entities.FavBanksEntity;

public interface FavBankServiceINT {
    FavBanksEntity findFavBanksEntityBySwiftCode(String swiftCode);
}
