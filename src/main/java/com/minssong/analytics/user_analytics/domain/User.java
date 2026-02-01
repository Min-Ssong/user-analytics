package com.minssong.analytics.user_analytics.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data  // Lombok: getter/setter/toString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")  // 테이블명 명시
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;  // 고유 사용자 ID (LINE userId 대신)

    @Column(nullable = false)
    private String name;

    @CreationTimestamp
    private LocalDateTime joinDate;
}
