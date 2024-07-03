package com.uas.sekolah.controller;

import com.uas.sekolah.entity.PrestasiAkademik;
import com.uas.sekolah.service.PrestasiAkademikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/prestasi-akademik")
public class PrestasiAkademikController {

    @Autowired
    private PrestasiAkademikService prestasiAkademikService;

    @GetMapping
    public ResponseEntity<List<PrestasiAkademik>> lihatSemuaPrestasiAkademik() {
        try {
            List<PrestasiAkademik> prestasiAkademiks = prestasiAkademikService.lihatPrestasiAkademik();
            return ResponseEntity.ok().body(prestasiAkademiks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestasiAkademik> lihatPrestasiAkademikById(@PathVariable("id") int id) {
        try {
            PrestasiAkademik prestasiAkademik = prestasiAkademikService.getPrestasiAkademikById(id);
            if (prestasiAkademik != null) {
                return ResponseEntity.ok().body(prestasiAkademik);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> tambahPrestasiAkademik(@Valid @RequestBody PrestasiAkademik prestasiAkademik) {
        try {
            ResponseEntity<String> response = prestasiAkademikService.simpanPrestasiAkademik(prestasiAkademik);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create Prestasi Akademik");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> ubahPrestasiAkademik(@PathVariable("id") int id, @Valid @RequestBody PrestasiAkademik updatedPrestasiAkademik) {
        try {
            ResponseEntity<String> response = prestasiAkademikService.ubahPrestasiAkademik(id, updatedPrestasiAkademik);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update Prestasi Akademik");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> hapusPrestasiAkademik(@PathVariable("id") int id) {
        try {
            ResponseEntity<String> response = prestasiAkademikService.hapusPrestasiAkademik(id);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Prestasi Akademik");
        }
    }
}
