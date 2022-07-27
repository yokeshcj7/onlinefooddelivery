package com.capgemini.online_food_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.online_food_delivery.entity.User;
import com.capgemini.online_food_delivery.entity.Customer;
import com.capgemini.online_food_delivery.dto.CustomerDto;
import com.capgemini.online_food_delivery.entity.Address;
import com.capgemini.online_food_delivery.repository.IUserRepository;
import com.capgemini.online_food_delivery.repository.ICustomerRepository;
import com.capgemini.online_food_delivery.repository.IAddressRepository;

import com.capgemini.online_food_delivery.exception.CustomerNotFoundException;

import java.util.List;
import java.util.ArrayList;

@Service
@Transactional
public class ICustomerService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    IAddressRepository addressRepository;

    public CustomerDto addCustomer(CustomerDto customer) {
        User user = userRepository.findUserById(customer.getUserId());
        if (user == null) {
            return null;
        }
        Address address = new Address();
        address.setBuildingName(customer.getBuildingName());
        address.setStreetNo(customer.getStreetNo());
        address.setCity(customer.getCity());
        address.setState(customer.getState());
        address.setCountry(customer.getCountry());
        address.setPincode(customer.getPincode());
        address = addressRepository.save(address);

        Customer customer1 = new Customer();
        customer1.setuserId(user.getId());
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setAge(customer.getAge());
        customer1.setGender(customer.getGender());
        customer1.setMobileNumber(customer.getMobileNumber());
        customer1.setEmail(customer.getEmail());
        customer1.setaddress_id(address.getId());
        customerRepository.save(customer1);

        CustomerDto result = new CustomerDto();
        result.setCustomerId(customer1.getId());
        result.setUserId(customer.getUserId());
        result.setFirstName(customer.getFirstName());
        result.setLastName(customer.getLastName());
        result.setAge(customer.getAge());
        result.setGender(customer.getGender());
        result.setMobileNumber(customer.getMobileNumber());
        result.setEmail(customer.getEmail());
        result.setBuildingName(customer.getBuildingName());
        result.setStreetNo(customer.getStreetNo());
        result.setCity(customer.getCity());
        result.setState(customer.getState());
        result.setCountry(customer.getCountry());
        result.setPincode(customer.getPincode());
        return result;

    }

    public CustomerDto updateCustomer(CustomerDto customerDetails) throws CustomerNotFoundException {
        Customer customer = customerRepository.findCustomerById(customerDetails.getCustomerId());


        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
    
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setAge(customerDetails.getAge());
        customer.setGender(customerDetails.getGender());
        customer.setMobileNumber(customerDetails.getMobileNumber());
        customer.setEmail(customerDetails.getEmail());
        customerRepository.save(customer);

        System.out.println(customer.getaddress_id());
        Address address = addressRepository.findAddressById(customer.getaddress_id());

        System.out.println("Addres Retrived"+address.getId());

        address.setBuildingName(customerDetails.getBuildingName());
        address.setStreetNo(customerDetails.getStreetNo());
        address.setCity(customerDetails.getCity());
        address.setState(customerDetails.getState());
        address.setCountry(customerDetails.getCountry());
        address.setPincode(customerDetails.getPincode());
        addressRepository.save(address);

        CustomerDto result = new CustomerDto();

        result.setCustomerId(customer.getId());
        result.setUserId(customer.getuserId());
        result.setFirstName(customer.getFirstName());
        result.setLastName(customer.getLastName());
        result.setAge(customer.getAge());
        result.setGender(customer.getGender());
        result.setMobileNumber(customer.getMobileNumber());
        result.setEmail(customer.getEmail());

        result.setBuildingName(address.getBuildingName());
        result.setStreetNo(address.getStreetNo());
        result.setCity(address.getCity());
        result.setState(address.getState());
        result.setCountry(address.getCountry());
        result.setPincode(address.getPincode());

        return result;

    }

    public CustomerDto getCustomerById(Integer id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        CustomerDto result = new CustomerDto();
        result.setCustomerId(customer.getId());
        result.setUserId(customer.getuserId());
        result.setFirstName(customer.getFirstName());
        result.setLastName(customer.getLastName());
        result.setAge(customer.getAge());
        result.setGender(customer.getGender());
        result.setMobileNumber(customer.getMobileNumber());
        result.setEmail(customer.getEmail());

        Address address = addressRepository.findAddressById(customer.getaddress_id());
        result.setBuildingName(address.getBuildingName());
        result.setStreetNo(address.getStreetNo());
        result.setCity(address.getCity());
        result.setState(address.getState());
        result.setCountry(address.getCountry());
        result.setPincode(address.getPincode());

        return result;
    }

    public CustomerDto getCustomerByUserId(Integer id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findCustomerByUserId(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        CustomerDto result = new CustomerDto();
        result.setCustomerId(customer.getId());
        result.setUserId(customer.getuserId());
        result.setFirstName(customer.getFirstName());
        result.setLastName(customer.getLastName());
        result.setAge(customer.getAge());
        result.setGender(customer.getGender());
        result.setMobileNumber(customer.getMobileNumber());
        result.setEmail(customer.getEmail());

        Address address = addressRepository.findAddressById(customer.getaddress_id());
        result.setBuildingName(address.getBuildingName());
        result.setStreetNo(address.getStreetNo());
        result.setCity(address.getCity());
        result.setState(address.getState());
        result.setCountry(address.getCountry());
        result.setPincode(address.getPincode());

        return result;
    }

    public List<CustomerDto> getAllCustomer() throws CustomerNotFoundException {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> result = new ArrayList<>();

        if (customers.isEmpty()) {
            throw new CustomerNotFoundException("No customers found");
        }

        for (Customer customer : customers) {
            CustomerDto customerDao = new CustomerDto();
            customerDao.setCustomerId(customer.getId());
            customerDao.setUserId(customer.getuserId());
            customerDao.setFirstName(customer.getFirstName());
            customerDao.setLastName(customer.getLastName());
            customerDao.setAge(customer.getAge());
            customerDao.setGender(customer.getGender());
            customerDao.setMobileNumber(customer.getMobileNumber());
            customerDao.setEmail(customer.getEmail());
            Address address = addressRepository.findAddressById(customer.getaddress_id());
            customerDao.setBuildingName(address.getBuildingName());
            customerDao.setStreetNo(address.getStreetNo());
            customerDao.setCity(address.getCity());
            customerDao.setState(address.getState());
            customerDao.setCountry(address.getCountry());
            customerDao.setPincode(address.getPincode());
            result.add(customerDao);
        }
        return result;
    }

    public String deleteCustomer(Integer id ) throws CustomerNotFoundException { 
        try {
            addressRepository.deleteById(customerRepository.findCustomerById(id).getaddress_id());

            customerRepository.deleteById(id);
            return "Customer deleted successfully";
        } catch (Exception e) {
            throw new CustomerNotFoundException("Customer not found");
        }

    }
}
