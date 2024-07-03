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
        TahunAjaran savedTahunAjaran = tahunAjaranService.simpanTA(tahunAjaran);
        return new ResponseEntity<>(savedTahunAjaran, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapusTA(@PathVariable("id") int id) {
        tahunAjaranService.hapusTA(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TahunAjaran> ubahTA(
            @PathVariable("id") int id,
            @RequestBody TahunAjaran tahunAjaranUpdate) {
        TahunAjaran updatedTahunAjaran = tahunAjaranService.ubahTA(id, tahunAjaranUpdate);
        return new ResponseEntity<>(updatedTahunAjaran, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TahunAjaran>> lihatTA() {
        List<TahunAjaran> tahunAjaranList = tahunAjaranService.lihatTA();
        return new ResponseEntity<>(tahunAjaranList, HttpStatus.OK);
    }
}
