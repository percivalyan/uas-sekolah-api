package com.uas.sekolah.controller;

import com.uas.sekolah.entity.JadwalPelajaran;
import com.uas.sekolah.entity.MataPelajaran;
import com.uas.sekolah.service.JadwalPelajaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class JadwalPelajaranController {

    @Autowired
    private JadwalPelajaranService jadwalPelajaranService;

    @GetMapping("/jadwal-pelajaran")
    public ResponseEntity<List<JadwalPelajaran>> getAllJadwalPelajaran() {
        List<JadwalPelajaran> jadwalPelajaranList = jadwalPelajaranService.lihatJadwalPelajaran();
        return new ResponseEntity<>(jadwalPelajaranList, HttpStatus.OK);
    }

    @GetMapping("/jadwal-pelajaran/{id}")
    public ResponseEntity<JadwalPelajaran> getJadwalPelajaranById(@PathVariable("id") int id) {
        JadwalPelajaran jadwalPelajaran = jadwalPelajaranService.getJadwalPelajaranById(id);
        return new ResponseEntity<>(jadwalPelajaran, HttpStatus.OK);
    }

    @PostMapping("/jadwal-pelajaran")
    public ResponseEntity<JadwalPelajaran> saveJadwalPelajaran(@RequestBody JadwalPelajaran jadwalPelajaran) {
        JadwalPelajaran savedJadwalPelajaran = jadwalPelajaranService.simpanJadwalPelajaran(jadwalPelajaran);
        return new ResponseEntity<>(savedJadwalPelajaran, HttpStatus.CREATED);
    }

    @PutMapping("/jadwal-pelajaran/{id}")
    public ResponseEntity<JadwalPelajaran> updateJadwalPelajaran(@PathVariable("id") int id, @RequestBody JadwalPelajaran jadwalPelajaran) {
        jadwalPelajaran.setId(id);
        JadwalPelajaran updatedJadwalPelajaran = jadwalPelajaranService.ubahJadwalPelajaran(jadwalPelajaran);
        return new ResponseEntity<>(updatedJadwalPelajaran, HttpStatus.OK);
    }

    @DeleteMapping("/jadwal-pelajaran/{id}")
    public ResponseEntity<String> deleteJadwalPelajaran(@PathVariable("id") int id) {
        String message = jadwalPelajaranService.hapusJadwalPelajaran(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}