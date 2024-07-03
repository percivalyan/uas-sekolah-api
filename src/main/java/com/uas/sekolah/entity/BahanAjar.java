package com.uas.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

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

    @Column(name = "judul", nullable = false)
    private String judul;

    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @Column(name = "tipe", nullable = false)
    private String tipe;

    @Lob // Use @Lob for large objects like byte[]
    @Column(name = "file", columnDefinition = "LONGBLOB")
    private byte[] file;

    @Column(name = "file_type")
    private String fileType;

    // Constructors, getters, and setters
    // Omitted for brevity
}
