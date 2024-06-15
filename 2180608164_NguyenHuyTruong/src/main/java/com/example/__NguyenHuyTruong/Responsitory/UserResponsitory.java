package com.example.__NguyenHuyTruong.Responsitory;

import com.example.__NguyenHuyTruong.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsitory extends JpaRepository<User, Integer> {
    User getUserByUsername(String username);
}
