
import axios from 'axios';
const baseUrl='http://localhost:8080/category';
class CategoryService{
    viewAllCategory() {
        return axios.get(baseUrl+"/viewAllCategory");
     }
     addCategory(category) {
        return axios.post(baseUrl+"/add", category);
    }
    editCategory(categoryId,category) {
        return axios.put(baseUrl+"/edit", categoryId,category)
    }
    viewCategoryById(categoryId) {
        return axios.get(baseUrl+"/viewCategory/", +categoryId);
    }
     deleteCategory(categoryId) {
            return axios.delete(baseUrl+"/removeCategory/",categoryId);
     }
    }

export default new CategoryService();