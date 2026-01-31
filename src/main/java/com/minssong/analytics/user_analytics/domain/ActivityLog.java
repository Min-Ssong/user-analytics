package com.minssong.analytics.user_analytics.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activity_logs")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;  // User 외래키

    @Column(nullable = false)
    private String eventType;  // "LOGIN", "LOGOUT", "VIEW_POST", "PURCHASE"

    private String details;  // 추가 메타데이터

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}
