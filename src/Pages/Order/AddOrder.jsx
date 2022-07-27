import React, { useState } from "react";
import axios from 'axios';
function AddOrder() {
    const [custId,setCustomerId]=useState(0);
    const [status,setStatus]=useState("");
    const [orderAmount,setOrderAmount]=useState(0);
    const [itemId,setItemId]=useState(0);
    const [restaurentId,setRestaurentId]=useState(0);
    const saveOrder=()=>{
        const result={
            customerId:custId,
            status:status,
            orderAmount:orderAmount
        };
        axios.post("http://localhost:8080/orderDetails/addOrder",result)
        .then(resp=> alert("Order is placed with id: "+resp.data.id))
    }
    const cancel=()=>{
        this.props.history.push('/admin');
    }
    return (
        <div>
            <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className='text-center'>Add Order</h3>
                            <div className='card-body'>
                                <form>
                                    <div className='form-group'>
                                        <label>Customer Id</label>
                                        <input placeholder='Customer Id' name='customerId' 
                                            className='form-control' value={custId} 
                                            onChange={e=>setCustomerId(e.target.value)}/> 
                                    </div>
                                    <div className='form-group'>
                                        <label>Restaurent Id</label>
                                        <input placeholder='Restaurent Id' name='restaurentId' 
                                            className='form-control' value={restaurentId} 
                                            onChange={e=>setRestaurentId(e.target.value)}/> 
                                    </div>
                                    <div className='form-group'>
                                        <label>Item Id</label>
                                        <input placeholder='Item Id' name='itemId' 
                                            className='form-control' value={itemId} 
                                            onChange={e=>setItemId(e.target.value)}/> 
                                    </div>
                                    <div className='form-group'>
                                        <label>status</label>
                                        <input placeholder='status' name='status' 
                                            className='form-control' value={status} 
                                            onChange={e=>setStatus(e.target.value)}/> 
                                    </div>
                                    <div className='form-group'>
                                        <label>Order Amount</label>
                                        <input placeholder='order amount' name='orderAmount' 
                                            className='form-control' value={orderAmount} 
                                            onChange={e=>setOrderAmount(e.target.value)}/> 
                                    </div>
                                    <button className='btn btn-success' onClick={saveOrder}>Save</button>
                                    <button className='btn btn-danger' onClick={cancel} style={{marginLeft:"10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    )
}
export default AddOrder;