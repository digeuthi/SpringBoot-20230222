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
        //ExampleEntity exampleEntity = exampleRepository.findById(1).get();

        ExampleEntity exampleEntity = exampleRepository.findByPk(1);

        // exampleRepository.

        return exampleEntity == null ? "null" : exampleEntity.toString(); //반환을 String으로 설정해뒀으니까
        //null인 경우를 예외처리 해줌
    }

    public String patchMethod(){
        //데이터 수정
        //patch (구분자와 변경할 값만 있으면 된다)
        // 1-1. 특정 조건으로 Entity 조회 
        ExampleEntity exampleEntity = exampleRepository.findById(1).get();
        // 1-2. 데이터 수정작업
        exampleEntity.setExampleColumn2("string2");
        // 1-3. Entity 인스턴스 저장
        exampleRepository.save(exampleEntity);

        //put (필수값은 전부 필요하다)
        // 2-1. Entity 인스턴스 생성
        ExampleEntity exampleEntity2 = new ExampleEntity(2, "string3",true); //입력받은 전체를 가져와 save
        //존재하는 테이블에 pk가 존재한다면 원래 있던 것을 변경시킨다
        // 2-2 Entity 인스턴스 저장
        exampleRepository.save(exampleEntity2);
        return null;
    }
    public String deleteMethod(){
        //데이터 삭제
        // 1-1. jpaRepository애 있는 deleteBy메서드로 Entity 삭제
        exampleRepository.deleteById(1);
        //exampleRepository.delete(null); //특정 레코드 자체를넣어도 지울수 있다.
        return null;
    }
}
