import { baseUrl } from '../util/AppConstants'
import axios from 'axios'

export function fetchAllProducts() {
    return axios.get(baseUrl + "/product/all");
}

export function fetchProductById(productId) {
    return axios.get(baseUrl + "/product/find/" + productId);
}

export function addProduct(product) {
    return axios.post(baseUrl+"/product/save", product)
}