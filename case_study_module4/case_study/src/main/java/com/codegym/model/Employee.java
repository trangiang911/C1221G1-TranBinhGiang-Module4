package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;
    @Column(columnDefinition = "DATE")
    private String employeeBirthday;
    private String employeeIdCard;
    private String employeeSlary;
    private String employPhone;
    private String employEmail;
    private String employeeAddress;

}
