package com.uas.sekolah.controller;

import com.uas.sekolah.entity.BahanAjar;
import com.uas.sekolah.service.BahanAjarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bahan-ajar")
public class BahanAjarController {

    @Autowired
    private BahanAjarService bahanAjarService;

    @PostMapping("/create")
    public ResponseEntity<String> simpanBahanAjar(
            @RequestParam("judul") String judul,
            @RequestParam("deskripsi") String deskripsi,
            @RequestParam("tipe") String tipe,
            @RequestParam("id_mapel") int idMapel,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        try {
            BahanAjar bahanAjar = new BahanAjar();
            bahanAjar.setJudul(judul);
            bahanAjar.setDeskripsi(deskripsi);
            bahanAjar.setTipe(tipe);
            bahanAjar.setMataPelajaran(bahanAjarService.getMataPelajaranById(idMapel));

            if (file != null && !file.isEmpty()) {
                bahanAjar.setFileType("PDF"); // Assuming PDF as the file type
                bahanAjar.setFile(file.getBytes()); // Save file contents or its metadata
            }

            return bahanAjarService.simpanBahanAjar(bahanAjar, file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Bahan Ajar: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<BahanAjar> lihatBahanAjar() {
        return bahanAjarService.lihatBahanAjar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BahanAjar> getBahanAjarById(@PathVariable("id") int id) {
        BahanAjar bahanAjar = bahanAjarService.getBahanAjarById(id);
        return ResponseEntity.ok().body(bahanAjar);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id") int id) {
        try {
            BahanAjar bahanAjar = bahanAjarService.getBahanAjarById(id);
            if (bahanAjar == null || bahanAjar.getFile() == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", bahanAjar.getJudul() + ".pdf");

            return new ResponseEntity<>(bahanAjar.getFile(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> ubahBahanAjar(
            @PathVariable("id") int id,
            @RequestParam("judul") String judul,
            @RequestParam("deskripsi") String deskripsi,
            @RequestParam("tipe") String tipe,
            @RequestParam("id_mapel") int idMapel,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        try {
            BahanAjar updatedBahanAjar = new BahanAjar();
            updatedBahanAjar.setJudul(judul);
            updatedBahanAjar.setDeskripsi(deskripsi);
            updatedBahanAjar.setTipe(tipe);
            updatedBahanAjar.setMataPelajaran(bahanAjarService.getMataPelajaranById(idMapel));

            if (file != null && !file.isEmpty()) {
                updatedBahanAjar.setFileType("PDF"); // Assuming PDF as the file type
                updatedBahanAjar.setFile(file.getBytes()); // Update file contents or its metadata
            }

            return bahanAjarService.ubahBahanAjar(id, updatedBahanAjar, file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating Bahan Ajar: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> hapusBahanAjar(@PathVariable("id") int id) {
        try {
            return bahanAjarService.hapusBahanAjar(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Bahan Ajar: " + e.getMessage());
        }
    }
}
