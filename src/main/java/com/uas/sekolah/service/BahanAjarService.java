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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class BahanAjarService {

    @Autowired
    private BahanAjarRepository bahanAjarRepository;

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;

    @Transactional
    public ResponseEntity<String> simpanBahanAjar(BahanAjar bahanAjar, MultipartFile file) {
        try {
            validateAndSetMataPelajaran(bahanAjar);

            if (file != null && !file.isEmpty()) {
                bahanAjar.setFileType("PDF"); // Assuming PDF as the file type
                bahanAjar.setFile(file.getBytes()); // Save file contents or its metadata
            }

            bahanAjarRepository.save(bahanAjar);

            return ResponseEntity.status(HttpStatus.CREATED).body("Bahan Ajar with ID " + bahanAjar.getId() + " created successfully");
        } catch (ResponseStatusException e) {
            throw e;
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error saving file for Bahan Ajar", e);
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
    public ResponseEntity<String> ubahBahanAjar(int id, BahanAjar updatedBahanAjar, MultipartFile file) {
        try {
            BahanAjar existingBahanAjar = bahanAjarRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bahan Ajar not found"));

            existingBahanAjar.setJudul(updatedBahanAjar.getJudul());
            existingBahanAjar.setDeskripsi(updatedBahanAjar.getDeskripsi());
            existingBahanAjar.setTipe(updatedBahanAjar.getTipe());

            if (file != null && !file.isEmpty()) {
                existingBahanAjar.setFileType("PDF"); // Assuming PDF as the file type
                existingBahanAjar.setFile(file.getBytes()); // Update file contents or its metadata
            }

            validateAndSetMataPelajaran(updatedBahanAjar, existingBahanAjar);

            bahanAjarRepository.save(existingBahanAjar);

            return new ResponseEntity<>("Bahan Ajar updated successfully", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error saving file for Bahan Ajar", e);
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
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting Bahan Ajar", e);
        }
    }

    private void validateAndSetMataPelajaran(BahanAjar bahanAjar) {
        MataPelajaran mataPelajaran = mataPelajaranRepository.findById(bahanAjar.getMataPelajaran().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));

        bahanAjar.setMataPelajaran(mataPelajaran);
    }

    private void validateAndSetMataPelajaran(BahanAjar updatedBahanAjar, BahanAjar existingBahanAjar) {
        if (updatedBahanAjar.getMataPelajaran() != null) {
            MataPelajaran mataPelajaran = mataPelajaranRepository.findById(updatedBahanAjar.getMataPelajaran().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
            existingBahanAjar.setMataPelajaran(mataPelajaran);
        }
    }

    public MataPelajaran getMataPelajaranById(int id) {
        return mataPelajaranRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
    }
}
