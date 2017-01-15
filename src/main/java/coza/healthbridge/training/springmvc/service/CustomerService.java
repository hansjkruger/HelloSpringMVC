package coza.healthbridge.training.springmvc.service;

import coza.healthbridge.training.springmvc.domain.Customer;

import java.util.List;

/**
 * Created by hans.kruger on 2017/01/14.
 */
public interface CustomerService {
    List <Customer> getCustomers();
    Customer getCustomer(Integer id);
    Customer createCustomer();
    Customer saveCustomer(Customer customer);
    void removeCustomer(Integer id);
}
