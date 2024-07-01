package com.uas.sekolah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.sekolah.entity.MataPelajaran;
import com.uas.sekolah.entity.Silabus;
import com.uas.sekolah.repository.MataPelajaranRepository;
import com.uas.sekolah.repository.SilabusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SilabusService {

    private final SilabusRepository silabusRepository;
    private final MataPelajaranRepository mataPelajaranRepository;

    @Autowired
    public SilabusService(SilabusRepository silabusRepository, MataPelajaranRepository mataPelajaranRepository) {
        this.silabusRepository = silabusRepository;
        this.mataPelajaranRepository = mataPelajaranRepository;
    }

    public Silabus createSilabus(Silabus silabus) {
        MataPelajaran mataPelajaran = silabus.getMataPelajaran();
        if (mataPelajaran != null && mataPelajaran.getId() != 0) {
            mataPelajaran = mataPelajaranRepository.findById(mataPelajaran.getId()).orElse(mataPelajaran);
        }
        silabus.setMataPelajaran(mataPelajaran);
        return silabusRepository.save(silabus);
    }

    public Silabus updateSilabus(int id, Silabus updatedSilabus) {
        Optional<Silabus> existingSilabus = silabusRepository.findById(id);
        if (existingSilabus.isPresent()) {
            Silabus silabus = existingSilabus.get();
            silabus.setJudul(updatedSilabus.getJudul());
            silabus.setDeskripsi(updatedSilabus.getDeskripsi());
            silabus.setTujuan(updatedSilabus.getTujuan());
            silabus.setMateri(updatedSilabus.getMateri());
            silabus.setMetode(updatedSilabus.getMetode());
            silabus.setEvaluasi(updatedSilabus.getEvaluasi());

            MataPelajaran mataPelajaran = updatedSilabus.getMataPelajaran();
            if (mataPelajaran != null && mataPelajaran.getId() != 0) {
                mataPelajaran = mataPelajaranRepository.findById(mataPelajaran.getId()).orElse(mataPelajaran);
                silabus.setMataPelajaran(mataPelajaran);
            } else {
                silabus.setMataPelajaran(mataPelajaran);
            }

            return silabusRepository.save(silabus);
        } else {
            return null; // Handle the case where the silabus is not found
        }
    }

    public void deleteSilabus(int id) {
        silabusRepository.deleteById(id);
    }

    public Silabus findSilabusById(int id) {
        return silabusRepository.findById(id).orElse(null);
    }

    public List<Silabus> findAllSilabus() {
        return silabusRepository.findAll();
    }
}
