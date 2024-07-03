package com.uas.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "siswa")
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_ta", referencedColumnName = "id")
    private TahunAjaran tahunAjaran;

    @Column(name = "nisn", nullable = false, unique = true)
    private String nisn;

    @Column(name = "nama_lengkap", nullable = false)
    private String nama_lengkap;

    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggal_lahir;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "nama_ortu", nullable = false)
    private String nama_ortu;

    @Column(name = "telp", nullable = false)
    private String telp;

    @Column(name = "foto_name")
    private String fotoName; // Menyimpan nama file gambar

    @Lob
    @Column(name = "foto")
    private byte[] foto; // Menyimpan data gambar dalam bentuk byte array

    @Column(name = "status", nullable = false)
    private boolean status;
}
