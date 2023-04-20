package com.dahye.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(method = {RequestMethod.GET}, value = "hello2") //가독성떨어짐 -> 하나하나 기능별로 분해해서 사용하게된다 Request Method
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
    @GetMapping("get-method") //패스를 지정해준것 (path value), 프로그래밍 언어에서는 띄어쓰기할때 언더바 하거나 각각 카멜케이스쓰는데
                              //url표시할때는 -으로 표시하게 된다
    public String getMethod(){
        return "Response of Get Request";
    }

    //POST Method @PostMapping
    // 클라이언트가 서버에 데이터를 작성하기 위한 요청의 Method
    // @RequestMapping(mehod=RequestMethod.POST, value="post-mdthod")과 동일.
    @PostMapping("post-method") //리소스는 있는데 POST로만 인식되게 해둠. 다른 걸 사용하면 405에러가 뜬다
        //리소스는 찾았는데 대응하는 메서드를 찾지못했다고 뜨게된다.
    public String postMethod(){
        return "Response of Post Request";
    }

    //Patch Method @PatchMaping
    // 클라이언트가 서버에 데이터를 '일부'만 수정하기 위한 요청의 mehod //put은 전체를 수정하게된다
    // @RequestMapping(mehod=RequestMethod.PATCH, value="patch-mdthod")과 동일.
    @PatchMapping("patch-method")
    public String patchMethod(){
        return "Response of Patch Requset";
    }

    //Delete Method @DeleteMapping
    // 클라이언트가 서버에 데이터를 삭제하기 위한 요청의 method
    // @RequestMapping(mehod=RequestMethod.DELETE, value="delete-mdthod")과 동일.
    @DeleteMapping("delete-method")
    public String deleteMethod(){
        return "Response of Delete Request";
    }

    //PathVariable()로 Get, Delete Method에서 데이터 받기
    // 리소스에 지정한 패턴에 따라 맞춰서 요청의 url을 지정한다면
    // 패턴에 맞춰 데이터를 받아오는 형식
    @GetMapping({"path-variable/{data1}","path-variable/{data1}/{data2}"}) //{}안의 값은 내가 입력하는것
    public String pathVariable(
        @PathVariable(value="data1"/**data1만 입력해도 된다. 입력값이 1개일 경우에는*/) String dataA,
        @PathVariable(value="data2", required = false) String dataB
        ){
        return dataA + dataB + " 데이터를 입력받았습니다.";
    }

    //데이터를 2개를 입력하는 코드를 만들고 나서 하나반 입력시 오류가 뜨게 된다 아마 오류 400대로 뜨는듯
    //이때 해결은 데이터 하나만 받아서 만드는 걸 따로 만들어서 처리를 해줄수도 있고
    //안의 들어가는 코드가 완전히 똑같다면 @GetMapping자리에 받을수 있는 밸류를 문자열의 배열로 들어가서 2개이상 들어갈수 있다.
    //{"path-variable/{data1}/{data2}","path-variable/{data1}" 둘중하나를 만족하면 반환되도록해주는것
    // 예외처리를 안해줘서 500오류가 뜨게된다 required = false추가하면 null값으로 들어가서 반환되게 된다
}