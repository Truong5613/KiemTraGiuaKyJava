package com.example.__NguyenHuyTruong.Service;

import com.example.__NguyenHuyTruong.Model.NhanVien;
import com.example.__NguyenHuyTruong.Model.PhongBan;
import com.example.__NguyenHuyTruong.Responsitory.PhongBanResponsitory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PhongBanService {
    private final PhongBanResponsitory phongBanResponsitory;

    public List<PhongBan> getAll() {
        return phongBanResponsitory.findAll();
    }
}
