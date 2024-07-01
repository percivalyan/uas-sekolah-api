package com.uas.sekolah.repository;

import com.uas.sekolah.entity.Silabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SilabusRepository extends JpaRepository<Silabus, Integer> {
    // Tambahan kueri kustom jika diperlukan
}
