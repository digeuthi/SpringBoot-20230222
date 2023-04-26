package com.dahye.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dahye.board.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
                                                                /*해당 엔터티 PK의 타입*/

   public boolean existsByEmail(String email);
    public boolean existsByNickname(String nickname);
    public boolean existsByPhoneNumber(String phoneNumber);                                                           
}
