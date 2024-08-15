package com.egypay.egypay.Repo;

import com.egypay.egypay.Models.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepoINT extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String userEmail);
    boolean existsByEmail(String email);
    UserEntity findUserEntityByEmail(String email);
}
