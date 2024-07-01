package com.uas.sekolah.service;

import com.uas.sekolah.entity.BahanAjar;
import com.uas.sekolah.entity.MataPelajaran;
import com.uas.sekolah.repository.BahanAjarRepository;
import com.uas.sekolah.repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BahanAjarService {

    @Autowired
    private BahanAjarRepository bahanAjarRepository;

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;

    @Transactional
    public ResponseEntity<String> simpanBahanAjar(BahanAjar bahanAjar) {
        try {
            MataPelajaran mataPelajaran = mataPelajaranRepository.findById(bahanAjar.getMataPelajaran().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));

            bahanAjar.setMataPelajaran(mataPelajaran);

            bahanAjarRepository.save(bahanAjar);

            return ResponseEntity.status(HttpStatus.CREATED).body("Bahan Ajar with ID " + bahanAjar.getId() + " created successfully");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating Bahan Ajar", e);
        }
    }

    public List<BahanAjar> lihatBahanAjar() {
        return bahanAjarRepository.findAll();
    }

    public BahanAjar getBahanAjarById(int id) {
        return bahanAjarRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bahan Ajar not found"));
    }

    @Transactional
    public ResponseEntity<String> ubahBahanAjar(int id, BahanAjar updatedBahanAjar) {
        try {
            BahanAjar existingBahanAjar = bahanAjarRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bahan Ajar not found"));

            existingBahanAjar.setJudul(updatedBahanAjar.getJudul());
            existingBahanAjar.setDeskripsi(updatedBahanAjar.getDeskripsi());
            existingBahanAjar.setTipe(updatedBahanAjar.getTipe());
            existingBahanAjar.setFile(updatedBahanAjar.getFile());

            // Check and update associated MataPelajaran if necessary
            if (updatedBahanAjar.getMataPelajaran() != null) {
                MataPelajaran mataPelajaran = mataPelajaranRepository.findById(updatedBahanAjar.getMataPelajaran().getId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
                existingBahanAjar.setMataPelajaran(mataPelajaran);
            }

            bahanAjarRepository.save(existingBahanAjar);

            return new ResponseEntity<>("Bahan Ajar updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating Bahan Ajar", e);
        }
    }

    @Transactional
    public ResponseEntity<String> hapusBahanAjar(int id) {
        try {
            BahanAjar bahanAjar = bahanAjarRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bahan Ajar not found"));

            bahanAjarRepository.delete(bahanAjar);

            return new ResponseEntity<>("Bahan Ajar deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting Bahan Ajar", e);
        }
    }
}
