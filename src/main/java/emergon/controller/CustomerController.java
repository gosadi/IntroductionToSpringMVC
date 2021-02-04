/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alkinoos
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;
    
    @RequestMapping
    public ModelAndView showCustomers(ModelAndView modelAndView){
        List<Customer> customers = service.getCustomers();
        modelAndView.addObject("listOfCustomers", customers);
        modelAndView.setViewName("customerList");
        return modelAndView;
    }
    
    /**
     * URLs
     * /customer/create : GET (customerList.jsp - link)
     * /customer/create : POST (customerForm.jsp - form)
     * 
     */
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "customerForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Customer customer, Model model){
        service.addCustomer(customer);
        List<Customer> customers = service.getCustomers();
        model.addAttribute("listOfCustomers", customers);
        return "customerList";
    }

}
