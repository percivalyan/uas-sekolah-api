package com.uas.sekolah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.uas.sekolah.entity.JadwalPelajaran;
import com.uas.sekolah.entity.MataPelajaran;
import com.uas.sekolah.repository.JadwalPelajaranRepository;
import com.uas.sekolah.repository.MataPelajaranRepository;

@Service
public class JadwalPelajaranService {

    @Autowired
    private JadwalPelajaranRepository jadwalPelajaranRepository;

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;

    public JadwalPelajaran saveJadwalPelajaran(JadwalPelajaran jadwalPelajaran) {
        return jadwalPelajaranRepository.save(jadwalPelajaran);
    }

    public List<JadwalPelajaran> getAllJadwalPelajaran() {
        return jadwalPelajaranRepository.findAll();
    }

    public JadwalPelajaran getJadwalPelajaranById(int id) {
        return jadwalPelajaranRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));
    }

    public JadwalPelajaran updateJadwalPelajaran(JadwalPelajaran jadwalPelajaran) {
        JadwalPelajaran existingJadwal = jadwalPelajaranRepository.findById(jadwalPelajaran.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));

        // Update fields
        existingJadwal.setIdSiswa(jadwalPelajaran.getIdSiswa());
        existingJadwal.setMataPelajaran(jadwalPelajaran.getMataPelajaran());
        existingJadwal.setIdGuru(jadwalPelajaran.getIdGuru());
        existingJadwal.setIdKelas(jadwalPelajaran.getIdKelas());
        existingJadwal.setHari(jadwalPelajaran.getHari());
        existingJadwal.setJamMulai(jadwalPelajaran.getJamMulai());
        existingJadwal.setJamSelesai(jadwalPelajaran.getJamSelesai());

        return jadwalPelajaranRepository.save(existingJadwal);
    }

    public String deleteJadwalPelajaran(int id) {
        JadwalPelajaran jadwalPelajaran = jadwalPelajaranRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));
        jadwalPelajaranRepository.delete(jadwalPelajaran);

        return "Jadwal Pelajaran removed: " + id;
    }

    public MataPelajaran saveMataPelajaran(MataPelajaran mataPelajaran) {
        return mataPelajaranRepository.save(mataPelajaran);
    }

    public List<MataPelajaran> getAllMataPelajaran() {
        return mataPelajaranRepository.findAll();
    }

    public MataPelajaran getMataPelajaranById(int id) {
        return mataPelajaranRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
    }

    public MataPelajaran updateMataPelajaran(MataPelajaran mataPelajaran) {
        MataPelajaran existingMataPelajaran = mataPelajaranRepository.findById(mataPelajaran.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));

        // Update fields
        existingMataPelajaran.setKodeMapel(mataPelajaran.getKodeMapel());
        existingMataPelajaran.setNamaMapel(mataPelajaran.getNamaMapel());
        existingMataPelajaran.setTingkat(mataPelajaran.getTingkat());

        return mataPelajaranRepository.save(existingMataPelajaran);
    }

    public String deleteMataPelajaran(int id) {
        MataPelajaran mataPelajaran = mataPelajaranRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
        mataPelajaranRepository.delete(mataPelajaran);

        return "Mata Pelajaran removed: " + id;
    }
}
