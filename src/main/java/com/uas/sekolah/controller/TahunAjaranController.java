package com.uas.sekolah.controller;

import com.uas.sekolah.entity.TahunAjaran;
import com.uas.sekolah.service.TahunAjaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tahun-ajaran")
public class TahunAjaranController {

    @Autowired
    private TahunAjaranService tahunAjaranService;

    @PostMapping
    public ResponseEntity<TahunAjaran> simpanTA(@RequestBody TahunAjaran tahunAjaran) {
        try {
            TahunAjaran savedTahunAjaran = tahunAjaranService.simpanTA(tahunAjaran);
            return new ResponseEntity<>(savedTahunAjaran, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapusTA(@PathVariable("id") int id) {
        try {
            tahunAjaranService.hapusTA(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TahunAjaran> ubahTA(
            @PathVariable("id") int id,
            @RequestBody TahunAjaran tahunAjaranUpdate) {
        try {
            TahunAjaran updatedTahunAjaran = tahunAjaranService.ubahTA(id, tahunAjaranUpdate);
            return new ResponseEntity<>(updatedTahunAjaran, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping
    public ResponseEntity<List<TahunAjaran>> lihatTA() {
        try {
            List<TahunAjaran> tahunAjaranList = tahunAjaranService.lihatTA();
            return new ResponseEntity<>(tahunAjaranList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
