package com.egypay.egypay.Services;

import com.egypay.egypay.Models.DTO.UserDTO;
import com.egypay.egypay.Models.Entities.UserEntity;


public interface UserServiceINT {
    boolean FindUserByEmail(UserDTO userDto);
    boolean saveUser(UserDTO user);
    UserEntity findUserEntityByEmail(String email);
}
