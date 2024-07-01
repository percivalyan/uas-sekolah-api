package com.uas.sekolah.entity;

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
@Table(name = "silabus")
@Data
public class Silabus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_mapel", referencedColumnName = "id")
    private MataPelajaran mataPelajaran;

    @Column(name = "judul")
    private String judul;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "tujuan")
    private String tujuan;

    @Column(name = "materi")
    private String materi;

    @Column(name = "metode")
    private String metode;

    @Column(name = "evaluasi")
    private String evaluasi;

    // Add getters and setters as needed
}
