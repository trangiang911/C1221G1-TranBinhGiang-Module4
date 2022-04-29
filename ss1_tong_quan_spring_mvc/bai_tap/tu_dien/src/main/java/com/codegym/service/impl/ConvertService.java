package com.codegym.service.impl;

import com.codegym.service.IConvertService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConvertService implements IConvertService {
   private static Map<String, String> map=new HashMap<>();

static {
    map.put("chicken","Chicken Trình");
    map.put("bull","giảng đầu bò");
    map.put("duck","tao là con bò,");
}
    @Override
    public String convert(String x) {
     String y=map.get(x) ;
     if(y==null){
         return "tao là giảng óc chó, không cần phải tìm !";
     }else {
         return y;
     }
    }}
