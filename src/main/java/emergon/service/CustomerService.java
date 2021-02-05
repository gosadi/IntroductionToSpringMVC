/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Customer;
import emergon.repository.CustomerRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alkinoos
 */
@Transactional
@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;
    
    private List<Customer> customers;

    public List<Customer> getCustomers() {
       List<Customer> customers = customerRepo.findAll();
        return customers;
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepo.delete(Customer.class, id);
    }

    public Customer getCustomerById(int ccode) {
        return customerRepo.find(ccode);
    }

    public Customer updateCustomer(Customer customer) {//customer contains the new data from the form
       return customerRepo.save(customer);
    }
    
    
    
    

}
