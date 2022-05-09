package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery=BaseRepository.entityManager.createQuery("select p from Product p",Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction=
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction entityTransaction=
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(this.findById(id));
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }

    @Override
    public void update(Integer id, Product product) {
        EntityTransaction entityTransaction=
                BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

//    @Override
//    public List<Product> search(String name) {
//        List<Product> productList1=new ArrayList<>();
//        for (int i = 0; i < productList.size(); i++) {
//            if(productList.get(i).getName().toLowerCase().contains(name)){
//                productList1.add(productList.get(i));
//            }
//        }
//        return productList1;
//    }
}
