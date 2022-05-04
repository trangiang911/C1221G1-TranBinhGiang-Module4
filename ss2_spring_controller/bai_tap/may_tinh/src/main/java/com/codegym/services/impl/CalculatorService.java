package com.codegym.services.impl;

import com.codegym.services.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(String number1, String number2, char op) {

        switch (op){
            case '+':
                if(number1.equals("") || number2.equals("")){
                    return "Ko đc để trống";
                }else {
                    return Integer.toString(Integer.parseInt(number1)+Integer.parseInt(number2));
                }
            case '-':
                if(number1.equals("") || number2.equals("")){
                    return "Ko đc để trống";
                }else {
                    return Integer.toString(Integer.parseInt(number1)-Integer.parseInt(number2));
                }
            case '*':
                if(number1.equals("") || number2.equals("")){
                    return "Ko đc để trống";
                }else {
                    return Integer.toString(Integer.parseInt(number1)*Integer.parseInt(number2));
                }
            case '/':
                if (number1.equals("") || number2.equals("")){
                    return "Ko đc để trống";
                }
                else if(Integer.parseInt(number2)==0){
                    return "Ko đc mẫu bằng 0";
                }else {
                    return Integer.toString(Integer.parseInt(number1)/Integer.parseInt(number2));
                }
            default:
                return "Sai rồi đó";
        }
    }
}
