package com.example.__NguyenHuyTruong.Service;

import com.example.__NguyenHuyTruong.Model.NhanVien;
import com.example.__NguyenHuyTruong.Responsitory.NhanVienResponsitory;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {
    private final NhanVienResponsitory nhanVienResponsitory;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienResponsitory.findAll();
    }
    // Retrieve a product by its id
    public Optional<NhanVien> getNhanVienById(String id) {
        return nhanVienResponsitory.findById(id);
    }
    // Add a new product to the database
    public NhanVien addNhanVien(NhanVien product) {
        return nhanVienResponsitory.save(product);
    }

    public void editNhanVien(@NotNull NhanVien nhanVien) {
        NhanVien existingNhanVien = nhanVienResponsitory.findById(nhanVien.getMaNV())
                .orElseThrow(() -> new IllegalStateException("Nhan Vien Voi Id " + nhanVien.getMaNV() + " Khong Ton tai."));
        existingNhanVien.setTenNV(nhanVien.getTenNV());
        existingNhanVien.setPhai(nhanVien.getPhai());
        existingNhanVien.setLuong(nhanVien.getLuong());
        existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanVien.setPhongBan(nhanVien.getPhongBan());
        nhanVienResponsitory.save(existingNhanVien);
    }



    public void deleteNhanVienById(String id) {
        if (!nhanVienResponsitory.existsById(id)) {
            throw new IllegalStateException("Nhan Vien Voi Id: " + id + " Khong Ton tai.");
        }
        nhanVienResponsitory.deleteById(id);
    }

    public Page<NhanVien> getNhanViensPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanVienResponsitory.findAll(pageable);
    }
}
