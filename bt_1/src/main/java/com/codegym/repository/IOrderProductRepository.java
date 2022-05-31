package com.codegym.repository;

import com.codegym.models.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderProductRepository extends JpaRepository<OrderProduct,Integer> {

    Page<OrderProduct> findAllByDateBuyBetween(String dateStartBy,String dateEndBy, Pageable pageable);
    Page<OrderProduct> findAllByDateBuyAfter(String dateStartBy, Pageable pageable);
    Page<OrderProduct> findAllByDateBuyBefore(String dateEndBy, Pageable pageable);

    @Query(value="select order_product_id,amount,date_buy,a.product_id, sum(product_price * amount) as total from order_product a join product b on a.product_id=b.product_id group by order_product_id order by total desc",
    countQuery="select order_product_id ,amount,date_buy ,a.product_id , sum(product_price * amount) as total from order_product a join product b on a.product_id=b.product_id  group by order_product_id order by total desc",nativeQuery=true)
    Page<OrderProduct> findTop(Pageable pageable);
}
