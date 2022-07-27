import axios from "axios";
import { useState } from "react";
import "../../Pages/User/Registration.css";
import { Link } from "react-router-dom";



function AddCustomer() {
    const [pFirstName, setpFirstName] = useState('');
    const [pLastName, setpLastName] = useState('');
    const [pAge, setpAge] = useState('');
    const [pGender, setpGender] = useState('');
    const [pMobileNumber, setpMobileNumber] = useState('');
    const [pEmail, setpEmail] = useState('');
    const [pBuildingName, setpBuildingName] = useState('');
    const [pStreetNo, setpStreetNo] = useState('');
    const [pCity, setpCity] = useState('');
    const [pState, setpState] = useState('');
    const [pCountry, setpCountry] = useState('');
    const [pPincode, setpPincode] = useState('');

    const [pUserId1, setpUserId1] = useState('');
    const [pUserName, setpUserName] = useState('');
    const [pPassword, setpPassword] = useState('');

   
    const [formErrors, setFormErrors] = useState({});

    async function handleSubmit(event) {


        let errors = {};

        if (!pFirstName) {

            errors["pFirstNameError"] = "First Name is required"
        }
        if (!pLastName) {
            errors["pLastNameError"] = "Last Name is required"
        }
        if (!pAge) {
            errors["pAgeError"] = "Age is required"

        }
        if (!pGender) {
            errors["pGenderError"] = "Gender is required"
        }

        if (!pMobileNumber) {
            errors["pMobileNumberError"] = "Mobile Number is required"
        }

        if (!pEmail) {
            errors["pEmailError"] = "Email is required"
        }


        if (!pBuildingName) {
            errors["pBuildingNameError"] = "Building Name is required"

        }

        if (!pStreetNo) {
            errors["pStreetNoError"] = "Street Number is required"
        }

        if (!pCity) {

            errors["pCityError"] = "City is required"

        }

        if (!pState) {
            errors["pStateError"] = "State is required"

        }

        if (!pCountry) {
            errors["pCountryError"] = "Country is required"

        }

        if (!pPincode) {
            errors["pPincodeError"] = "Pincode is required"

        }

        if (!pUserName) {
            errors["pUserNameError"] = "User Name is required"

        }

        if (!pPassword) {
            errors["pPasswordError"] = "Password is required"

        }



        setFormErrors(errors);

        const noErrors = Object.keys(errors).length === 0;
        if (noErrors) {

            event.preventDefault();
            try {
                axios.post("http://localhost:8080/User/signUp",
                    {
                        userId: pUserId1,
                        userName: pUserName,
                        password: pPassword


                    }).then((Response) => {
                        setpUserId1(Response.data.id)
                        axios.post("http://localhost:8080/customer/addCustomer",

                            {
                                firstName: pFirstName,
                                lastName: pLastName,
                                age: pAge,
                                gender: pGender,
                                mobileNumber: pMobileNumber,
                                userId: Response.data.id,
                                email: pEmail,
                                buildingName: pBuildingName,
                                streetNo: pStreetNo,
                                city: pCity,
                                state: pState,
                                country: pCountry,
                                pincode: pPincode,
                            }
                        ).then((Response) => {
                            console.log(Response.data.id)
                        })
                    })






                alert("User Added Successfully");

                setpFirstName("");
                setpLastName("");
                setpAge("");
                setpGender("");
                setpMobileNumber("");
                setpEmail("");

                setpBuildingName("");
                setpStreetNo("");
                setpCity("");
                setpState("");
                setpCountry("");
                setpPincode("");
                setpUserId1("");
                setpUserName("");
                setpPassword("");


            }
            catch (err) {
                alert("User Adding Failed");
            }
        }
    }
    return (
        <div className="container">
                <div className="row">
                    <div className="card col-md-8 offset-md-2">
                        <div className="card-body">
        <div className="register-container">
            <center>
                <div>

                    <h1>Add Customer</h1>
                    <p>Fill in the Information Below</p>
                </div>



                <div className="form-group">
                    <label>FirstName</label>
                    <input type="text" id="pFirstName" name="pFirstName" placeholder="Enter Here" className="form-control" value={pFirstName} onChange={e => setpFirstName(e.target.value)}></input>

                    {
                        formErrors.pFirstNameError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pFirstNameError}</div>
                    }</div>


                <div className="form-group">
                    <label>LastName</label>
                    <input type="text" id="pLastName" name="pLastName" placeholder="Enter Here" className="form-control" value={pLastName} onChange={e => setpLastName(e.target.value)}></input>

                    {
                        formErrors.pLastNameError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pLastNameError}</div>
                    }</div>

                <div className="form-group">
                    <label>Age</label>
                    <input type="text" id="pAge" name="pAge" placeholder="Enter Here" className="form-control" value={pAge} onChange={e => setpAge(e.target.value)}></input>

                    {
                        formErrors.pAgeError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pAgeError}</div>
                    }</div>

                <div className="form-group">
                    <label>Gender</label>
                    <input type="text" id="pGender" name="pGender" placeholder="Enter Here" className="form-control" value={pGender} onChange={e => setpGender(e.target.value)}></input>

                    {
                        formErrors.pGenderError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pGenderError}</div>
                    }</div>

                <div className="form-group">
                    <label>Mobile Number</label>
                    <input type="text" id="pMobileNumber" name="pMobileNumber" placeholder="Enter Here" className="form-control" value={pMobileNumber} onChange={e => setpMobileNumber(e.target.value)}></input>

                    {
                        formErrors.pMobileNumberError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pMobileNumberError}</div>
                    }</div>

                <div className="form-group">
                    <label>Email</label>
                    <input type="text" id="pEmail" name="pEmail" placeholder="Enter Here" className="form-control" value={pEmail} onChange={e => setpEmail(e.target.value)}></input>

                    {
                        formErrors.pEmailError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pEmailError}</div>
                    }</div>


                <div className="form-group">
                    <label>Building Name</label>
                    <input type="text" id="pBuildingName" name="pBuildingName" placeholder="Enter Here" className="form-control" value={pBuildingName} onChange={e => setpBuildingName(e.target.value)}></input>

                    {
                        formErrors.pBuildingNameError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pBuildingNameError}</div>
                    }</div>

                <div className="form-group" >
                    <label>StreetNo</label>
                    <input type="text" id="pStreetNo" name="pStreetNo" placeholder="Enter Here" className="form-control" value={pStreetNo} onChange={e => setpStreetNo(e.target.value)}></input>
                    {
                        formErrors.pStreetNoError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pStreetNoError}</div>
                    }</div>

                <div className="form-group">
                    <label>City</label>
                    <input type="text" id="pCity" name="pCity" placeholder="Enter Here" className="form-control" value={pCity} onChange={e => setpCity(e.target.value)}></input>
                    {
                        formErrors.pCityError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pCityError}</div>
                    }</div>

                <div className="form-group">
                    <label>State</label>
                    <input type="text" id="pLState" name="pState" placeholder="Enter Here" className="form-control" value={pState} onChange={e => setpState(e.target.value)}></input>
                    {
                        formErrors.pStateError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pStateError}</div>
                    }</div>

                <div className="form-group">
                    <label>Country</label>
                    <input type="text" id="pCountry" name="pCountry" placeholder="Enter Here" className="form-control" value={pCountry} onChange={e => setpCountry(e.target.value)}></input>
                    {
                        formErrors.pCountryError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pCountryError}</div>
                    }</div>

                <div className="form-group">
                    <label>Pincode</label>
                    <input type="text" id="pPincode" name="pPincode" placeholder="Enter Here" className="form-control" value={pPincode} onChange={e => setpPincode(e.target.value)}></input>
                    {
                        formErrors.pPincodeError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pPincodeError}</div>
                    }</div>

                <div className="form-group">
                    <label>User Name</label>
                    <input type="text" id="pUserName" name="pUserName" placeholder="Enter Here" className="form-control" value={pUserName} onChange={e => setpUserName(e.target.value)}></input>
                    {
                        formErrors.pUserNameError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pUserNameError}</div>
                    }
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input type="password" id="Password" name="Password" placeholder="Enter Here" className="form-control" value={pPassword} onChange={e => setpPassword(e.target.value)} ></input>
                    {
                        formErrors.pPasswordError && <div style={{ color: "red", paddingBottom: 10 }}> {formErrors.pPasswordError}</div>
                    }
                </div>



                <div>
                    <button className="btn btn-success" onClick={handleSubmit}> Submit </button>
                    <Link to={`/`}><button className="btn btn-primary">Back</button></Link>
                </div>
            </center>

        </div>
        </div>
        </div>
        </div>
        </div>

    )
}
export default AddCustomer;