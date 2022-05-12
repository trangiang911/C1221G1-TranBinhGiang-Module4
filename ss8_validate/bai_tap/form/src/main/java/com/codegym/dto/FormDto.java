package com.codegym.dto;

import com.codegym.model.Form;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.Period;

public class FormDto implements Validator {

    private Integer id;
    @NotEmpty(message = "Không đc để trống")
    @Size(min = 5,max = 45,message = "Độ dài từ 5-45")
    @NotBlank(message = "Nhậm chữ vào")
    @Pattern(regexp = "^[a-zA-Z ]+$",message = "Chỉ điền chữ")
    private String firstName;
    @NotEmpty(message = "Không đc để trống")
    @Size(min = 5,max = 45,message = "Độ dài từ 5-45")
    @NotBlank(message = "Nhập chữ vào")
    @Pattern(regexp = "^[a-zA-Z ]+$",message = "Chỉ điền chữ")
    private String lastName;
    @NotEmpty(message = "Không đc để trống")
    @Pattern(regexp = "^0[0-9]{8,9}$")
    private String phone;
    private String dateOfBirth;
    @NotNull(message = "Không đc để trống")
    @Email
    private String email;

    public FormDto() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormDto form=(FormDto) target;
        if("".equals(form.getDateOfBirth())){
            errors.rejectValue("dateOfBirth","date.valid1");
        }else {
            if((Period.between(LocalDate.parse(form.getDateOfBirth()),LocalDate.now()).getYears())<18){
                errors.rejectValue("dateOfBirth","date.valid");
            }
        }
    }
}
