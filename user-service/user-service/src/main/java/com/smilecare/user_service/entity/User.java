package com.smilecare.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "username")
    private String userName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    // Liên kết Role (EAGER để lấy tên Role luôn)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid")
    private Role role;
}