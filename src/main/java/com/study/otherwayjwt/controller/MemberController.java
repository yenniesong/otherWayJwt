package com.study.otherwayjwt.controller;

import com.study.otherwayjwt.dto.MemberResponseDto;
import com.study.otherwayjwt.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/my")
    public ResponseEntity<MemberResponseDto> getLoginMemberInfo(){
        return ResponseEntity.ok(memberService.getLoginMemberInfo());
    }

    @GetMapping("/{email}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String email, String username) {
        return ResponseEntity.ok(memberService.getMemberInfo(email, username));
    }
}
