package com.uas.sekolah.service;

import com.uas.sekolah.entity.Kehadiran;
import com.uas.sekolah.entity.Siswa;
import com.uas.sekolah.repository.KehadiranRepository;
import com.uas.sekolah.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KehadiranService {

    @Autowired
    private KehadiranRepository kehadiranRepository;

    @Autowired
    private SiswaRepository siswaRepository;

    public List<Kehadiran> getAllKehadiran() {
        return kehadiranRepository.findAll();
    }

    public Optional<Kehadiran> getKehadiranById(int id) {
        return kehadiranRepository.findById(id);
    }

    public Kehadiran saveKehadiran(Kehadiran kehadiran, int siswaId) {
        Optional<Siswa> siswa = siswaRepository.findById(siswaId);
        if (siswa.isPresent()) {
            kehadiran.setSiswa(siswa.get());
            return kehadiranRepository.save(kehadiran);
        } else {
            throw new RuntimeException("Siswa not found with id " + siswaId);
        }
    }

    public Kehadiran updateKehadiran(int id, Kehadiran kehadiranDetails) {
        Optional<Kehadiran> kehadiran = kehadiranRepository.findById(id);
        if (kehadiran.isPresent()) {
            Kehadiran existingKehadiran = kehadiran.get();
            existingKehadiran.setTanggal(kehadiranDetails.getTanggal());
            existingKehadiran.setStatus(kehadiranDetails.getStatus());
            existingKehadiran.setKehadiran(kehadiranDetails.getKehadiran());
            existingKehadiran.setKeterangan(kehadiranDetails.getKeterangan());
            return kehadiranRepository.save(existingKehadiran);
        } else {
            throw new RuntimeException("Kehadiran not found with id " + id);
        }
    }

    public void deleteKehadiran(int id) {
        kehadiranRepository.deleteById(id);
    }
}
