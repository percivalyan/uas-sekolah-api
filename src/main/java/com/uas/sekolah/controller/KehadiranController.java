package com.uas.sekolah.controller;

import com.uas.sekolah.entity.Kehadiran;
import com.uas.sekolah.service.KehadiranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/kehadiran")
public class KehadiranController {

    @Autowired
    private KehadiranService kehadiranService;

    @GetMapping
    public List<Kehadiran> getAllKehadiran() {
        return kehadiranService.getAllKehadiran();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kehadiran> getKehadiranById(@PathVariable int id) {
        Optional<Kehadiran> kehadiran = kehadiranService.getKehadiranById(id);
        return kehadiran.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Kehadiran> createKehadiran(@RequestBody Kehadiran kehadiran, @RequestParam int siswaId) {
        try {
            Kehadiran savedKehadiran = kehadiranService.saveKehadiran(kehadiran, siswaId);
            return ResponseEntity.ok(savedKehadiran);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kehadiran> updateKehadiran(@PathVariable int id, @RequestBody Kehadiran kehadiranDetails) {
        try {
            Kehadiran updatedKehadiran = kehadiranService.updateKehadiran(id, kehadiranDetails);
            return ResponseEntity.ok(updatedKehadiran);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKehadiran(@PathVariable int id) {
        kehadiranService.deleteKehadiran(id);
        return ResponseEntity.noContent().build();
    }
}
