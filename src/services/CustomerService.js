import { BASE_URL } from './../util/AppConstants'
import { BASE_URL1 } from './../util/AppConstants2'
import axios from 'axios'


export function listOfCustomers() {
    return axios.get(BASE_URL + "/getAllCustomers");
}

export function getCustomerById(customerId) {
    return axios.get(BASE_URL + "/getCustomerById/" + customerId);
}

export function addCustomer(customer) {
    return axios.post(BASE_URL+"/addCustomer", customer)
}

export function updateCustomer(customer) {
    return axios.post(BASE_URL+"/updateCustomer", customer)
}

export function deleteCustomer(customerId) {
    return axios.delete(BASE_URL+"/deleteCustomer/"+customerId)
}

export function signUp() {
    return axios.post(BASE_URL1+"/signUp")
}

export function getCustomerByUserId(userId) {
    return axios.get(BASE_URL + "/getCustomerByUserId/"+userId);
}