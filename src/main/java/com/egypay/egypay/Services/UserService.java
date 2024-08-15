package com.egypay.egypay.Services;

import com.egypay.egypay.Config.Mapper;
import com.egypay.egypay.Models.DTO.UserDTO;
import com.egypay.egypay.Models.Entities.UserEntity;
import com.egypay.egypay.Repo.UserRepoINT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceINT {

    private final UserRepoINT userRepoINT;

    @Override
    public boolean FindUserByEmail(UserDTO userDto) {
        Optional<UserEntity> UserEntity = userRepoINT.findByEmail(userDto.getEmail());
        return UserEntity.filter(userEntity -> userDto.getPassword().equals(userEntity.getPassword())).isPresent();
    }

    @Override
    public boolean saveUser(UserDTO user) {
        Mapper mapper = new Mapper();
        try{
                userRepoINT.save(mapper.getmap().map(user, UserEntity.class));

            return true;

        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public UserEntity findUserEntityByEmail(String email) {
        return userRepoINT.findUserEntityByEmail(email);
    }


}
