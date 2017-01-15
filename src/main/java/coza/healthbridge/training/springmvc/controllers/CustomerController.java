package coza.healthbridge.training.springmvc.controllers;

import coza.healthbridge.training.springmvc.domain.Customer;
import coza.healthbridge.training.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hans.kruger on 2017/01/14.
 */
@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String showCustomers(Model theModel) {
        theModel.addAttribute("customers", customerService.getCustomers());
        return "showCustomers";
    }

    @RequestMapping("/customer/{id}")
    public String showCustomer(@PathVariable Integer id, Model theModel) {
        System.out.println("+ showCustomer");
        theModel.addAttribute("customer", customerService.getCustomer(id));
        return "showCustomer";
    }

    @RequestMapping("/customer/new")
    public String createCustomer(Model theModel) {
        System.out.println("+ createCustomer");
        theModel.addAttribute("customer", customerService.createCustomer());
        return "customerForm";
    }

    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model theModel) {
        System.out.println("+ editCustomer");
        theModel.addAttribute("customer", customerService.getCustomer(id));
        return "customerForm";
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id, Model theModel) {
        System.out.println("+ deleteCustomer");
        customerService.removeCustomer(id);
        return "redirect:/customers";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveCustomer(Customer customer) {
        System.out.println("+ saveCustomer");
        Customer updatedCustomer = customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

}
