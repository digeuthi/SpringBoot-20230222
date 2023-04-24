package com.dahye.firstproject.service.implement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dahye.firstproject.service.RestAPIService;

//@Component //Ioc 이용한 DI사용가능하다
@Service // Component와 동일한데 이름을 정확하게 지정해주는것
public class RestApiServiceImplement implements RestAPIService { //구현체
    
    public String getMethod(){
        return "Return to Service Rayer";
    }

    public String postMethod(){
        return "Return to Service Rayer";
    }
    public String patchMethod(){
        return "Return to Service Rayer";
    }
    public String deleteMethod(){
        return "Return to Service Rayer";
    }
}
