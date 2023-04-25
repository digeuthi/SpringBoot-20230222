package com.dahye.firstproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; //어느 경로 어노테이션인지 알기!

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity는 allarg 생성자 갖고 있어야하고 게터만 가지고 있어야한다. 
//세터를 가지면 안된다는 이야기(빈생성자는 없어야함) DB와 인스턴스가 데이터를 꺼내오고나서 set작업을 하면 잘못전달될수 있다는것.
//그런 것에 제약을 걸어놓기 위해 setter쓰지말라고하지만 set 안적으면 좀 불편하다. 써도 무관하긴하다..
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Example") //name을 이 이름으로 사용할수 있게 지정, DB에서는 해당테이블 못찾는다..! 테이블 어노테이션 추가
@Table(name="Example") //테이블 찾아오게 함 //어떠한 테이블과 매핑할건지 명시하게 된다.
//DB의 여러 제약조건에서 기본키는 만드시 있어야한다! -> 지정하는 어노테이션이 따로 있다.
//java에서는 보통 카멜케이스로 네이밍규칙. 띄어쓰기다음에 오면 대문자로 함 / db에서는 띄어쓰기 _로하고 소문자로해야 서로 인식함!
public class ExampleEntity { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoInclement 적용시킨다
    //다른 제약조건을 설정하려면 @Column사용해서 지정함
    @Column(name="example_column1", nullable = false, unique = true) //column 사용하지 않으면 명명규칙 엄격하게 따라야한다.
    //클래스도 어노테이션 지정하지 않고 할 경우 명명규칙 정확히 따라야한다
    private int pk; 
    private String exampleColumn2;
    private boolean exampleColumn3;
}
