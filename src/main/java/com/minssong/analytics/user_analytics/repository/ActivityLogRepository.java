package com.minssong.analytics.user_analytics.repository;

import com.minssong.analytics.user_analytics.domain.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@SuppressWarnings("SqlNoDataSourceInspection")
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    // ✅ 수정된 쿼리 (nativeQuery 사용)
    @Query(value = "SELECT * FROM activity_logs WHERE timestamp > DATE_SUB(NOW(), INTERVAL 7 DAY)", nativeQuery = true)
    List<ActivityLog> findRecentActivities();

    @Query(value = "SELECT COUNT(*) FROM activity_logs WHERE user_id = ?1 AND event_type = 'LOGIN'", nativeQuery = true)
    long countLoginsByUserId(Long userId);
}
