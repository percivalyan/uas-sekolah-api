package com.uas.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mata_pelajaran")
@Data
public class MataPelajaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kode_mapel")
    private String kodeMapel;

    @Column(name = "nama_mapel")
    private String namaMapel;

    @Column(name = "tingkat")
    private String tingkat;

    // Add getters and setters as needed
}
