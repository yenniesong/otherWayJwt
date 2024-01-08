package com.study.otherwayjwt.dto;

import com.study.otherwayjwt.entity.Authority;
import com.study.otherwayjwt.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
    private String email;
    private String password;
    private String username;
    
    public Member toMember(PasswordEncoder passwordEncoder, Set<Authority> authorities) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .username(username)
                .authority(authorities)
                .build();
    }
}
