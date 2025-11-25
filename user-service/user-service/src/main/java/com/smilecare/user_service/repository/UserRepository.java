package com.smilecare.user_service.repository;

import com.smilecare.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email); // Kiểm tra trùng email
    Optional<User> findByUserName(String userName); // Tìm theo user name
}