import React, { useEffect, useState } from "react";
import axios from 'axios';
import { getUserInfo } from "./../../Utils/UserInfo";
import { useNavigate } from "react-router-dom";

const ViewByCustomer = () => {
    const [orderDetails, setOrderDetails] = useState([]);
    const [sId,setSId]=useState(0);

    const id = getUserInfo().customerId;
    const navigate = useNavigate();
    
    useEffect(() => {
        axios.get("http://localhost:8080/orderDetails/viewByCustomer/" + id).then(resp => setOrderDetails(resp.data));

    }, [id]);
    const search=()=>{
        navigate(`/viewByOrder/${sId}`);
    }

    const cancel = (id1) => {
        const next = [...orderDetails];
        axios.delete("http://localhost:8080/orderDetails/removeOrder/" + id1)
            .then();
        setOrderDetails(next);
    };
    /*const callByRest = () => {
        axios.get("http://localhost:8080/Restaurent/getRestaurentById/" + restaurentId).then(resp => console.log(resp.data));
        axios.get("http://localhost:8080/Item/getItemById/" + itemId).then(resp => setItem(resp.data));
    }*/

    const callBy = (orderlist) => {
        return (
            <div>
                <div className="accordion" id="accordionExample">
                    <div className="accordion-item">
                        <h2 className="accordion-header" id="headingOne">
                            <button className="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Order Items
                            </button>
                        </h2>
                        <div id="collapseOne" className="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                            <div className="accordion-body">
                                <table className="table table-bordered">
                                    <thead className="thead-dark">
                                        <tr>
                                            <th>Restaurant Id</th>
                                            <th>Item Id</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {orderlist.map(temp1 =>
                                            <tr key={temp1.id}>
                                                <td>{temp1.restaurentId/*restaurent.restaurentName*/}</td>
                                                <td>{temp1.itemId/*item.name*/}</td>
                                            </tr>)
                                        }

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>);
    };

    return (
        <div>
            <div class="input-group">
                <input type="search" placeholder="Search" aria-label="Search" onChange={e=>setSId(e.target.value)} aria-describedby="search-addon" />
                <button type="button" class="btn btn-outline-primary" onClick={()=>search(sId)}>search</button>
            </div>
            <div className="table-responsive">
                <table className="table table-bordered">
                    <thead className="thead-dark">
                        <tr>
                            <th>Order Id</th>
                            <th>Order Date</th>
                            <th>Customer Id</th>
                            <th>Status</th>
                            <th>Order Amount</th>
                            <th>Order items</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            orderDetails.map(p =>
                                <tr key={p.id}>
                                    <td>{p.id}</td>
                                    <td>{p.orderDate}</td>
                                    <td>{p.customerId}</td>
                                    <td>{p.status}</td>
                                    <td>{p.orderAmount}</td>
                                    <td>{callBy(p.orderItems)}</td>
                                    <td><button style={{ marginLeft: '10px' }} onClick={() => cancel(p.id)}
                                        className='btn btn-danger'>Delete</button></td>
                                </tr>
                            )}
                    </tbody>
                </table>
            </div>

        </div>
    );
};
export default ViewByCustomer;

