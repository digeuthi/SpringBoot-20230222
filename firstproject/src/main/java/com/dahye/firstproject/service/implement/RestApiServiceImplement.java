package com.dahye.firstproject.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dahye.firstproject.entity.ExampleEntity;
import com.dahye.firstproject.repository.ExampleRepository;
import com.dahye.firstproject.service.RestAPIService;

//@Component //Ioc 이용한 DI사용가능하다
@Service // Component와 동일한데 이름을 정확하게 지정해주는것
public class RestApiServiceImplement implements RestAPIService { //구현체
    
    private ExampleRepository exampleRepository;

    @Autowired
    public RestApiServiceImplement(ExampleRepository exampleRepository){
        this.exampleRepository = exampleRepository;
    }

    public String postMethod(){
        // 데이터 삽입
        // 1. Entity 인스턴스(= 데이터 베이스 테이블의 레코드) 생성 
        ExampleEntity exampleEntity = 
            ExampleEntity.builder()
            .exampleColumn2("string1")
            .exampleColumn3(false)
            .build();

        // 2. Repository를 거쳐서 Entity 인스턴스를 저장
        exampleRepository.save(exampleEntity);

        return null;
    }

    public String getMethod(){
        //데이터 조회
        // 1. jpaRepository에 있는 findBy 메서드로 Entity 조회
        ExampleEntity exampleEntity = exampleRepository.findById(1).get();
        return exampleEntity.toString(); //반환을 String으로 설정해뒀으니까
    }

    public String patchMethod(){
        return null;
    }
    public String deleteMethod(){
        return null;
    }
}
