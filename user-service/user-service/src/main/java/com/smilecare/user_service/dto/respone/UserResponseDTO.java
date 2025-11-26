package com.smilecare.user_service.dto.respone;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Integer id;
    private String name;
    private String userName;
    private String email;
    private String phone;
    private String address;
    private String roleName; // Trả về tên Role (VD: PATIENT) cho đẹp

    // Constructor tiện lợi
    public UserResponseDTO(Integer id, String name, String userName, String email, String phone, String address, String roleName) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.roleName = roleName;
    }
}