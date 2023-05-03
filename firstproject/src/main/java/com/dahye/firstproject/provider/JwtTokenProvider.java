package com.dahye.firstproject.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component //컴포넌트로 등록, 오토와일드 통해서 IOC가능.
public class JwtTokenProvider {
    
    //jwt 생성 혹은 검증에 사용될 시크릿 키
    //시크릿 키 같은 데이터는 보안에 유의해야 하기때문에
    // application.propertise 또는 시스템 환경변수로 등록해서 사용함.
    //jwt하려면 secret-key가 필요함.
    @Value("${jwt.secret-key}") //application.propertise에 적은것 불러옴.
    private String SECRET_KEY ;

    //JWT 생성 메서드
    public String create(String subject){
        //만료시간
        Date expiredDate = Date.from(Instant.now().plus(1,ChronoUnit.HOURS));
        //생성
        String jwt = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(expiredDate).compact();
        return jwt;    
    }

    //JWT 검증, 생성된 jwt를 받아서 parser을 하고 claim(payroad)으로 바꿔준다..?
    public String validate(String jwt){
        Claims claims = 
            Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();
    }
}
