import React, { useState, useEffect } from "react";
import axios from "axios";

function UpdateRestaurent(props) {

  const [contactNumber, setContactNumber] = useState("");
  const [id, setId] = useState(0);
  const [managerName, setManagerName] = useState("");
  const [restaurentName, setRestaurentName] = useState("");
  const [restaurentAddress, setRestaurentAddress] = useState(0);
  const restid = window.location.pathname.split("/")[2];

  console.log(restid);
  useEffect(() => {
    axios
      .get("http://localhost:8080/Restaurent/getRestaurentById/" + restid)
      .then(
        (resp) => {
          console.log(resp.data);
          setContactNumber(resp.data.contactNumber);
          setId(resp.data.id);
          setManagerName(resp.data.managerName);
          setRestaurentName(resp.data.restaurentName);
          setRestaurentAddress(resp.data.restaurentAddress);
        }
      )
    
  }, []);
  const saveOrder = () => {
    const result = {
      id: id,
      restaurentName: restaurentName,
      restaurentAddress: restaurentAddress,
      managerName: managerName,
      contactNumber: contactNumber,
    };
    console.log(result);
    axios
      .put("http://localhost:8080/Restaurent/updateRestaurent/", result)
      .then(() => alert("Restaurent is updated with id: " + restid));
  };

  return (
    <div className="container card mb-4">
      <div className="card-header py-3">
        <h5 className="mb-0">Update Resturent</h5>
      </div>
      <div className="card-body">
        <form>
          <div className="row mb-4"></div>
          <div className="form-outline mb-4">
            <input
              type="text"
              id="form7Example4"
              className="form-control"
              value={restaurentName}
              onChange={(e) => setRestaurentName(e.target.value)}
            />
          </div>

          <div className="form-outline mb-4">
            <input
              type="text"
              id="form7Example5"
              className="form-control"
              placeholder="Address"
              value={restaurentAddress}
              onChange={(e) => setRestaurentAddress(e.target.value)}
            />
          </div>

          <div className="form-outline mb-4">
            <input
              type="text"
              id="form7Example6"
              className="form-control"
              placeholder="Manager Name"
              value={managerName}
              onChange={(e) => setManagerName(e.target.value)}
            />
          </div>
          <div className="form-outline mb-4">
            <input
              type="number"
              id="form7Example6"
              className="form-control"
              placeholder="Contact Number"
              value={contactNumber}
              onChange={(e) => setContactNumber(e.target.value)}
            />
          </div>

          <button
            type="button"
            className="btn btn-primary btn-lg btn-block"
            onClick={saveOrder}
          >
            Update
          </button>
        </form>
      </div>
    </div>
  );
}

export default UpdateRestaurent;
