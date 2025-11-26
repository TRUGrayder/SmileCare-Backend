package com.smilecare.user_service.service;

import com.smilecare.user_service.dto.request.LoginRequest;
import com.smilecare.user_service.dto.request.UserRequestDTO;
import com.smilecare.user_service.dto.respone.UserResponseDTO;
import com.smilecare.user_service.entity.Role;
import com.smilecare.user_service.entity.User;
import com.smilecare.user_service.repository.RoleRepository;
import com.smilecare.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // Lấy tất cả User (Chuyển sang DTO)
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Tạo User mới (Từ RequestDTO)
    public UserResponseDTO createUser(UserRequestDTO request) {
        // 1. Kiểm tra Email trùng
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email này đã được sử dụng!");
        }

        // 2. Chuyển DTO -> Entity
        User user = new User();
        user.setName(request.getName());
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Thực tế nên mã hóa
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        // 3. Tìm Role
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role không tồn tại!"));
        user.setRole(role);

        // 4. Lưu
        User savedUser = userRepository.save(user);

        // 5. Trả về Response DTO
        return convertToDTO(savedUser);
    }

    // Hàm phụ: Chuyển Entity -> Response DTO
    private UserResponseDTO convertToDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getUserName(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getRole() != null ? user.getRole().getNameRole() : "Unknown"
        );
    }

    public Boolean checkLogin(LoginRequest request) {
        var user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new RuntimeException("Thông tin đăng nhập không đúng!"));
        if(user.getUserName().equals(request.getUserName()) && user.getPassword().equals(request.getPassword())) {
            return true;
        }

        return false;
    }
}