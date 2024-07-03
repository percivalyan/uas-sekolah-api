package com.uas.sekolah.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prestasi_akademik")
@Data
public class PrestasiAkademik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_siswa")
    private int idSiswa;

    @ManyToOne
    @JoinColumn(name = "id_mapel", referencedColumnName = "id")
    private MataPelajaran mataPelajaran;

    @Column(name = "date")
    private Date date;

    @Column(name = "jenis_prestasi")
    private String jenisPrestasi;

    @Column(name = "deskripsi_atau_nilai")
    private String deskripsiAtauNilai;
}
