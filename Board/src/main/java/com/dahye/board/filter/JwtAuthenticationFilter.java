package com.dahye.board.filter;

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

import com.dahye.board.provider.JwtProvider;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    
    private JwtProvider jwtProvider;

    @Autowired //의존성 주입
    public JwtAuthenticationFilter(JwtProvider jwtProvider){
        this.jwtProvider = jwtProvider;
    }

    @Override //빠른 수정 이용해서 작성함
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {

            String jwt = parseToken(request); //jwt를 가져옴

            boolean hasJwt = jwt != null;
            if(!hasJwt) {
                filterChain.doFilter(request, response);
                return; //함수 종료시키는것?
            }

            String email = jwtProvider.validate(jwt); //서브젝트의 이메일 가져옴
            AbstractAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email, null,AuthorityUtils.NO_AUTHORITIES);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource());

            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        filterChain.doFilter(request, response);
        
    }

    //토큰 파싱
    private String parseToken(HttpServletRequest request){

        String token = request.getHeader("Authorization");

        boolean hasToken = 
            token != null && 
            !token.equalsIgnoreCase("null");
        if(!hasToken) return null;

        boolean isBearer = token.startsWith("Bearer ");
        if(!isBearer) return null;

        String jwt = token.substring(7);
        return jwt;

    }

    

}
