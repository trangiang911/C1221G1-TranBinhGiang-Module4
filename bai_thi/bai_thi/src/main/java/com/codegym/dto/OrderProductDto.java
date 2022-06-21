package com.codegym.dto;

import com.codegym.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class OrderProductDto implements Validator {
    private Integer orderProductId;
    private String dateBuy;
    @NotBlank(message = "Ko đc để trống")
    private String amount;
    private Product product;

    public OrderProductDto() {
    }

    public Integer getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(String dateBuy) {
        this.dateBuy = dateBuy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderProductDto orderProductDto = (OrderProductDto) target;
        if (!orderProductDto.getDateBuy().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            errors.rejectValue("dateBuy", "date.null");
        }
        if (orderProductDto.getDateBuy().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            if (LocalDate.parse(orderProductDto.getDateBuy()).isBefore(LocalDate.now())) {
                errors.rejectValue("dateBuy", "date.valid");
            }
        }
        if (!orderProductDto.getAmount().equals("")) {
            if (!orderProductDto.getAmount().matches("^[+]?\\d+")) {
                errors.rejectValue("amount", "amount.valid");
            }
        }
    }
}
