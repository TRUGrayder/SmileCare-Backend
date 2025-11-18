package com.smilecare.booking_service;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {}