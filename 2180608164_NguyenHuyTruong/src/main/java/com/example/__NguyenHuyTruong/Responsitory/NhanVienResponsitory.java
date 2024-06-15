package com.example.__NguyenHuyTruong.Responsitory;

import com.example.__NguyenHuyTruong.Model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienResponsitory extends JpaRepository<NhanVien,String> {

}
