package com.example.customers.controller;

import com.example.customers.model.Customer;
import com.example.customers.repository.CustomerRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/customers")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerRepository.findAll();

        if (customers != null) {
            model.addAttribute("customers", customers);
        }

        return "customers";
    }

    @GetMapping(value = "/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());

        return "add";
    }

    @GetMapping(value = "/update/{id}")
    public String updateCustomer(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerRepository.findCustomerById(id);

        if (customer != null) {
            model.addAttribute("customer", customer);
        }

        return "update";
    }

    @PostMapping(value = "/add-customer")
    public String addNewCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }

        try {
            customerRepository.save(customer);
        } catch (ConstraintViolationException ex) {
            System.out.println("Exception: " + ex.getConstraintName());
            return "redirect:/add";
        }
        return "redirect:/customers";
    }

    @PostMapping(value = "/remove-customer")
    public String removeCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "redirect:/customers";
    }

    @PostMapping(value = "/update-customer")
    public String updateCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        boolean exists = customerRepository.existsById(customer.getId());
        if (exists) {
            customerRepository.deleteById(customer.getId());
            customerRepository.save(customer);
        }

        return "redirect:/customers";
    }
}
