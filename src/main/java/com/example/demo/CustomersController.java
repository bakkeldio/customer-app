package com.example.demo;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")

public class CustomersController {



    @Autowired
     CustomersRepository customerRepository;



    @GetMapping("/")

    public ModelAndView getMainPage(Model model){

        List<Customers> readingList = customerRepository.findAll();

        ModelAndView mav = new ModelAndView("customers");

        mav.addObject("customers", readingList);

        return mav;

    }
    @GetMapping("/add")

    public ModelAndView addCustomer(){

        return new ModelAndView("add");

    }
    @GetMapping("/home")
    public ModelAndView homePage(){
        return new ModelAndView("home");
    }

    @GetMapping("/login")

    public ModelAndView login(){

        return new ModelAndView("login");

    }
    @PostMapping("/add")

    public ModelAndView addCustomerPost(Customers c){

        customerRepository.save(c);

        return new ModelAndView("redirect:/");

    }
}
