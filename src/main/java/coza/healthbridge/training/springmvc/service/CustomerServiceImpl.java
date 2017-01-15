package coza.healthbridge.training.springmvc.service;

import coza.healthbridge.training.springmvc.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by hans.kruger on 2017/01/14.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customerDB;

    public CustomerServiceImpl() {

        loadCustomers();
    }

    private void loadCustomers() {
        customerDB = new HashMap<>();
        customerDB.put(1, new Customer(1, "Hans", "Kruger", "hans.j.kruger@gmail.com", "0828034290", "13 Meerendal", "Ribbok Hoekie", "Centurion", "Gauteng", "0157"));
        customerDB.put(2, new Customer(2, "Anine", "Kruger", "aninekru@gmail.com", "0726859308", "13 Meerendal", "Ribbok Hoekie", "Centurion", "Gauteng", "0157"));
        customerDB.put(3, new Customer(3, "Jana", "Kruger", "", "", "13 Meerendal", "Ribbok Hoekie", "Centurion", "Gauteng", "0157"));
        customerDB.put(4, new Customer(4, "Adelei", "Kruger", "", "", "13 Meerendal", "Ribbok Hoekie", "Centurion", "Gauteng", "0157"));
    }

    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<>(customerDB.values());
    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerDB.get(id);
    }

    @Override
    public Customer createCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setId(generateKey());
        return newCustomer;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerDB.put(customer.getId(), customer);
    }

    @Override
    public void removeCustomer(Integer id) {
        customerDB.remove(id);
    }

    private Integer generateKey() {
        return Collections.max(customerDB.keySet())+1;
    }
}
