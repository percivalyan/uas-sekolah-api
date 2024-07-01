package com.uas.sekolah.repository;

import com.uas.sekolah.entity.MataPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MataPelajaranRepository extends JpaRepository<MataPelajaran, Integer> {
    // Tambahan kueri kustom jika diperlukan
}
