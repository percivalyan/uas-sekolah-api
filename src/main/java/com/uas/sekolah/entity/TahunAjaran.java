package com.uas.sekolah.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tahun_ajaran")
public class TahunAjaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tahun", nullable = false)
    private String tahun;

    @Column(name = "periode", nullable = false)
    private int periode;

    @Column(name = "tglMulai", nullable = false)
    private Date tglMulai;

    @Column(name = "tglAkhir", nullable = false)
    private Date tglAkhir;

    @Column(name = "kurikulum", nullable = false)
    private String kurikulum;
}
