import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getCustomerById } from '../../services/CustomerService';
import { Link } from 'react-router-dom';

function ViewPage() {
    const [customer, setCustomer] = useState(null);

    const { id } = useParams();
    

    useEffect(() => {
        getCustomerById(id).then(resp => setCustomer(resp.data));
    })


    return (
        
        <div>
            <div className="container">
            
                <h1 className="text-center">Profile Details</h1>
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

                            <Link to={`/getCustomerByUserId/${customer.userId}`}><button className="btn btn-success">Back</button></Link>

                            </div>
                        }
                    </div>
                    </center>
                </div>
                
            </div>
            
        </div>
        

    )
}
export default ViewPage;