import React, { useEffect, useState } from 'react';
import { useParams,Link } from 'react-router-dom';
import { getCustomerByUserId } from '../../services/CustomerService';

function GetCustomerByUserId() {
    const [customer, setCustomer] = useState(null);

    const { id } = useParams();
   

    useEffect(() => {
        getCustomerByUserId(id).then(resp => setCustomer(resp.data));
    })

    

    return (
        <div>
            <div className="container">
                <h1 className="text-center">Profile Details</h1>
                <div className="card col-md-6 offset-md-3 offset-md-3">
                    <div className="card-body">
                        <center>
                        {
                            customer != null &&
                            <div><h4>
                                <p>user-Id : {customer.userId}</p>
                                <p>FirstName: {customer.firstName}</p>
                                <p>LastName: {customer.lastName}</p>
                                <p><center><Link to={`/viewPage/${customer.customerId}`}><button type="button" class="btn btn-primary">View  </button></Link></center></p>

                                <p><center><button type="button" class="btn btn-success">Continue Ordering </button></center></p>
                                
                            </h4>
                            </div>
                        }
                        </center>
                    </div>
                </div>
            </div>
        </div>

    )
}
export default GetCustomerByUserId;