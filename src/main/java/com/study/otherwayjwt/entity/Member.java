package com.study.otherwayjwt.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String username;
    private String profileImg;
    @Enumerated(EnumType.STRING)
    private Authority authority;
    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public Member(String email, String password, String username, Authority authority) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.authority = authority;
    }
}
