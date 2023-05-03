package com.dahye.firstproject.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dahye.firstproject.provider.JwtTokenProvider;
import com.dahye.firstproject.service.MainService;

@Component //지정해둔 클래스에만 Ioc 시킬수 있고 autowierd로 가져올수 있게 된다 @service 해도 이름을 지정해준거지 컴포넌트의 역할을 한다
public class MainServeceImplement implements MainService {

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public MainServeceImplement(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String hello() {
        return "Hello";
    }
    //메인 서비스 구현하도록 해줌

    @Override
    public String getJwt(String data) {
        String jwt = jwtTokenProvider.create(data);
        return jwt;
    }

    @Override
    public String validJwt(String jwt) { //검증
        String subject = jwtTokenProvider.validate(jwt);
        return subject;
    }
}
