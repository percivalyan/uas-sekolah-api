package com.uas.sekolah.service;

import com.uas.sekolah.entity.MataPelajaran;
import com.uas.sekolah.entity.PrestasiAkademik;
import com.uas.sekolah.repository.MataPelajaranRepository;
import com.uas.sekolah.repository.PrestasiAkademikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@Service
public class PrestasiAkademikService {

    @Autowired
    private PrestasiAkademikRepository prestasiAkademikRepository;

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;

    @Transactional
    public ResponseEntity<String> simpanPrestasiAkademik(PrestasiAkademik prestasiAkademik) {
        try {
            validateAndSetMataPelajaran(prestasiAkademik);
            prestasiAkademikRepository.save(prestasiAkademik);

            return ResponseEntity.status(HttpStatus.CREATED).body("Prestasi Akademik with ID " + prestasiAkademik.getId() + " created successfully");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating Prestasi Akademik", e);
        }
    }

    public List<PrestasiAkademik> lihatPrestasiAkademik() {
        return prestasiAkademikRepository.findAll();
    }

    public PrestasiAkademik getPrestasiAkademikById(int id) {
        return prestasiAkademikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prestasi Akademik not found"));
    }

    @Transactional
    public ResponseEntity<String> ubahPrestasiAkademik(int id, PrestasiAkademik updatedPrestasiAkademik) {
        try {
            PrestasiAkademik existingPrestasiAkademik = prestasiAkademikRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prestasi Akademik not found"));

            existingPrestasiAkademik.setIdSiswa(updatedPrestasiAkademik.getIdSiswa());
            existingPrestasiAkademik.setMataPelajaran(updatedPrestasiAkademik.getMataPelajaran());
            existingPrestasiAkademik.setDate(updatedPrestasiAkademik.getDate());
            existingPrestasiAkademik.setJenisPrestasi(updatedPrestasiAkademik.getJenisPrestasi());
            existingPrestasiAkademik.setDeskripsiAtauNilai(updatedPrestasiAkademik.getDeskripsiAtauNilai());

            validateAndSetMataPelajaran(existingPrestasiAkademik);

            prestasiAkademikRepository.save(existingPrestasiAkademik);

            return new ResponseEntity<>("Prestasi Akademik updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating Prestasi Akademik", e);
        }
    }

    @Transactional
    public ResponseEntity<String> hapusPrestasiAkademik(int id) {
        try {
            PrestasiAkademik prestasiAkademik = prestasiAkademikRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prestasi Akademik not found"));

            prestasiAkademikRepository.delete(prestasiAkademik);

            return new ResponseEntity<>("Prestasi Akademik deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting Prestasi Akademik", e);
        }
    }

    private void validateAndSetMataPelajaran(PrestasiAkademik prestasiAkademik) {
        MataPelajaran mataPelajaran = mataPelajaranRepository.findById(prestasiAkademik.getMataPelajaran().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));

        prestasiAkademik.setMataPelajaran(mataPelajaran);
    }
}
