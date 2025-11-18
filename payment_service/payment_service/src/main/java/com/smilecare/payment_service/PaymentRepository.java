package com.smilecare.payment_service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // JpaRepository<TênEntity, KiểuDữLiệuKhóaChính>
}