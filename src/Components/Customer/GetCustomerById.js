import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getCustomerById, deleteCustomer } from '../../services/CustomerService';
function GetCustomerById() {
    const [customer, setCustomer] = useState(null);

    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        getCustomerById(id).then(resp => setCustomer(resp.data));
    })

    const handleDelete = () => {
        deleteCustomer(id).then(resp => navigate(-1))
    }

    return (
        
        <div>
            <div className="container">
            
                <h1 className="text-center">Customer Details</h1>
                <div className="card col-md-6 offset-md-3 offset-md-3">
                <center>
                    <div className="card-body">
                        {
                            customer != null &&
                            <div><h4>
                                <p>CustomerId: {customer.customerId}</p>
                                <p>FirstName: {customer.firstName}</p>
                                <p>LastName: {customer.lastName}</p>
                                <p>Age: {customer.age}</p>
                                <p>Gender: {customer.gender}</p>
                                <p>Mobile Number: {customer.mobileNumber}</p>
                                <p>Email: {customer.email}</p>
                                <p>user-Id : {customer.userId}</p>
                                <p>building Name: {customer.buildingName}</p>
                                <p>street number: {customer.streetNo}</p>
                                <p>City: {customer.city}</p>
                                <p>State: {customer.state}</p>
                                <p>Country: {customer.country}</p>
                                <p>pincode: {customer.pincode}</p>
                            </h4>

                                <button onClick={handleDelete} class="btn btn-danger">delete</button>
                                

                            </div>
                        }
                    </div>
                    </center>
                </div>
                
            </div>
            
        </div>
        

    )
}
export default GetCustomerById;