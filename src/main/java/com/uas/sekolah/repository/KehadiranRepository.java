package com.uas.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uas.sekolah.entity.Kehadiran;

@Repository
public interface KehadiranRepository extends JpaRepository<Kehadiran, Integer> {
    // Custom query methods can be added here if needed
}
