package com.uas.sekolah.service;

import com.uas.sekolah.entity.MataPelajaran;
import com.uas.sekolah.repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MataPelajaranService {
    
    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;
    
    public List<MataPelajaran> lihatMapel() {
        return mataPelajaranRepository.findAll();
    }
    
    public Optional<MataPelajaran> getMapelById(int id) {
        return mataPelajaranRepository.findById(id);
    }
    
    public MataPelajaran simpanMapel(MataPelajaran mataPelajaran) {
        return mataPelajaranRepository.save(mataPelajaran);
    }
    
    public MataPelajaran ubahMapel(MataPelajaran mataPelajaran) {
        return mataPelajaranRepository.save(mataPelajaran);
    }
    
    public void hapusMapel(int id) {
        mataPelajaranRepository.deleteById(id);
    }
}
