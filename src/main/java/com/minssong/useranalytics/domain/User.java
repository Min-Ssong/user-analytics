package com.minssong.useranalytics.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data  // Lombok: getter/setter/toString
@Table(name = "users")  // 테이블명 명시
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;  // 고유 사용자 ID (LINE userId 대신)

    @Column(nullable = false)
    private String name;

    private LocalDateTime joinDate = LocalDateTime.now();

    // 기본 생성자 (JPA 필수)
    public User() {}

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
