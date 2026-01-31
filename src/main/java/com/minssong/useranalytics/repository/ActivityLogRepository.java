package com.minssong.useranalytics.repository;

import com.minssong.useranalytics.domain.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
//    // 최근 7일 활동
//    @Query("SELECT a FROM ActivityLog a WHERE a.timestamp > CURRENT_DATE - 7")
//    List<ActivityLog> findRecentActivities();
//
//    // 사용자별 로그인 횟수
//    @Query("SELECT COUNT(a) FROM ActivityLog a WHERE a.userId = ?1 AND a.eventType = 'LOGIN'")
//    long countLoginsByUserId(Long userId);

    // ✅ 수정된 쿼리 (nativeQuery 사용)
    @Query(value = "SELECT * FROM activity_logs WHERE timestamp > DATE_SUB(NOW(), INTERVAL 7 DAY)", nativeQuery = true)
    List<ActivityLog> findRecentActivities();

    @Query(value = "SELECT COUNT(*) FROM activity_logs WHERE user_id = ?1 AND event_type = 'LOGIN'", nativeQuery = true)
    long countLoginsByUserId(Long userId);
}
