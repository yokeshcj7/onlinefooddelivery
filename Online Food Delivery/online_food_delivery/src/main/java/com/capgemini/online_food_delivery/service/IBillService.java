package com.capgemini.online_food_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.online_food_delivery.entity.Bill;
import com.capgemini.online_food_delivery.repository.IBillRepository;

import com.capgemini.online_food_delivery.entity.FoodCart;
import com.capgemini.online_food_delivery.repository.IFoodCartRepository;

import java.util.List;

import java.time.LocalDateTime;

@Service
@Transactional
public class IBillService {


    @Autowired
    private IBillRepository billRepository;

    @Autowired
    private IFoodCartRepository foodCartRepository;


    public Bill addBill(Bill bill) {
        Bill bill1 = billRepository.save(bill);

        bill1.setBillDate(LocalDateTime.now());
        bill1.setOrderId(bill.getOrderId());
        bill1.setTotalCost(bill.getTotalCost());
        bill1.setTotalItem(bill.getTotalItem());
        bill1.setCustomerId(bill.getCustomerId());

        Bill result = billRepository.save(bill1);
        return result;

    }

    public Bill getBill(int billId) {
        Bill bill = billRepository.findById(billId).get();
        return bill;
    }

    public Bill updateBill(Bill bill) {
        Bill bill1 = billRepository.findBillById(bill.getId());

        bill1.setBillDate(bill.getBillDate());
        bill1.setOrderId(bill.getOrderId());
        bill1.setTotalCost(bill.getTotalCost());
        bill1.setTotalItem(bill.getTotalItem());
        bill1.setCustomerId(bill.getCustomerId());

        Bill result = billRepository.save(bill1);
        return result;
    }

    public String deleteBill(int billId) {
        billRepository.deleteById(billId);
        return "Bill deleted successfully";
    }

    public List<Bill> getBillsByCustomerId(int customerId) {
        List<Bill> bills = billRepository.findBillsByCustomerId(customerId);
        return bills;
    }

    public List<Bill> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        return bills;
    }

    public double getTotalBillCost(int customerId) {
        FoodCart foodCart = foodCartRepository.findByCustomerId(customerId);

        return foodCart.getCartTotal();
    }

    public Bill getBillById(int billId) {
        Bill bill = billRepository.findBillById(billId);
        return bill;
    }


}
