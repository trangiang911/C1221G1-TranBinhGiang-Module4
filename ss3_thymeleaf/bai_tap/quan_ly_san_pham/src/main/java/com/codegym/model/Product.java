package com.codegym.model;

import java.util.Objects;

public class Product {
    private Integer id;
    private String name;
    private String price;
    private String summary;
    private String producer;

    public Product(Integer id, String name, String price, String summary, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.summary = summary;
        this.producer = producer;
    }

    public Product(String name, String price, String summary, String producer) {
        this.name = name;
        this.price = price;
        this.summary = summary;
        this.producer = producer;
    }

    public Product() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
