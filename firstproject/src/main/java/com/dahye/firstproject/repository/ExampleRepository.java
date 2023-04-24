package com.dahye.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dahye.firstproject.entity.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer>{
    
    //메서드 정의하는 공간에 규칙만 잘 따라서 작성하면 쿼리문 생성없이 바로 할 수있다.
}
