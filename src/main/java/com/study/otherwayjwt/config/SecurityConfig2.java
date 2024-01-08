package com.study.otherwayjwt.config;

import com.study.otherwayjwt.jwt.JwtAuthenticationFilter;
import com.study.otherwayjwt.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig2 {
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder(){
        // BCrypt Encoder 사용
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // REST API이므로 basic auth 및 csrf 보안을 사용하지 않음
                .httpBasic().disable()
                .csrf().disable()
                // JWT를 사용하기 때문에 세션을 사용하지 않음(시큐리티는 기본적으로 세션을 사용)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 해당 API에 대해서는 모든 요청을 허가
                .antMatchers("/naebang/login").permitAll()
                .antMatchers("/naebang/signup").permitAll()
                // ROLE_USER, ROLE_ADMIN 권한이 있어야 요청할 수 있음
                .antMatchers("/naebang/member/**").hasRole("ROLE_USER")
                .antMatchers("/naebang/admin/**").hasRole("ROLE_ADMIN")
                // 이 밖에 모든 요청에 대해서 인증을 필요로 한다는 설정
                .anyRequest().authenticated()
                .and()
                // JWT 인증을 위하여 직접 구현한 필터를 UsernamePasswordAuthenticationFilter 전에 실행
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider)
                        , UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
