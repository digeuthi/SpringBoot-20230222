package com.dahye.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller //ViewResolver? / html을 반환해줌
@RestController //Rest API를 위한 Controller임을 명시해주는 어노테이션
                // @Controller + @ResponseBody = @RestController
                //Response는 html을 제외한 Mime 타입을 반환한다
@RequestMapping(value = "api") //클래스에 패턴을 지정해두면 클래스에서 작업을 하겠다는걸 지칭할수 있다.
                // URL path 패턴을 지정해서 해당 패턴이면 지정한 클래스로 처리하도록 함              
                //value만 지정할거면 api만 적어도 된다
public class RestAPIController {
    
    @RequestMapping(method = {RequestMethod.GET}, value = "hello2") //가독성떨어짐
    //패스가 hello2인 것을 메서드를 겟할수있다..?
    //@ResponseBody // 이 반환해주는 값을 body에 직접 받겠다는 어노테이션
    //메서드에 값을 지정해두면 엔드포인트로 올때 처리해주겠다는걸 지정해주는것
    public String hello2(){
        return "hello2";
    }

    //GET method @GETMapping
    // 클라이언트가 서버에게 데이터를 받기위한 요청의 Method
    // 사용자 정보를 요구하는 상황에서 사용함.
    // @RequestMapping(mehod=RequestMethod.GET, value="get-mdthod")과 동일.
    @GetMapping("get-method") //패스를 지정해준것
    public String getMethod(){
        return "Response of Get Request";
    }

    //POST Method @PostMapping
    // 클라이언트가 서버에 데이터를 작성하기 위한 요청의 Method
    // @RequestMapping(mehod=RequestMethod.POST, value="post-mdthod")과 동일.
    @PostMapping("post-method")
    public String postMethod(){
        return "Response of Post Request";
    }
}
