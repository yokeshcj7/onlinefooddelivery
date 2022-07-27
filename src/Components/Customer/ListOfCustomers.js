import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { listOfCustomers } from '../../services/CustomerService';


export default function ListofCustomers() {

    const [customers, setCustomers] = useState([]);




    useEffect(() => {
        listOfCustomers().then(resp => setCustomers(resp.data));
    }, [])




    return (

        <body>
            <form>
            <div>
                <center><h3> Customers Details Dasboard</h3></center>
            </div>
            <br>

            </br>
            <div>
                <div class="table-responsive">
                    <center>
                        <Link to={`/AddCustomer`}><button type="button" class="btn btn-success">AddCustomer</button></Link>
                    </center>
                    <br>

                    </br>
                    <div className='container'>
                        <table class="table table-bordered">
                            <thead class="thead-dark">

                                <tr>

                                    <th><center>CustomerId</center></th>
                                    <th><center>Firstname</center></th>
                                    <th><center>Lastname</center></th>
                                    <th><center>Email</center></th>
                                    <th><center>MobileNumber</center></th>
                                    <th><center>Action</center></th>

                                </tr>
                            </thead>
                            <tbody>
                                {
                                    customers.map(p =>
                                        <tr>
                                            <td><center>{p.customerId}</center></td>
                                            <td>{p.firstName}</td>
                                            <td>{p.lastName}</td>
                                            <td>{p.email}</td>
                                            <td>{p.mobileNumber}</td>
                                            <td><center><Link to={`/GetCustomerById/${p.customerId}`}><button type="button" class="btn btn-primary">View  </button>  </Link>
                                                <Link to={`/updateCustomer/${p.customerId}`}><button type="button" class="btn btn-warning">Update</button></Link></center>
                                            </td>


                                        </tr>
                                    )}
                            </tbody>

                        </table>
                    </div>

                </div>

            </div>
            </form>
        </body>
    )
}

