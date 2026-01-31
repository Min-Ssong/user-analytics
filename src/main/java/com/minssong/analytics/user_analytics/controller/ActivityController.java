package com.minssong.analytics.user_analytics.controller;

import com.minssong.analytics.user_analytics.domain.ActivityLog;
import com.minssong.analytics.user_analytics.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @PostMapping
    public ActivityLog logActivity(@RequestBody ActivityLog log) {
        return activityLogRepository.save(log);
    }

    @GetMapping
    public List<ActivityLog> getRecentActivities() {
        return activityLogRepository.findRecentActivities();
    }

    @GetMapping("/user/{userId}/logins")
    public long getUserLoginCount(@PathVariable Long userId) {
        return activityLogRepository.countLoginsByUserId(userId);
    }
}
