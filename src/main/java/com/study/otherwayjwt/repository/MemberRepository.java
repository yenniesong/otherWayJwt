package com.study.otherwayjwt.repository;

import com.study.otherwayjwt.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);    // 이미 가입된 이메일인지 확인용
}
