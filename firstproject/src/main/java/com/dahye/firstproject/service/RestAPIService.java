package com.dahye.firstproject.service;

public interface RestAPIService {
    
    public String getMethod();

    public String postMethod();
    public String patchMethod();
    public String deleteMethod();

    //기능에 대한걸 선언만 해두는것
    //반환되어야 할 인풋과 아웃풋만 정의해서 정의를 해준다. 
    //서비스를 구현하고 독립적으로 진행되게 된다.
    //서비스나 레포지토리 만들때는 인터페이스 만들어서 적용해준다.
}
