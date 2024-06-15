package com.example.__NguyenHuyTruong.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class PhongBan {

    @Id
    @Column(name = "Ma_Phong", length = 2, nullable = false)
    private String maPhong;

    @Column(name = "Ten_Phong", length = 30, nullable = false)
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL)
    private Set<NhanVien> nhanViens;


}
