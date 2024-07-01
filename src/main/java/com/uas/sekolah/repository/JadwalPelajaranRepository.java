package com.uas.sekolah.repository;

import com.uas.sekolah.entity.JadwalPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadwalPelajaranRepository extends JpaRepository<JadwalPelajaran, Integer> {
    // Tambahan kueri kustom jika diperlukan
}
