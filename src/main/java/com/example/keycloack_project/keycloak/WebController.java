package com.example.keycloack_project.keycloak;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WebController {

    /*@Autowired
    private CustomerDAO customerDAO;*/

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        addCustomers();
//        Iterable<Customer> customers = customers;
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    // add customers for demonstration
    public void addCustomers() {

        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        customers.add(customer3);
    }
}