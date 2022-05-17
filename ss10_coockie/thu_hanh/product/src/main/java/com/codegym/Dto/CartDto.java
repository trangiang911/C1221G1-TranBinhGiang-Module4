package com.codegym.Dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> productMap=new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto){
        if(productMap.containsKey(productDto)){
            Integer count=productMap.get(productDto);
            productMap.put(productDto,count+1);
        }else {
            productMap.put(productDto,1);
        }
    }
}
