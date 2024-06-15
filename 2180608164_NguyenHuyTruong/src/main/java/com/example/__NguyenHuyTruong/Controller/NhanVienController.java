package com.example.__NguyenHuyTruong.Controller;

import com.example.__NguyenHuyTruong.Model.NhanVien;
import com.example.__NguyenHuyTruong.Service.NhanVienService;
import com.example.__NguyenHuyTruong.Service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/NhanVien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping("")
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<NhanVien> nhanVienPage = nhanVienService.getNhanViensPaginated(page, size);
        model.addAttribute("nhanVienPage", nhanVienPage);

        return "NhanVien/index";
    }

    @GetMapping("/add")
    public String create (Model model) {
        model.addAttribute("NhanVien", new NhanVien());
        model.addAttribute("PhongBan", phongBanService.getAll());
        return "NhanVien/add";
    }

    @PostMapping("/add")
    public String addCategory(@Valid NhanVien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return "NhanVien/add";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/NhanVien";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        NhanVien editnhanVien = nhanVienService.getNhanVienById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ma Nhan Vien Khong Hop le:"
                        + id));
        model.addAttribute("NhanVien", editnhanVien);
        model.addAttribute("PhongBan", phongBanService.getAll());
        return "NhanVien/edit";
    }
    // POST request to update category
    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable("id") String id, @Valid NhanVien editNhanVien,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("NhanVien", editNhanVien);
            return "NhanVien/edit";
        }
            nhanVienService.editNhanVien(editNhanVien);
        return "redirect:/NhanVien";
    }
    // GET request for deleting category
    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") String id, Model model) {
        NhanVien deleteNhanVien = nhanVienService.getNhanVienById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ma Nhan Vien Khong Hop Le:"
                        + id));
        nhanVienService.deleteNhanVienById(id);

        return "redirect:/NhanVien";
    }

}
