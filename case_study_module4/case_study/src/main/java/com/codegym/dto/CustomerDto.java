package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.util.List;

public class CustomerDto implements Validator{

    private Integer customerId;
//    @Pattern(regexp ="^\\p{L}+( (\\p{L})+)*$",message = "Tên phải đúng định dạng (Nguyễn Văn A)")
    private String customerName;
    private String customerBirthday;
    private Integer customerGender;
//    @Pattern(regexp = "^[0-9]{9}$")
    private String customerIdCard;
//    @Pattern(regexp = "^((\\(84\\)\\+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7}$",
//            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;
//    @Email(message = "Email phải đúng định dạng quốc tế")
    private String customerEmail;
    private String customerAddress;
//    @NotNull(message = "yêu cầu chọn loại khách hàng")
    private CustomerType customerType;
    private List<Contract> contracts;
    private List<Customer> customers;
    public CustomerDto() {
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto=(CustomerDto) target;
        for (int i = 0; i < customerDto.getCustomers().size() ; i++) {
            if(customerDto.getCustomerEmail().equals(customerDto.getCustomers().get(i).getCustomerEmail())){
                errors.rejectValue("customerEmail","email.loop");
                break;
            }
        }
    }
}
