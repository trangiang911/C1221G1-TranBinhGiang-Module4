package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static Integer idtemp;
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Sữa", "50000", "sữa", "vinamilk"));
        productList.add(new Product(2, "Kẹo", "50000", "Kẹo", "vinamilk"));
        productList.add(new Product(3, "Bánh", "50000", "Bánh", "vinamilk"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        idtemp = (productList.get(productList.size() - 1).getId()) + 1;
        product.setId(idtemp++);
        productList.add(product);
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.remove(i);
            }
        }
    }

    @Override
    public Product findById(Integer id) {
        Product product=new Product();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId().equals(id)){
                product=productList.get(i);
            }
        }
        return product;
    }

    @Override
    public void update(Integer id, Product product) {
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId().equals(id)){
                productList.get(i).setName(product.getName());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setSummary(product.getSummary());
                productList.get(i).setProducer(product.getProducer());
            }
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList1=new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().toLowerCase().contains(name)){
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }
}
