package com.minssong.analytics.user_analytics.repository;

import com.minssong.analytics.user_analytics.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);  // 사용자 ID로 조회
}
