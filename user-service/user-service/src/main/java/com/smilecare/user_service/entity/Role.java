package com.smilecare.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "role")
@Data // Lombok tự tạo Getter/Setter
public class Role {
    @Id
    private Integer id;

    @Column(name = "namerole")
    private String nameRole;

    @Column(name = "Description")
    private String description;
}