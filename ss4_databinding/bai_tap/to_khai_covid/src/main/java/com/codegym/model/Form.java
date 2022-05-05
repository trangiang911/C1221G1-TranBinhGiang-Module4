package com.codegym.model;

public class Form {
    private String name;
    private String year;
    private String gender;
    private String nation;
    private String cmnd;
    private String diChuyen;
    private String bienSo;
    private String soGhe;
    private String ngayKhoiHanh;
    private String ngayKetThuc;

    public Form(String name, String year, String gender, String nation, String cmnd, String diChuyen, String bienSo, String soGhe, String ngayKhoiHanh, String ngayKetThuc) {
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.nation = nation;
        this.cmnd = cmnd;
        this.diChuyen = diChuyen;
        this.bienSo = bienSo;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
    }

    public Form() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiChuyen() {
        return diChuyen;
    }

    public void setDiChuyen(String diChuyen) {
        this.diChuyen = diChuyen;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
