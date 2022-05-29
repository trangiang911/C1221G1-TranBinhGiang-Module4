package com.codegym.repository;

import com.codegym.dto.CustomerHaveBooking;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where customer_name like :nameVal and customer_address like :addressBy and customer_type_id like :typeBy",
            countQuery = "select * from customer where customer_name like :nameVal and customer_address like :addressBy and customer_type_id like :typeBy", nativeQuery = true)
    Page<Customer> findAndSearch(String nameVal, String addressBy, String typeBy, Pageable pageable);

//    @Query(value = "select customer_name as nameCustomer,contract_end_date as endDate,contract_start_date as startDate,group_concat(attach_service_name) as nameServiceInclude,facility_name as nameFacility,sum(faciliti.facility_cost+(contract_detail.quantity * attach_service.attach_service_cost)) as total from customer join contract on ustomer.customer_id = contract.customer_id join contract_detail on contract.customer_id = contract_detail.contract_id join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id\n" +
//            "         join facility on facility.facility_id = contract.facility_id group by contract.facility_id",
//    countQuery="select customer_name as nameCustomer,contract_end_date as endDate,contract_start_date as startDate,group_concat(attach_service_name) as nameServiceInclude,facility_name as nameFacility,sum(faciliti.facility_cost+(contract_detail.quantity * attach_service.attach_service_cost)) as total from customer join contract on ustomer.customer_id = contract.customer_id join contract_detail on contract.customer_id = contract_detail.contract_id join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id\n" +
//            "         join facility on facility.facility_id = contract.facility_id group by contract.facility_id",nativeQuery=true)
    @Query(value="select customer_name as nameCustomer,\n" +
            "       contract_end_date as endDate,\n" +
            "       facility_name as nameFacility,\n" +
            "       contract_start_date as startDate,\n" +
            "       group_concat(attach_service_name) as nameServiceInclude,\n" +
            "       sum(facility.facility_cost + (contract_detail.quantity * attach_service.attach_service_cost)) as total\n" +
            "from customer\n" +
            "         join contract on customer.customer_id = contract.customer_id\n" +
            "         join contract_detail on contract.customer_id = contract_detail.contract_id\n" +
            "         join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id\n" +
            "         join facility on facility.facility_id = contract.facility_id\n" +
            "group by contract.facility_id",
    countQuery="select customer_name as nameCustomer,\n" +
            "       contract_end_date as endDate,\n" +
            "       facility_name as nameFacility,\n" +
            "       contract_start_date as startDate,\n" +
            "       group_concat(attach_service_name) as nameServiceInclude,\n" +
            "       sum(facility.facility_cost + (contract_detail.quantity * attach_service.attach_service_cost)) as total\n" +
            "from customer\n" +
            "         join contract on customer.customer_id = contract.customer_id\n" +
            "         join contract_detail on contract.customer_id = contract_detail.contract_id\n" +
            "         join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id\n" +
            "         join facility on facility.facility_id = contract.facility_id\n" +
            "group by contract.facility_id",nativeQuery=true)
    Page<CustomerHaveBooking> findAllCustomerHaveBooking(Pageable pageable);
}
