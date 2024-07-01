package com.uas.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
// import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Blob;

@Entity
@Table(name = "bahan_ajar")
@Data
public class BahanAjar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_mapel")
    private MataPelajaran mataPelajaran;

    @Column(name = "judul")
    private String judul;

    @Column(name = "deskripsi")
    private String deskripsi;

    @Column(name = "tipe")
    private String tipe;

    @Column(name = "file")
    private Blob file;

    // Add getters and setters as needed
}
