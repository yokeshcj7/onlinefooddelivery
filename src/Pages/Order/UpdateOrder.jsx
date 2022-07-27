import React, { useState,useEffect } from "react";
import { Link } from "react-router-dom";
import { useParams } from 'react-router-dom';
import axios from 'axios';
function UpdateOrder() {
    const [orderDetails,setOrderDetails]=useState({});
    const [custId,setCustomerId]=useState(0);
    const [orderDate,setOrderDate]=useState('');
    const [status,setStatus]=useState("");
    const [orderAmount,setOrderAmount]=useState(0);
    const [itemId,setItemId]=useState(0);
    const [restaurentId,setRestaurentId]=useState(0);
    

    const { id } = useParams();

    useEffect(() => {
        axios.get("http://localhost:8080/orderDetails/viewById/"+id).then(resp => 
            setOrderDetails(resp.data)
        );
        setCustomerId(orderDetails.customerId);
        setStatus(orderDetails.status);
        setOrderAmount(orderDetails.orderAmount);
        setOrderDate(orderDetails.orderDate);
    }, [id])

    const saveOrder=()=>{
        const result={
            id:1,
            customerId:custId,
            status:status,
            orderAmount:orderAmount,
            orderItems:[{restaurentId:restaurentId,itemId:itemId}]
        };
        axios.put("http://localhost:8080/orderDetails/updateOrder/",result)
        .then(resp=> alert("Order is updated with id: "))
    }
    const cancel=()=>{
        <Link to="/viewByCustomer"></Link>
    }
    return (
        <div>
            <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className='text-center'>Update Order</h3>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group'>
                                        <label>Customer Id</label>
                                        <input placeholder={custId} name='customerId' 
                                            className='form-control'  
                                            onChange={e=>setCustomerId(e.target.value)}/> 
                                    </div>
                                    <div className='form-group'>
                                        <label>Restaurent Id</label>
                                        <input placeholder='Restaurent Id' name='restaurentId' 
                                            className='form-control' value={restaurentId||''} 
                                            onChange={e=>setRestaurentId(e.target.value)}/> 
                                    </div>
                                    <div className='form-group'>
                                        <label>Item Id</label>
                                        <input placeholder='Item Id' name='itemId' 
                                            className='form-control' value={itemId||''} 
                                            onChange={e=>setItemId(e.target.value)}/> 
                                    </div>
                                    <div className='form-group'>
                                        <label>status</label>
                                        <input placeholder={status} name='status' 
                                            className='form-control' 
                                            onChange={e=>setStatus(e.target.value)}/> 
                                    </div>
                                    <div className='form-group'>
                                        <label>Order Amount</label>
                                        <input placeholder='order amount' name='orderAmount' 
                                            className='form-control' value={orderAmount||''} 
                                            onChange={e=>setOrderAmount(e.target.value)}/> 
                                    </div>
                                    <button className='btn btn-success' onClick={saveOrder}>Save</button>
                                    <button className='btn btn-danger' onClick={()=>cancel} style={{marginLeft:"10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    )
}
export default UpdateOrder;