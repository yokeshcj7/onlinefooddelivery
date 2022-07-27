import {React,useState} from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import {BASE_URL,GET_ALL_CUSTOMER_BY_USERID_ENDPOINT,LOGIN_ENDPOINT} from './../../Constants/apiEndpoints';
import {setUserInfo} from './../../Utils/UserInfo';

import "./css/User.css";

const initialData = {userName:"",password:""}

export default function Login() {
  
  const navigate = useNavigate();

  const [formData,setFormData] = useState(initialData);

  const handleChange = (e) => {
    setFormData({...formData,[e.target.name]:e.target.value})
  }

  // Handle login
  const handleLogin = async (e) => {
    e.preventDefault();
    console.log(formData);

    // Send login request to server
    try{
      const response = await axios.post(BASE_URL+LOGIN_ENDPOINT,formData);
      console.log(response);
      if(response.status === 200){

        const customerId = await axios.get(BASE_URL+GET_ALL_CUSTOMER_BY_USERID_ENDPOINT+response.data.id);

        
        // Redirect to home page
        setUserInfo({...response.data,customerId:customerId.data.customerId});
        navigate("/home");
        navigate(0);
      }
    }catch(err){
      console.log(err);
      alert("Invalid username or password");
    }

  }

  return (
    <div class="container">
      <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
          <div class="card border-0 shadow rounded-3 my-5">
            <div class="card-body p-4 p-sm-5">
              <h5 class="card-title text-center mb-5 fw-light fs-5">Sign In</h5>
              <form>
                <div class="form-floating mb-3">
                  <input
                    type="text"
                    value={formData.userName}
                    class="form-control"
                    id="userName"
                    placeholder="jhonDoe69"
                    name="userName"
                    onChange={handleChange}
                    required={true}
                  />
                  <label for="floatingInput">User Name</label>
                </div>
                <div class="form-floating mb-3">
                  <input
                    type="password"
                    value={formData.password}
                    class="form-control"
                    id="password"
                    name="password"
                    placeholder="Password"
                    onChange={handleChange}
                    required={true}
                  />
                  <label for="floatingPassword">Password</label>
                </div>

                <div class="d-grid">
                  <button
                    class="btn btn-primary btn-login text-uppercase fw-bold"
                    type="submit"
                    onClick={handleLogin}
                  >
                    Sign in
                  </button>
                </div>
                <hr class="my-4" />
              </form>
            </div>
          </div>
          <div className="" >
            <p className="text-center">
              Don't have an account? <a href="/register">Sign up</a>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}
