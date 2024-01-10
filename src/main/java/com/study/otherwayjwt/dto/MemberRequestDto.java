package com.study.otherwayjwt.dto;

import com.study.otherwayjwt.entity.Authority;
import com.study.otherwayjwt.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequestDto {
    private String email;
    private String password;
    private String username;
    
    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .username(username)
                .authority(Authority.ROLE_USER)
                .build();
    }
    
    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(email, password);
    }

}
