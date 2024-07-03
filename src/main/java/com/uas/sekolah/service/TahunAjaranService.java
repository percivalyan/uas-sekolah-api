package com.uas.sekolah.service;

import com.uas.sekolah.entity.TahunAjaran;
import com.uas.sekolah.repository.TahunAjaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TahunAjaranService {

    @Autowired
    private TahunAjaranRepository tahunAjaranRepository;

    public TahunAjaran simpanTA(TahunAjaran tahunAjaran) {
        return tahunAjaranRepository.save(tahunAjaran);
    }

    public void hapusTA(int id) {
        tahunAjaranRepository.deleteById(id);
    }

    public TahunAjaran ubahTA(int id, TahunAjaran tahunAjaranUpdate) {
        Optional<TahunAjaran> tahunAjaranOptional = tahunAjaranRepository.findById(id);
        if (tahunAjaranOptional.isPresent()) {
            TahunAjaran tahunAjaran = tahunAjaranOptional.get();
            tahunAjaran.setTahun(tahunAjaranUpdate.getTahun());
            tahunAjaran.setPeriode(tahunAjaranUpdate.getPeriode());
            tahunAjaran.setTglMulai(tahunAjaranUpdate.getTglMulai());
            tahunAjaran.setTglAkhir(tahunAjaranUpdate.getTglAkhir());
            tahunAjaran.setKurikulum(tahunAjaranUpdate.getKurikulum());
            return tahunAjaranRepository.save(tahunAjaran);
        } else {
            throw new IllegalArgumentException("Tahun Ajaran dengan ID " + id + " tidak ditemukan.");
        }
    }

    public List<TahunAjaran> lihatTA() {
        return tahunAjaranRepository.findAll();
    }
}
