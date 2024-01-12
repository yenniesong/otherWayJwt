package com.study.otherwayjwt.dto;

import com.study.otherwayjwt.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private String email;
    private String username;

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .email(member.getEmail())
                .username(member.getUsername())
                .build();
    }

    public static MemberResponseDto memberResponseDto(Member member) {
        return new MemberResponseDto(member.getEmail(), member.getUsername());
    }
}
