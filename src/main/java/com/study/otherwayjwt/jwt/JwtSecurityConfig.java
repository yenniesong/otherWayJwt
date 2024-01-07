package com.study.otherwayjwt.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@RequiredArgsConstructor    // 직접 만든 JwtTokenProvider와 JwtAuthenticationFilter를 SecurityConfig에 적용할 때 사용
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
//    private final JwtTokenProvider jwtTokenProvider;
//    // JwtTokenProvider를 주입받아서 JwtAuthenticationFilter를 통해 security 로직에 필터를 등록
//    @Override
//    public void configure(HttpSecurity http) {
//        JwtAuthenticationFilter customFilter = new JwtAuthenticationFilter(jwtTokenProvider);
//        http.add
//    }
}
