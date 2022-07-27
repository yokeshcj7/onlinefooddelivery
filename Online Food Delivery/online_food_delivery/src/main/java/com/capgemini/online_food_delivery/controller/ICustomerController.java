package com.capgemini.online_food_delivery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.online_food_delivery.dto.CustomerDto;
import com.capgemini.online_food_delivery.exception.CustomerNotFoundException;
import com.capgemini.online_food_delivery.service.ICustomerService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/customer")
public class ICustomerController {

    @Autowired
    ICustomerService customerService;
    
    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customer) {
        CustomerDto customer1 = customerService.addCustomer(customer);
        return new ResponseEntity<CustomerDto>(customer1, HttpStatus.OK);
    }

    @PostMapping("/updateCustomer")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customer) {
        CustomerDto customer1 = customerService.updateCustomer(customer);
        return new ResponseEntity<CustomerDto>(customer1, HttpStatus.OK);
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") int id) throws CustomerNotFoundException {
        CustomerDto customer1 = customerService.getCustomerById(id);
        return new ResponseEntity<CustomerDto>(customer1, HttpStatus.OK);
    }

    @GetMapping("/getCustomerByUserId/{id}")
    public ResponseEntity<CustomerDto> getCustomerByUserId(@PathVariable("id") int id) throws CustomerNotFoundException {
        CustomerDto customer1 = customerService.getCustomerByUserId(id);
        return new ResponseEntity<CustomerDto>(customer1, HttpStatus.OK);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() throws CustomerNotFoundException {
        List<CustomerDto> customers = customerService.getAllCustomer();
        return new ResponseEntity<List<CustomerDto>>(customers, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) throws CustomerNotFoundException {
        String result = customerService.deleteCustomer(id);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
    
}
