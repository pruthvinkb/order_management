package com.shop.orderSystem.controller;

import com.shop.orderSystem.model.Customer;
import com.shop.orderSystem.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*; 

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private customerRepository customerRepository;
     // CREATE (Save data)
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // READ (Get all data)
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @PutMapping("/{id}")
   public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer){  
       Optional<Customer> exstingCustomer=customerRepository.findById(id);
       if(exstingCustomer.isPresent()){
            Customer oldCustomer=exstingCustomer.get();
            oldCustomer.setName(customer.getName());
            oldCustomer.setPhone(customer.getPhone());
            oldCustomer.setAddress(customer.getAddress());
            return customerRepository.save(oldCustomer);
       }else{
             return null;
       }
    } 
   @DeleteMapping("/{id}")
      public String deleteCustomer(@PathVariable int id){
        Optional<Customer> exist=
                customerRepository.findById(id);
                if(exist.isPresent()){
                customerRepository.deleteById(id);
                return "Customer removed!!";
                }
                else{
                    return "customer not found";
                }
      }

}
