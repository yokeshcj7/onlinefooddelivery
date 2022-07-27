import React, { useEffect, useState } from "react";
import { useParams } from 'react-router-dom';
import axios from 'axios';

const ViewByOrder=()=>{
    const [orderDetails, setOrderDetails] = useState({});

    const { id } = useParams();

    useEffect(() => {
        axios.get("http://localhost:8080/orderDetails/viewById/"+id).then(resp => setOrderDetails(resp.data));
    })

    return(
        <div>
            
            <div className="table-responsive">
                <table className="table table-bordered">
                    <thead className="thead-dark">
                        <tr>
                            <th>Order Id</th>
                            <th>Order Date</th>
                            <th>Customer Id</th>
                            <th>Status</th>
                            <th>Order Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                            
                                <tr key={orderDetails.id}>
                                    <td>{orderDetails.id}</td>
                                    <td>{orderDetails.orderDate}</td>
                                    <td>{orderDetails.customerId}</td>
                                    <td>{orderDetails.status}</td>
                                    <td>{orderDetails.orderAmount}</td>
                                    
                                </tr>
                            
                    </tbody>
                </table>
            </div>

        </div>
    );
}
export default ViewByOrder;