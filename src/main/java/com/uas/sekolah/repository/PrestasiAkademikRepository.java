package com.uas.sekolah.repository;

import com.uas.sekolah.entity.PrestasiAkademik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestasiAkademikRepository extends JpaRepository<PrestasiAkademik, Integer> {
    // Anda dapat menambahkan metode khusus jika diperlukan
}
