package com.study.otherwayjwt.controller;

import com.study.otherwayjwt.dto.JwtTokenDto;
import com.study.otherwayjwt.dto.MemberRequestDto;
import com.study.otherwayjwt.dto.MemberResponseDto;
import com.study.otherwayjwt.dto.TokenRequestDto;
import com.study.otherwayjwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
//@RequestMapping("/naebang")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto){
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }
    @PostMapping("/login")
    public ResponseEntity<MemberResponseDto> login(@RequestBody MemberRequestDto memberRequestDto){
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }
    @PostMapping("/reissue")
    public ResponseEntity<JwtTokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto){
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }





}
