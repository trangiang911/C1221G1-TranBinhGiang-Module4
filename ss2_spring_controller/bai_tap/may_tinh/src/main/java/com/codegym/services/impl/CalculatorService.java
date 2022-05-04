package com.codegym.services.impl;

import com.codegym.services.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(String number1, String number2, char op) {
        switch (op){
            case '+':
                return Integer.toString(Integer.parseInt(number1)+Integer.parseInt(number2));
            case '-':
                return Integer.toString(Integer.parseInt(number1)-Integer.parseInt(number2));
            case '*':
                return Integer.toString(Integer.parseInt(number1)*Integer.parseInt(number2));
            case '/':
                if(Integer.parseInt(number2)==0){
                    return "Ko đc đâu";
                }else {
                    return Integer.toString(Integer.parseInt(number1)/Integer.parseInt(number2));
                }
            default:
                return "Sai rồi đó";
        }
    }
}
