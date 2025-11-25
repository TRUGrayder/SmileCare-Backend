package com.smilecare.user_service.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Integer roleId; // Khách chỉ cần gửi ID của role (VD: 2 là Patient)
}