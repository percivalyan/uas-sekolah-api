package com.uas.sekolah.controller;

import com.uas.sekolah.entity.MataPelajaran;
import com.uas.sekolah.service.MataPelajaranService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/mata-pelajaran")
public class MataPelajaranController {

    @Autowired
    private MataPelajaranService mataPelajaranService;

    @GetMapping
    public ResponseEntity<List<MataPelajaran>> lihatMataPelajaran() {
        List<MataPelajaran> mataPelajaranList = mataPelajaranService.lihatMataPelajaran();
        return new ResponseEntity<>(mataPelajaranList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MataPelajaran> getMataPelajaranById(@PathVariable("id") int id) {
        return mataPelajaranService.getMataPelajaranById(id)
                .map(mataPelajaran -> new ResponseEntity<>(mataPelajaran, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MataPelajaran> simpanMataPelajaran(@RequestBody MataPelajaran mataPelajaran) {
        MataPelajaran savedMataPelajaran = mataPelajaranService.simpanMataPelajaran(mataPelajaran);
        return new ResponseEntity<>(savedMataPelajaran, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MataPelajaran> ubahMataPelajaran(@PathVariable("id") int id, @RequestBody MataPelajaran mataPelajaran) {
        mataPelajaran.setId(id);
        MataPelajaran updatedMataPelajaran = mataPelajaranService.ubahMataPelajaran(mataPelajaran);
        return new ResponseEntity<>(updatedMataPelajaran, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapusMataPelajaran(@PathVariable("id") int id) {
        mataPelajaranService.hapusMataPelajaran(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
