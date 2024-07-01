package com.uas.sekolah.controller;

import com.uas.sekolah.entity.Silabus;
import com.uas.sekolah.service.SilabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/silabus")
public class SilabusController {

    private final SilabusService silabusService;

    @Autowired
    public SilabusController(SilabusService silabusService) {
        this.silabusService = silabusService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSilabus(@RequestBody Silabus silabus) {
        try {
            Silabus createdSilabus = silabusService.createSilabus(silabus);
            return ResponseEntity.ok(createdSilabus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create silabus: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSilabus(@PathVariable int id, @RequestBody Silabus updatedSilabus) {
        try {
            Silabus updated = silabusService.updateSilabus(id, updatedSilabus);
            if (updated != null) {
                return ResponseEntity.ok(updated);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Silabus with id " + id + " not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update silabus: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSilabus(@PathVariable int id) {
        try {
            silabusService.deleteSilabus(id);
            return ResponseEntity.ok("Silabus with id " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete silabus: " + e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findSilabusById(@PathVariable int id) {
        try {
            Silabus silabus = silabusService.findSilabusById(id);
            if (silabus != null) {
                return ResponseEntity.ok(silabus);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Silabus with id " + id + " not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve silabus: " + e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllSilabus() {
        try {
            List<Silabus> silabuses = silabusService.findAllSilabus();
            return ResponseEntity.ok(silabuses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve silabuses: " + e.getMessage());
        }
    }
}
