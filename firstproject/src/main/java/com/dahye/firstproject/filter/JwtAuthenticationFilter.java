package com.dahye.firstproject.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dahye.firstproject.provider.JwtTokenProvider;
import com.dahye.firstproject.provider.UserRole;

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
       try {

        String jwt =parseToken(request);

        boolean hasJwt = jwt != null;
        if(!hasJwt) {
            filterChain.doFilter(request, response);
            return;
        }

        UserRole subject = jwtTokenProvider.validate(jwt); //subject 꺼내올수있다.

        AbstractAuthenticationToken authenticationToken = 
            new UsernamePasswordAuthenticationToken(subject, null, AuthorityUtils.NO_AUTHORITIES);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authenticationToken);

        SecurityContextHolder.setContext(securityContext);

       } catch (Exception exception) {
            exception.printStackTrace();
       }

       filterChain.doFilter(request, response); //이렇게 해야 다음 필터로 넘어갈수 있다. 필터 벗어나기
    }

    //파싱 진행
    private String parseToken(HttpServletRequest request){

        //Request Header 중 "Authorization" : "Bearer eyJhbGci..."값 가져온다
        String  token = request.getHeader("Authorization");

        boolean hasToken = 
                token != null && 
                !token.equalsIgnoreCase("null");
        if(!hasToken) return null;

        //"Bearer eyJhbGci..." 인지 확인하는 것
        boolean isBearer = token.startsWith("Bearer ");
        if(!isBearer) return null;

        //"Bearer eyJhbGci..." 인덱스 7번부터 값을 가져오겠다. 앞의 7번째 인덱스까지는 제거하고 실제 토큰을 가져온다
        String jwt = token.substring(7);
        return jwt;
    }
    
}
