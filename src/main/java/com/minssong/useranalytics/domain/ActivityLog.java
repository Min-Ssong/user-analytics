package com.minssong.useranalytics.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
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

    // 생성자
    public ActivityLog() {}

    public ActivityLog(Long userId, String eventType, String details) {
        this.userId = userId;
        this.eventType = eventType;
        this.details = details;
    }
}
