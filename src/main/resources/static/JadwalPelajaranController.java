// // package com.uas.sekolah.controller;

// // import com.uas.sekolah.entity.JadwalPelajaran;
// // import com.uas.sekolah.entity.MataPelajaran;
// // import com.uas.sekolah.service.JadwalPelajaranService;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.HttpStatus;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @CrossOrigin("*")
// // @RequestMapping("/api")
// // public class JadwalPelajaranController {

// //     @Autowired
// //     private JadwalPelajaranService jadwalPelajaranService;

// //     @GetMapping("/jadwal-pelajaran")
// //     public ResponseEntity<List<JadwalPelajaran>> getAllJadwalPelajaran() {
// //         List<JadwalPelajaran> jadwalPelajaranList = jadwalPelajaranService.lihatJadwalPelajaran();
// //         return new ResponseEntity<>(jadwalPelajaranList, HttpStatus.OK);
// //     }

// //     @GetMapping("/jadwal-pelajaran/{id}")
// //     public ResponseEntity<JadwalPelajaran> getJadwalPelajaranById(@PathVariable("id") int id) {
// //         JadwalPelajaran jadwalPelajaran = jadwalPelajaranService.getJadwalPelajaranById(id);
// //         return new ResponseEntity<>(jadwalPelajaran, HttpStatus.OK);
// //     }

// //     @PostMapping("/jadwal-pelajaran")
// //     public ResponseEntity<JadwalPelajaran> saveJadwalPelajaran(@RequestBody JadwalPelajaran jadwalPelajaran) {
// //         JadwalPelajaran savedJadwalPelajaran = jadwalPelajaranService.simpanJadwalPelajaran(jadwalPelajaran);
// //         return new ResponseEntity<>(savedJadwalPelajaran, HttpStatus.CREATED);
// //     }

// //     @PutMapping("/jadwal-pelajaran/{id}")
// //     public ResponseEntity<JadwalPelajaran> updateJadwalPelajaran(@PathVariable("id") int id, @RequestBody JadwalPelajaran jadwalPelajaran) {
// //         jadwalPelajaran.setId(id);
// //         JadwalPelajaran updatedJadwalPelajaran = jadwalPelajaranService.ubahJadwalPelajaran(jadwalPelajaran);
// //         return new ResponseEntity<>(updatedJadwalPelajaran, HttpStatus.OK);
// //     }

// //     @DeleteMapping("/jadwal-pelajaran/{id}")
// //     public ResponseEntity<String> deleteJadwalPelajaran(@PathVariable("id") int id) {
// //         String message = jadwalPelajaranService.hapusJadwalPelajaran(id);
// //         return new ResponseEntity<>(message, HttpStatus.OK);
// //     }
// // }

// package com.uas.sekolah.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.uas.sekolah.entity.JadwalPelajaran;
// import com.uas.sekolah.service.JadwalPelajaranService;

// @RestController
// @CrossOrigin("*")
// @RequestMapping("/api/jadwal-pelajaran")
// public class JadwalPelajaranController {

//     private final JadwalPelajaranService jadwalPelajaranService;

//     @Autowired
//     public JadwalPelajaranController(JadwalPelajaranService jadwalPelajaranService) {
//         this.jadwalPelajaranService = jadwalPelajaranService;
//     }

//     @GetMapping
//     public ResponseEntity<List<JadwalPelajaran>> lihatSemuaJadwalPelajaran() {
//         List<JadwalPelajaran> jadwalPelajaranList = jadwalPelajaranService.lihatJadwalPelajaran();
//         return new ResponseEntity<>(jadwalPelajaranList, HttpStatus.OK);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<JadwalPelajaran> lihatJadwalPelajaranById(@PathVariable("id") int id) {
//         JadwalPelajaran jadwalPelajaran = jadwalPelajaranService.getJadwalPelajaranById(id);
//         return new ResponseEntity<>(jadwalPelajaran, HttpStatus.OK);
//     }

//     @PostMapping
//     public ResponseEntity<JadwalPelajaran> simpanJadwalPelajaran(@RequestBody JadwalPelajaran jadwalPelajaran) {
//         JadwalPelajaran savedJadwalPelajaran = jadwalPelajaranService.simpanJadwalPelajaran(jadwalPelajaran);
//         return new ResponseEntity<>(savedJadwalPelajaran, HttpStatus.CREATED);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<JadwalPelajaran> ubahJadwalPelajaran(@PathVariable("id") int id, @RequestBody JadwalPelajaran jadwalPelajaran) {
//         jadwalPelajaran.setId(id); // Pastikan ID sesuai dengan path variable
//         JadwalPelajaran updatedJadwalPelajaran = jadwalPelajaranService.ubahJadwalPelajaran(jadwalPelajaran);
//         return new ResponseEntity<>(updatedJadwalPelajaran, HttpStatus.OK);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<String> hapusJadwalPelajaran(@PathVariable("id") int id) {
//         String message = jadwalPelajaranService.hapusJadwalPelajaran(id);
//         return new ResponseEntity<>(message, HttpStatus.OK);
//     }
// }

package com.uas.sekolah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uas.sekolah.entity.JadwalPelajaran;
import com.uas.sekolah.entity.MataPelajaran;    
import com.uas.sekolah.repository.JadwalPelajaranRepository;
import com.uas.sekolah.repository.MataPelajaranRepository;
import com.uas.sekolah.service.JadwalPelajaranService;  

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/jadwal-pelajaran")
public class JadwalPelajaranController {

    private final JadwalPelajaranService jadwalPelajaranService;

    @Autowired
    public JadwalPelajaranController(JadwalPelajaranService jadwalPelajaranService) {
        this.jadwalPelajaranService = jadwalPelajaranService;
    }

    // Endpoint untuk menyimpan jadwal pelajaran
    @PostMapping
    public ResponseEntity<JadwalPelajaran> simpanJadwalPelajaran(@RequestBody JadwalPelajaran jadwalPelajaran) {
        JadwalPelajaran savedJadwalPelajaran = jadwalPelajaranService.simpanJadwalPelajaran(jadwalPelajaran);
        return new ResponseEntity<>(savedJadwalPelajaran, HttpStatus.CREATED);
    }

    // Endpoint untuk mengambil semua jadwal pelajaran
    @GetMapping
    public ResponseEntity<List<JadwalPelajaran>> lihatSemuaJadwalPelajaran() {
        List<JadwalPelajaran> jadwalPelajaranList = jadwalPelajaranService.lihatSemuaJadwalPelajaran();
        return new ResponseEntity<>(jadwalPelajaranList, HttpStatus.OK);
    }

    // Endpoint untuk mengambil jadwal pelajaran berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<JadwalPelajaran> lihatJadwalPelajaranById(@PathVariable("id") int id) {
        JadwalPelajaran jadwalPelajaran = jadwalPelajaranService.lihatJadwalPelajaranById(id);
        return new ResponseEntity<>(jadwalPelajaran, HttpStatus.OK);
    }

    // Endpoint untuk menghapus jadwal pelajaran berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapusJadwalPelajaran(@PathVariable("id") int id) {
        jadwalPelajaranService.hapusJadwalPelajaran(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint untuk menambahkan mata pelajaran ke jadwal pelajaran berdasarkan ID jadwal pelajaran dan ID mata pelajaran
    @PostMapping("/{jadwalPelajaranId}/mata-pelajaran/{mataPelajaranId}")
    public ResponseEntity<JadwalPelajaran> tambahkanMataPelajaranKeJadwalPelajaran(
            @PathVariable("jadwalPelajaranId") int jadwalPelajaranId,
            @PathVariable("mataPelajaranId") int mataPelajaranId) {
        JadwalPelajaran updatedJadwalPelajaran = jadwalPelajaranService.tambahkanMataPelajaranKeJadwalPelajaran(jadwalPelajaranId, mataPelajaranId);
        return new ResponseEntity<>(updatedJadwalPelajaran, HttpStatus.OK);
    }

    // Endpoint untuk menghapus mata pelajaran dari jadwal pelajaran berdasarkan ID jadwal pelajaran dan ID mata pelajaran
    @DeleteMapping("/{jadwalPelajaranId}/mata-pelajaran/{mataPelajaranId}")
    public ResponseEntity<JadwalPelajaran> hapusMataPelajaranDariJadwalPelajaran(
            @PathVariable("jadwalPelajaranId") int jadwalPelajaranId,
            @PathVariable("mataPelajaranId") int mataPelajaranId) {
        JadwalPelajaran updatedJadwalPelajaran = jadwalPelajaranService.hapusMataPelajaranDariJadwalPelajaran(jadwalPelajaranId, mataPelajaranId);
        return new ResponseEntity<>(updatedJadwalPelajaran, HttpStatus.OK);
    }
}
