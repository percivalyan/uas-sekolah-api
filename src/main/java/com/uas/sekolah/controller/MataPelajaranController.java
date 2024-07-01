package com.uas.sekolah.controller;

import com.uas.sekolah.entity.BahanAjar;
import com.uas.sekolah.entity.MataPelajaran;
import com.uas.sekolah.service.BahanAjarService;
import com.uas.sekolah.service.JadwalPelajaranService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MataPelajaranController {

    @Autowired
    private JadwalPelajaranService jadwalPelajaranService;

    @GetMapping("/mata-pelajaran")
    public ResponseEntity<List<MataPelajaran>> getAllMataPelajaran() {
        List<MataPelajaran> mataPelajaranList = jadwalPelajaranService.getAllMataPelajaran();
        return new ResponseEntity<>(mataPelajaranList, HttpStatus.OK);
    }

    @GetMapping("/mata-pelajaran/{id}")
    public ResponseEntity<MataPelajaran> getMataPelajaranById(@PathVariable("id") int id) {
        MataPelajaran mataPelajaran = jadwalPelajaranService.getMataPelajaranById(id);
        return new ResponseEntity<>(mataPelajaran, HttpStatus.OK);
    }

    @PostMapping("/mata-pelajaran")
    public ResponseEntity<MataPelajaran> saveMataPelajaran(@RequestBody MataPelajaran mataPelajaran) {
        MataPelajaran savedMataPelajaran = jadwalPelajaranService.saveMataPelajaran(mataPelajaran);
        return new ResponseEntity<>(savedMataPelajaran, HttpStatus.CREATED);
    }

    @PutMapping("/mata-pelajaran/{id}")
    public ResponseEntity<MataPelajaran> updateMataPelajaran(@PathVariable("id") int id, @RequestBody MataPelajaran mataPelajaran) {
        mataPelajaran.setId(id);
        MataPelajaran updatedMataPelajaran = jadwalPelajaranService.updateMataPelajaran(mataPelajaran);
        return new ResponseEntity<>(updatedMataPelajaran, HttpStatus.OK);
    }

    @DeleteMapping("/mata-pelajaran/{id}")
    public ResponseEntity<String> deleteMataPelajaran(@PathVariable("id") int id) {
        String message = jadwalPelajaranService.deleteMataPelajaran(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}