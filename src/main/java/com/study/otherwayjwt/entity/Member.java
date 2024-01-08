package com.study.otherwayjwt.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;
    @Column(unique = true)
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

    @ManyToMany
    @JoinTable(
            name = "member_authority",
            joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_status", referencedColumnName = "authority_status")}
        private Set<Authority> authorities = new HashSet<>();
    )

    @Builder
    public Member(String email, String password, String username, Authority authority) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.authority = authority;
    }
}
