// // package com.uas.sekolah.service;

// // import java.util.List;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.HttpStatus;
// // import org.springframework.stereotype.Service;
// // import org.springframework.web.server.ResponseStatusException;

// // import com.uas.sekolah.entity.JadwalPelajaran;
// // import com.uas.sekolah.entity.MataPelajaran;
// // import com.uas.sekolah.repository.JadwalPelajaranRepository;
// // import com.uas.sekolah.repository.MataPelajaranRepository;

// // @Service
// // public class JadwalPelajaranService {

// //     @Autowired
// //     private JadwalPelajaranRepository jadwalPelajaranRepository;

// //     @Autowired
// //     private MataPelajaranRepository mataPelajaranRepository;

// //     public JadwalPelajaran simpanJadwalPelajaran(JadwalPelajaran jadwalPelajaran) {
// //         List<MataPelajaran> mataPelajaranList = jadwalPelajaran.getMataPelajaran();
// //         for (MataPelajaran mataPelajaran : mataPelajaranList) {
// //             if (!mataPelajaranRepository.existsById(mataPelajaran.getId())) {
// //                 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran with id " + mataPelajaran.getId() + " not found");
// //             }
// //         }
// //         return jadwalPelajaranRepository.save(jadwalPelajaran);
// //     }

// //     public List<JadwalPelajaran> lihatJadwalPelajaran() {
// //         return jadwalPelajaranRepository.findAll();
// //     }

// //     public JadwalPelajaran getJadwalPelajaranById(int id) {
// //         return jadwalPelajaranRepository.findById(id)
// //                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));
// //     }

// //     public JadwalPelajaran ubahJadwalPelajaran(JadwalPelajaran jadwalPelajaran) {
// //         JadwalPelajaran existingJadwal = jadwalPelajaranRepository.findById(jadwalPelajaran.getId())
// //                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));

// //         // Update fields
// //         existingJadwal.setIdSiswa(jadwalPelajaran.getIdSiswa());
// //         existingJadwal.setMataPelajaran(jadwalPelajaran.getMataPelajaran());
// //         existingJadwal.setIdGuru(jadwalPelajaran.getIdGuru());
// //         existingJadwal.setIdKelas(jadwalPelajaran.getIdKelas());
// //         existingJadwal.setHari(jadwalPelajaran.getHari());
// //         existingJadwal.setJamMulai(jadwalPelajaran.getJamMulai());
// //         existingJadwal.setJamSelesai(jadwalPelajaran.getJamSelesai());

// //         return jadwalPelajaranRepository.save(existingJadwal);
// //     }

// //     public String hapusJadwalPelajaran(int id) {
// //         JadwalPelajaran jadwalPelajaran = jadwalPelajaranRepository.findById(id)
// //                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));
// //         jadwalPelajaranRepository.delete(jadwalPelajaran);

// //         return "Jadwal Pelajaran removed: " + id;
// //     }

// //     public MataPelajaran saveMataPelajaran(MataPelajaran mataPelajaran) {
// //         return mataPelajaranRepository.save(mataPelajaran);
// //     }

// //     public List<MataPelajaran> getAllMataPelajaran() {
// //         return mataPelajaranRepository.findAll();
// //     }

// //     public MataPelajaran getMataPelajaranById(int id) {
// //         return mataPelajaranRepository.findById(id)
// //                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
// //     }

// //     public MataPelajaran updateMataPelajaran(MataPelajaran mataPelajaran) {
// //         MataPelajaran existingMataPelajaran = mataPelajaranRepository.findById(mataPelajaran.getId())
// //                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));

// //         // Update fields
// //         existingMataPelajaran.setKodeMapel(mataPelajaran.getKodeMapel());
// //         existingMataPelajaran.setNamaMapel(mataPelajaran.getNamaMapel());
// //         existingMataPelajaran.setTingkat(mataPelajaran.getTingkat());

// //         return mataPelajaranRepository.save(existingMataPelajaran);
// //     }

// //     public String deleteMataPelajaran(int id) {
// //         MataPelajaran mataPelajaran = mataPelajaranRepository.findById(id)
// //                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
// //         mataPelajaranRepository.delete(mataPelajaran);

// //         return "Mata Pelajaran removed: " + id;
// //     }
// // }


// package com.uas.sekolah.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;

// import com.uas.sekolah.entity.JadwalPelajaran;
// import com.uas.sekolah.entity.MataPelajaran;
// import com.uas.sekolah.repository.JadwalPelajaranRepository;
// import com.uas.sekolah.repository.MataPelajaranRepository;

// @Service
// public class JadwalPelajaranService {

//     @Autowired
//     private JadwalPelajaranRepository jadwalPelajaranRepository;

//     @Autowired
//     private MataPelajaranRepository mataPelajaranRepository;

//     @Autowired
//     private SiswaService siswaService;

//     public JadwalPelajaran simpanJadwalPelajaran(JadwalPelajaran jadwalPelajaran) {
//         List<MataPelajaran> mataPelajaranList = jadwalPelajaran.getMataPelajaran();
//         for (MataPelajaran mataPelajaran : mataPelajaranList) {
//             if (!mataPelajaranRepository.existsById(mataPelajaran.getId())) {
//                 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran with id " + mataPelajaran.getId() + " not found");
//             }
//         }
//         return jadwalPelajaranRepository.save(jadwalPelajaran);
//     }

//     public List<JadwalPelajaran> lihatJadwalPelajaran() {
//         return jadwalPelajaranRepository.findAll();
//     }

//     public JadwalPelajaran getJadwalPelajaranById(int id) {
//         return jadwalPelajaranRepository.findById(id)
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));
//     }

//     public JadwalPelajaran ubahJadwalPelajaran(JadwalPelajaran jadwalPelajaran) {
//         JadwalPelajaran existingJadwal = jadwalPelajaranRepository.findById(jadwalPelajaran.getId())
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));

//         // Update fields
//         existingJadwal.setSiswa(jadwalPelajaran.getSiswa());
//         existingJadwal.setMataPelajaran(jadwalPelajaran.getMataPelajaran());
//         existingJadwal.setIdGuru(jadwalPelajaran.getIdGuru());
//         existingJadwal.setIdKelas(jadwalPelajaran.getIdKelas());
//         existingJadwal.setHari(jadwalPelajaran.getHari());
//         existingJadwal.setJamMulai(jadwalPelajaran.getJamMulai());
//         existingJadwal.setJamSelesai(jadwalPelajaran.getJamSelesai());

//         return jadwalPelajaranRepository.save(existingJadwal);
//     }

//     public String hapusJadwalPelajaran(int id) {
//         JadwalPelajaran jadwalPelajaran = jadwalPelajaranRepository.findById(id)
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jadwal Pelajaran not found"));
//         jadwalPelajaranRepository.delete(jadwalPelajaran);

//         return "Jadwal Pelajaran removed: " + id;
//     }

//     public MataPelajaran simpanMataPelajaran(MataPelajaran mataPelajaran) {
//         return mataPelajaranRepository.save(mataPelajaran);
//     }

//     public List<MataPelajaran> lihatSemuaMataPelajaran() {
//         return mataPelajaranRepository.findAll();
//     }

//     public MataPelajaran getMataPelajaranById(int id) {
//         return mataPelajaranRepository.findById(id)
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
//     }

//     public MataPelajaran ubahMataPelajaran(MataPelajaran mataPelajaran) {
//         MataPelajaran existingMataPelajaran = mataPelajaranRepository.findById(mataPelajaran.getId())
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));

//         // Update fields
//         existingMataPelajaran.setKodeMapel(mataPelajaran.getKodeMapel());
//         existingMataPelajaran.setNamaMapel(mataPelajaran.getNamaMapel());
//         existingMataPelajaran.setTingkat(mataPelajaran.getTingkat());

//         return mataPelajaranRepository.save(existingMataPelajaran);
//     }

//     public String hapusMataPelajaran(int id) {
//         MataPelajaran mataPelajaran = mataPelajaranRepository.findById(id)
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mata Pelajaran not found"));
//         mataPelajaranRepository.delete(mataPelajaran);

//         return "Mata Pelajaran removed: " + id;
//     }
// }

package com.uas.sekolah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uas.sekolah.entity.JadwalPelajaran;
import com.uas.sekolah.entity.MataPelajaran;    
import com.uas.sekolah.repository.JadwalPelajaranRepository;
import com.uas.sekolah.repository.MataPelajaranRepository;

import java.util.List;

@Service
@Transactional
public class JadwalPelajaranService {

    private final JadwalPelajaranRepository jadwalPelajaranRepository;
    private final MataPelajaranRepository mataPelajaranRepository;

    @Autowired
    public JadwalPelajaranService(JadwalPelajaranRepository jadwalPelajaranRepository, MataPelajaranRepository mataPelajaranRepository) {
        this.jadwalPelajaranRepository = jadwalPelajaranRepository;
        this.mataPelajaranRepository = mataPelajaranRepository;
    }

    // Simpan jadwal pelajaran
    public JadwalPelajaran simpanJadwalPelajaran(JadwalPelajaran jadwalPelajaran) {
        return jadwalPelajaranRepository.save(jadwalPelajaran);
    }

    // Lihat semua jadwal pelajaran
    public List<JadwalPelajaran> lihatSemuaJadwalPelajaran() {
        return jadwalPelajaranRepository.findAll();
    }

    // Lihat jadwal pelajaran berdasarkan ID
    public JadwalPelajaran lihatJadwalPelajaranById(int id) {
        return jadwalPelajaranRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Jadwal pelajaran dengan ID " + id + " tidak ditemukan"));
    }

    // Hapus jadwal pelajaran berdasarkan ID
    public void hapusJadwalPelajaran(int id) {
        jadwalPelajaranRepository.deleteById(id);
    }

    // Tambahkan mata pelajaran ke jadwal pelajaran
    public JadwalPelajaran tambahkanMataPelajaranKeJadwalPelajaran(int jadwalPelajaranId, int mataPelajaranId) {
        JadwalPelajaran jadwalPelajaran = lihatJadwalPelajaranById(jadwalPelajaranId);
        MataPelajaran mataPelajaran = mataPelajaranRepository.findById(mataPelajaranId)
                .orElseThrow(() -> new IllegalArgumentException("Mata pelajaran dengan ID " + mataPelajaranId + " tidak ditemukan"));
        jadwalPelajaran.getMataPelajaran().add(mataPelajaran);
        return jadwalPelajaranRepository.save(jadwalPelajaran);
    }

    // Hapus mata pelajaran dari jadwal pelajaran
    public JadwalPelajaran hapusMataPelajaranDariJadwalPelajaran(int jadwalPelajaranId, int mataPelajaranId) {
        JadwalPelajaran jadwalPelajaran = lihatJadwalPelajaranById(jadwalPelajaranId);
        MataPelajaran mataPelajaran = mataPelajaranRepository.findById(mataPelajaranId)
                .orElseThrow(() -> new IllegalArgumentException("Mata pelajaran dengan ID " + mataPelajaranId + " tidak ditemukan"));
        jadwalPelajaran.getMataPelajaran().remove(mataPelajaran);
        return jadwalPelajaranRepository.save(jadwalPelajaran);
    }
}
