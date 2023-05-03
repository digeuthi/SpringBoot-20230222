package com.dahye.firstproject.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dahye.firstproject.provider.JwtTokenProvider;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider  = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       
    }

    //파싱 진행
    private String parseToken(HttpServletRequest request){

        //Request Header 중 "Authorization" : "Bearer eyJhbGci..."값 가져온다
        String  token = request.getHeader("Authorization");

        boolean hasToken = 
                token != null && 
                token.equalsIgnoreCase("null");
        if(!hasToken) return null;

        //"Bearer eyJhbGci..." 인지 확인하는 것
        boolean isBearer = token.startsWith("Bearer ");
        if(!isBearer) return null;

        //"Bearer eyJhbGci..." 인덱스 7번부터 값을 가져오겠다. 앞의 7번째 인덱스까지는 제거하고 실제 토큰을 가져온다
        String jwt = token.substring(7);
        return jwt;
    }
    
}
