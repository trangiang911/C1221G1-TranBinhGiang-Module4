package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "loai_xe")
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoaiXe;
    private String loaiXe;

    @ManyToOne
    @JoinColumn(name = "id_ben_xe", referencedColumnName = "idBenXe")
    private BenXe benXe;

    public LoaiXe() {
    }

    public Integer getIdLoaiXe() {
        return idLoaiXe;
    }

    public void setIdLoaiXe(Integer idLoaiXe) {
        this.idLoaiXe = idLoaiXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public BenXe getBenXe() {
        return benXe;
    }

    public void setBenXe(BenXe benXe) {
        this.benXe = benXe;
    }
}

