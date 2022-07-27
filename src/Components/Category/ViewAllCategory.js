import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios'
import CategoryService from './../../services/CategoryService';

const ViewAllCategory = () => {

    const [category, setCategory] = useState([]);
    
    useEffect(() => {
        viewAllCategory();

    }, [])
    const viewAllCategory = () => {

        CategoryService.viewAllCategory().then((response) => {
            console.log(response);
            setCategory(response.data)

        }).catch(error => {
            console.log(error);
        })

    }
    const deleteCategory = (id) => {

        axios.delete("http://localhost:8080/category/removeCategory/" + id).then((response) => {
            console.log(response);
            setCategory(response.data.name)
            alert("Category Deleted Successfully")
            viewAllCategory();

        }).catch(error => {
            console.log(error);
        })

    };
    return (

        <div>
            <h2 className="text-center">Category List</h2>
            <td><Link to={`/add/`}>Add</Link></td>
            <table className="table table -bordered">
                <thead>
                    <tr>
                        <th> Category Id</th>
                        <th> Category Name</th>
                        <th> View </th>
                        <th>Update </th>
                        <th> Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        category.map(c =>
                            <tr>

                                <td>{c.id}</td>
                                <td>{c.name}</td>
                                <td><Link to={`/findCategory/${c.id}`}>View</Link></td>
                                <td><Link to={`/editCategory/${c.id}`}>Update</Link></td>
                                <td><button style={{ marginLeft: '10px' }} onClick={() => deleteCategory(c.id,c.name)}
                                    className='btn btn-danger'>Delete</button></td>



                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}
export default ViewAllCategory;