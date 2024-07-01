package com.uas.sekolah.controller;

import com.uas.sekolah.entity.BahanAjar;
import com.uas.sekolah.service.BahanAjarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bahan-ajar")
public class BahanAjarController {

    @Autowired
    private BahanAjarService bahanAjarService;

    @PostMapping("/create")
    public ResponseEntity<String> createBahanAjar(@RequestBody BahanAjar bahanAjar) {
        return bahanAjarService.createBahanAjar(bahanAjar);
    }

    @GetMapping("/all")
    public List<BahanAjar> getAllBahanAjar() {
        return bahanAjarService.getAllBahanAjar();
    }

    @GetMapping("/{id}")
    public BahanAjar getBahanAjarById(@PathVariable("id") int id) {
        return bahanAjarService.getBahanAjarById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBahanAjar(@PathVariable("id") int id, @RequestBody BahanAjar updatedBahanAjar) {
        return bahanAjarService.updateBahanAjar(id, updatedBahanAjar);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBahanAjar(@PathVariable("id") int id) {
        return bahanAjarService.deleteBahanAjar(id);
    }
}
