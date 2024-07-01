package com.uas.sekolah.controller;

import com.uas.sekolah.entity.BahanAjar;
import com.uas.sekolah.service.BahanAjarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/bahan-ajar")
public class BahanAjarController {

    @Autowired
    private BahanAjarService bahanAjarService;

    @PostMapping("/create")
    public ResponseEntity<String> simpanBahanAjar(@RequestBody BahanAjar bahanAjar) {
        return bahanAjarService.simpanBahanAjar(bahanAjar);
    }

    @GetMapping("/all")
    public List<BahanAjar> lihatBahanAjar() {
        return bahanAjarService.lihatBahanAjar();
    }
    // Tambahan
    @GetMapping("/{id}")
    public BahanAjar getBahanAjarById(@PathVariable("id") int id) {
        return bahanAjarService.getBahanAjarById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> ubahBahanAjar(@PathVariable("id") int id, @RequestBody BahanAjar updatedBahanAjar) {
        return bahanAjarService.ubahBahanAjar(id, updatedBahanAjar);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> hapusBahanAjar(@PathVariable("id") int id) {
        return bahanAjarService.hapusBahanAjar(id);
    }
}
