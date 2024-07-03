package com.uas.sekolah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.sekolah.entity.Siswa;
import com.uas.sekolah.entity.TahunAjaran;
import com.uas.sekolah.repository.SiswaRepository;
import com.uas.sekolah.repository.TahunAjaranRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {

    private final SiswaRepository siswaRepository;
    private final TahunAjaranRepository tahunAjaranRepository;

    @Autowired
    public SiswaService(SiswaRepository siswaRepository, TahunAjaranRepository tahunAjaranRepository) {
        this.siswaRepository = siswaRepository;
        this.tahunAjaranRepository = tahunAjaranRepository;
    }


    public Siswa simpanSiswa(Siswa siswa) {
        TahunAjaran tahunAjaran = siswa.getTahunAjaran();
        if (tahunAjaran != null && tahunAjaran.getId() != 0) {
            tahunAjaran = tahunAjaranRepository.findById(tahunAjaran.getId()).orElse(tahunAjaran);
        }
        siswa.setTahunAjaran(tahunAjaran);
        return siswaRepository.save(siswa);
    }

    public Siswa ubahSiswa(int id, Siswa updatedSiswa) {
        Optional<Siswa> existingSiswa = siswaRepository.findById(id);
        if (existingSiswa.isPresent()) {
            Siswa siswa = existingSiswa.get();
            siswa.setNisn(updatedSiswa.getNisn());
            siswa.setNama_lengkap(updatedSiswa.getNama_lengkap());
            siswa.setTanggal_lahir(updatedSiswa.getTanggal_lahir());
            siswa.setAlamat(updatedSiswa.getAlamat());
            siswa.setNama_ortu(updatedSiswa.getNama_ortu());
            siswa.setTelp(updatedSiswa.getTelp());
            siswa.setStatus(updatedSiswa.isStatus());

            TahunAjaran tahunAjaran = updatedSiswa.getTahunAjaran();
            if (tahunAjaran != null && tahunAjaran.getId() != 0) {
                tahunAjaran = tahunAjaranRepository.findById(tahunAjaran.getId()).orElse(tahunAjaran);
            }
            siswa.setTahunAjaran(tahunAjaran);

            return siswaRepository.save(siswa);
        } else {
            return null; // Handle the case where the siswa is not found
        }
    }

    public void hapusSiswa(int id) {
        siswaRepository.deleteById(id);
    }

    public Siswa findSiswaById(int id) {
        return siswaRepository.findById(id).orElse(null);
    }

    public List<Siswa> findAllSiswa() {
        return siswaRepository.findAll();
    }
}
