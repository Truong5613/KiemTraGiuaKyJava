package com.example.__NguyenHuyTruong.Model;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class NhanVien {

    @Id
    @Column(name = "Ma_NV", length = 3, nullable = false)
    private String maNV;

    @Column(name = "Ten_NV", length = 100, nullable = false)
    private String tenNV;

    @Column(name = "Phai", length = 3)
    private String phai;

    @Column(name = "Noi_Sinh", length = 200)
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong", nullable = false)
    private PhongBan phongBan;

    @Column(name = "Luong")
    private int luong;


}
