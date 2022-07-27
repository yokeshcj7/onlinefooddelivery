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


import com.capgemini.online_food_delivery.service.IBillService;
import com.capgemini.online_food_delivery.entity.Bill;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/Bill")
public class IBillController {

    @Autowired
    private IBillService billService;

    @PostMapping("/addBill")
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {

        return new ResponseEntity<Bill>(billService.addBill(bill), HttpStatus.OK);
    }

    @PostMapping("/updateBill")
    public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) {

        return new ResponseEntity<Bill>(billService.updateBill(bill), HttpStatus.OK);
    }

    @GetMapping("/getBillsBycustomerId/{customerId}")
    public ResponseEntity<List<Bill>> getBillsBycustomerId(@PathVariable int customerId) {

        return new ResponseEntity<List<Bill>>(billService.getBillsByCustomerId(customerId), HttpStatus.OK);
    }

    @GetMapping("/getBillById/{billId}")
    public ResponseEntity<Bill> getBillById(@PathVariable int billId) {

        return new ResponseEntity<Bill>(billService.getBillById(billId), HttpStatus.OK);
    }

    @GetMapping("/getAllBills")
    public ResponseEntity<List<Bill>> getAllBills() {

        return new ResponseEntity<List<Bill>>(billService.getAllBills(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteBill/{billId}")
    public ResponseEntity<String> deleteBill(@PathVariable int billId) {

        return new ResponseEntity<String>(billService.deleteBill(billId), HttpStatus.OK);
    }
    
    
}
