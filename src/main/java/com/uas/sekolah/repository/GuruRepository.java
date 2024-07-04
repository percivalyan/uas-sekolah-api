package com.uas.sekolah.repository;

import com.uas.sekolah.entity.Guru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuruRepository extends JpaRepository<Guru, Long> {

    // Tambahkan method khusus jika diperlukan
    
}
