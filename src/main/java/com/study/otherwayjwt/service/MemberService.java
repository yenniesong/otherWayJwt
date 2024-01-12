package com.study.otherwayjwt.service;

import com.study.otherwayjwt.dto.MemberResponseDto;
import com.study.otherwayjwt.repository.MemberRepository;
import com.study.otherwayjwt.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResponseDto getMemberInfo(String email, String username) {
        return memberRepository.findByEmail(email)
                .map(MemberResponseDto::memberResponseDto)
                .orElseThrow(() -> new RuntimeException("Member 정보가 없습니다. "));
    }

    @Transactional(readOnly = true)
    public MemberResponseDto getLoginMemberInfo(){
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(MemberResponseDto::memberResponseDto)
                .orElseThrow(() -> new RuntimeException("로그인 member 정보가 없습니다."));

    }
}
