package com.uas.sekolah.repository;

import com.uas.sekolah.entity.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Long> {

    // Tambahkan method khusus jika diperlukan
    
}
