package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ben_xe")
public class BenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBenXe;
    private String soXe;
    @JsonBackReference
    @OneToMany(mappedBy = "benXe")
    private List<LoaiXe> loaiXeList;
    private String tenNhaXe;
    private String diemDi;
    private String diemDen;
    private String sdt;
    private String email;
    @Column(columnDefinition = "TIME")
    private String gioDi;
    @Column(columnDefinition = "TIME")
    private String gioDen;

    public BenXe() {
    }

    public Integer getIdBenXe() {
        return idBenXe;
    }

    public void setIdBenXe(Integer idBenXe) {
        this.idBenXe = idBenXe;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    public List<LoaiXe> getLoaiXeList() {
        return loaiXeList;
    }

    public void setLoaiXeList(List<LoaiXe> loaiXeList) {
        this.loaiXeList = loaiXeList;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioDi() {
        return gioDi;
    }

    public void setGioDi(String gioDi) {
        this.gioDi = gioDi;
    }

    public String getGioDen() {
        return gioDen;
    }

    public void setGioDen(String gioDen) {
        this.gioDen = gioDen;
    }
}
