// package com.uas.sekolah.controller;

// import com.uas.sekolah.entity.Siswa;
// import com.uas.sekolah.service.SiswaService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @CrossOrigin("*")
// @RequestMapping("/api/siswa")
// public class SiswaController {

//     private final SiswaService siswaService;

//     @Autowired
//     public SiswaController(SiswaService siswaService) {
//         this.siswaService = siswaService;
//     }

//     @PostMapping("/simpan")
//     public ResponseEntity<Siswa> simpanSiswa(@RequestBody Siswa siswa) {
//         Siswa result = siswaService.simpanSiswa(siswa);
//         return ResponseEntity.ok(result);
//     }

//     @PutMapping("/ubah/{id}")
//     public ResponseEntity<Siswa> ubahSiswa(@PathVariable int id, @RequestBody Siswa updatedSiswa) {
//         Siswa result = siswaService.ubahSiswa(id, updatedSiswa);
//         if (result != null) {
//             return ResponseEntity.ok(result);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/hapus/{id}")
//     public ResponseEntity<Void> hapusSiswa(@PathVariable int id) {
//         siswaService.hapusSiswa(id);
//         return ResponseEntity.noContent().build();
//     }

//     @GetMapping("/detail/{id}")
//     public ResponseEntity<Siswa> detailSiswa(@PathVariable int id) {
//         Siswa siswa = siswaService.findSiswaById(id);
//         if (siswa != null) {
//             return ResponseEntity.ok(siswa);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @GetMapping("/semua")
//     public ResponseEntity<List<Siswa>> semuaSiswa() {
//         List<Siswa> siswaList = siswaService.findAllSiswa();
//         return ResponseEntity.ok(siswaList);
//     }
// }

package com.uas.sekolah.controller;

import com.uas.sekolah.entity.Siswa;
import com.uas.sekolah.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/siswa")
public class SiswaController {

    private final SiswaService siswaService;

    @Autowired
    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @PostMapping
    public ResponseEntity<Siswa> simpanSiswa(@RequestBody Siswa siswa) {
        try {
            Siswa result = siswaService.simpanSiswa(siswa);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            // Log error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Siswa> ubahSiswa(@PathVariable int id, @RequestBody Siswa updatedSiswa) {
        try {
            Siswa result = siswaService.ubahSiswa(id, updatedSiswa);
            if (result != null) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapusSiswa(@PathVariable int id) {
        try {
            siswaService.hapusSiswa(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Log error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Siswa> detailSiswa(@PathVariable int id) {
        try {
            Siswa siswa = siswaService.findSiswaById(id);
            if (siswa != null) {
                return ResponseEntity.ok(siswa);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Siswa>> semuaSiswa() {
        try {
            List<Siswa> siswaList = siswaService.findAllSiswa();
            return ResponseEntity.ok(siswaList);
        } catch (Exception e) {
            // Log error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

