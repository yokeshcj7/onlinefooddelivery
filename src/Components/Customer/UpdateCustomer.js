import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getCustomerById, updateCustomer } from '../../services/CustomerService';

export default function Updatecustomer() {

    const [pCustomerId, setpCustomerId] = useState('');
    const [pFirstName, setpFirstName] = useState('');
    const [pLastName, setpLastName] = useState('');
    const [pAge, setpAge] = useState('');
    const [pGender, setpGender] = useState('');
    const [pMobileNumber, setpMobileNumber] = useState('');
    const [pEmail, setpEmail] = useState('');
    const [pUserId, setpUserId] = useState('');
    const [pBuildingName, setpBuildingName] = useState('');
    const [pStreetNo, setpStreetNo] = useState('');
    const [pCity, setpCity] = useState('');
    const [pState, setpState] = useState('');
    const [pCountry, setpCountry] = useState('');
    const [pPincode, setpPincode] = useState('');


    const { id } = useParams();
    const navigate = useNavigate();


    useEffect(() => {
        getCustomerById(id).then(resp => {
            setpCustomerId(resp.data.customerId);
            setpFirstName(resp.data.firstName);
            setpLastName(resp.data.lastName);
            setpAge(resp.data.age);
            setpGender(resp.data.gender);
            setpMobileNumber(resp.data.mobileNumber);
            setpEmail(resp.data.email);
            setpUserId(resp.data.userId);
            setpBuildingName(resp.data.buildingName);
            setpStreetNo(resp.data.streetNo);
            setpCity(resp.data.city);
            setpState(resp.data.state);
            setpCountry(resp.data.country);
            setpPincode(resp.data.pincode);




        });
    }, [id])


    const handleSubmit = () => {

        const payload = {

            customerId: pCustomerId,
            firstName: pFirstName,
            lastName: pLastName,
            age: pAge,
            gender: pGender,
            mobileNumber: pMobileNumber,
            email: pEmail,
            userId: pUserId,
            buildingName: pBuildingName,
            streetNo: pStreetNo,
            city: pCity,
            state: pState,
            country: pCountry,
            pincode: pPincode,


        }

        updateCustomer(payload).then(resp => navigate(-1)).catch(error => console.log("something went wrong"))
    }

    return (

        <div class="container mt-2">

            <div className="container">
                <div className="row">
                    <div className="card col-md-8 offset-md-2">
                        <div className="card-body">
                            <div class="card-header text-center text-white bg-primary">
                                <h2>Update Customer</h2>
                            </div>
                            <br>

                            </br>

                            <center>
                                <h5>
                                <div className="form-group">
                                    <label>FirstName</label>
                                    <input type="text" id="pFirstName" name="pFirstName" placeholder="Enter Here" className="form-control" value={pFirstName} onChange={e => setpFirstName(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>LastName</label>
                                    <input type="text" id="pLastName" name="pLastName" placeholder="Enter Here" className="form-control" value={pLastName} onChange={e => setpLastName(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>Age</label>
                                    <input type="text" id="pAge" name="pAge" placeholder="Enter Here" className="form-control" value={pAge} onChange={e => setpAge(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>Gender</label>
                                    <input type="text" id="pGender" name="pGender" placeholder="Enter Here" className="form-control" value={pGender} onChange={e => setpGender(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>Mobile Number</label>
                                    <input type="text" id="pMobileNumber" name="pMobileNumber" placeholder="Enter Here" className="form-control" value={pMobileNumber} onChange={e => setpMobileNumber(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>Email</label>
                                    <input type="text" id="pEmail" name="pEmail" placeholder="Enter Here" className="form-control" value={pEmail} onChange={e => setpEmail(e.target.value)}></input>
                                </div>


                                <div className="form-group">
                                    <label>Building Name</label>
                                    <input type="text" id="pBuildingName" name="pBuildingName" placeholder="Enter Here" className="form-control" value={pBuildingName} onChange={e => setpBuildingName(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>StreetNo</label>
                                    <input type="text" id="pStreetNo" name="pStreetNo" placeholder="Enter Here" className="form-control" value={pStreetNo} onChange={e => setpStreetNo(e.target.value)}></input>
                                </div>

                                <div>
                                    <label>City</label>
                                    <input type="text" id="pCity" name="pCity" placeholder="Enter Here" className="form-control" value={pCity} onChange={e => setpCity(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>State</label>
                                    <input type="text" id="pLState" name="pState" placeholder="Enter Here" className="form-control" value={pState} onChange={e => setpState(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>Country</label>
                                    <input type="text" id="pCountry" name="pCountry" placeholder="Enter Here" className="form-control" value={pCountry} onChange={e => setpCountry(e.target.value)}></input>
                                </div>

                                <div className="form-group">
                                    <label>Pincode</label>
                                    <input type="text" id="pPincode" name="pPincode" placeholder="Enter Here" className="form-control" value={pPincode} onChange={e => setpPincode(e.target.value)}></input>
                                </div>
                                </h5> 
                                <div>
                                    <button className="btn btn-success" onClick={handleSubmit}>Update</button>
                                </div>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )

}

