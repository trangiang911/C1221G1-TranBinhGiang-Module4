package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_xe")
public class LoaiXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoaiXe;
    private String loaiXe;
    @JsonBackReference
    @OneToMany(mappedBy = "loaiXe")
    private List<LoaiXe> loaiXeList;

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

    public List<LoaiXe> getLoaiXeList() {
        return loaiXeList;
    }

    public void setLoaiXeList(List<LoaiXe> loaiXeList) {
        this.loaiXeList = loaiXeList;
    }
}

