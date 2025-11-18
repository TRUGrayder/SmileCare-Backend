package com.smilecare.booking_service;


import org.springframework.data.jpa.repository.JpaRepository;
public interface ServiceRepository extends JpaRepository<Service, Integer> {}