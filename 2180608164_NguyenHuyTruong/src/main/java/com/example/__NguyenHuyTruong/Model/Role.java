package com.example.__NguyenHuyTruong.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")  // Ensure the column name is role_id
    private Integer roleId;    // Change field name to roleId

    @Column
    private String name;
}
