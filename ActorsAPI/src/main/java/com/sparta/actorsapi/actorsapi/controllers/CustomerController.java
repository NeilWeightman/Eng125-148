package com.sparta.actorsapi.actorsapi.controllers;

import com.sparta.actorsapi.actorsapi.dataobcjects.Customer;
import com.sparta.actorsapi.actorsapi.services.SakilaCustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    SakilaCustomerDAO dao;


    @GetMapping("/customer/{id}")
    public Customer customerDetails(@PathVariable int id){
        return dao.getCustomer(id);
    }

    @GetMapping("/customersAll")
    public List<Customer> getAllCustomers(){
        return dao.getAllCustomers();
    }
}
