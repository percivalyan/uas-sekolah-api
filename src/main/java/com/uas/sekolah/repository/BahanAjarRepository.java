package com.uas.sekolah.repository;

import com.uas.sekolah.entity.BahanAjar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BahanAjarRepository extends JpaRepository<BahanAjar, Integer> {
    // Tambahan kueri kustom jika diperlukan
}
