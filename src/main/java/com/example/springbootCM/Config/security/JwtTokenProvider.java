package com.example.springbootCM.Config.security;

import com.example.springbootCM.apiItem.acnt.User;
import com.example.springbootCM.apiServer.service.CustomUserService;
import com.example.springbootCM.apiServer.service.CustromUserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("spring.jwt.secret")
    private String secretKey;
    private long tokenValidMiliSec = 1000L * 60 * 60 * 2;  // expire time
    private final CustromUserDetailService custromUserDetailService;

    //key 생성
    @PostConstruct
    protected  void init(){
       secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

/*
    claim에 토큰에 부가적으로 넣을 데이터 셋팅 가능.
    role 같은 데이터를 저장해뒀다가 다음에 server로 토큰 값이 들어오면 확인해서 라우팅해주면 됨
    expire time 셋팅 가능
*/

    //JWT 토큰 생성
    public String createToken(String userPk, String role){
        Claims claims = Jwts.claims().setSubject(userPk);
        claims.put("roles",role);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMiliSec))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    // 인증 성공시 SecurityContextHolder에 저장할 인증 객체 생성
    public Authentication getAuthentication(String token) throws Exception {
         UserDetails user = custromUserDetailService.loadUserByUsername(this.getUserPk(token));
         return new UsernamePasswordAuthenticationToken(user,"",  user.getAuthorities());
    }

    //JWT 토큰에서 PK 추출
    public String getUserPk(String token){
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    // Jwt Token의 유효성 및 만료 기간 검사
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("X-AUTH-TOKEN");
    }
}
