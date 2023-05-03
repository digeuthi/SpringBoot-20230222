package com.dahye.firstproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dahye.firstproject.entity.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer>{
    
    //메서드 정의하는 공간에 규칙만 잘 따라서 작성하면 쿼리문 생성없이 바로 할 수있다.
    public ExampleEntity findByPk(int pk);
    public List<ExampleEntity> findByExampleColumn3AndExampleColumn2(boolean exampleColumn3,String exampleColumn2);
                                //여러 조건 검색시 And사용해서 연결 
                                //매개변수의 순서에 맞춰서 입력해야한다!! 데이터 타입도 순서에 맞게 잘 설정하기
    public boolean existsByExampleColumn3(boolean exampleColumn3); //이거하면 트랜잭션 에러가 뜬다? 처리는 다음에
                    //해당 조건에 따라서 존재하는지 아닌지에 대한 반환하는 메서드                         

}
