import React, { useState } from "react";
import axios from "axios";

function AddRestaurent() {
  const [id, setId] = useState(0);
  const [restaurentName, setRestaurentName] = useState("");
  const [restaurentAddress, setRestaurentAddress] = useState("");
  const [managerName, setManagerName] = useState("");
  const [contactNumber, setContactNumber] = useState("");

  const saveOrder = () => {
    const result = {       
      restaurentId: id,
      restaurentName: restaurentName,
      restaurentAddress: restaurentAddress,
      managerName: managerName,
      contactNumber: contactNumber,
    };
    axios
      .post("http://localhost:8080/Restaurent/addRestaurent", result)
      .then((resp) => alert("Restaurent is added with id: " + resp.data.id));
  };

  return (
   
          <div class="container card mb-4">
            <div class="card-header py-3">
              <h5 class="mb-0">Add Restaurent</h5>
            </div>
            <div class="card-body">
              <form>
                {/* <div class="row mb-4">
                  <div class="form-outline">
                    <input
                      type="text"
                      id="form7Example1"
                      class="form-control"
                      placeholder="Restaurent Id"
                      value={id}
                      onChange={(e) => setId(e.target.value)}
                    />
                  </div>
                </div> */}
                <div class="form-outline mb-4">
                  <input

                    type="text"
                    id="form7Example4"
                    class="form-control"
                    placeholder="Restaurent Name"
                    value={restaurentName}
                    onChange={(e) => setRestaurentName(e.target.value)}
                  />
                </div>

                <div class="form-outline mb-4">
                  <input
                    type="email"
                    id="form7Example5"
                    class="form-control"
                    placeholder="Address"
                    value={restaurentAddress}
                    onChange={(e) => setRestaurentAddress(e.target.value)}
                  />
                </div>

                <div class="form-outline mb-4">
                  <input
                    type="text"
                    id="form7Example6"
                    class="form-control"
                    placeholder="Manager Name"
                    value={managerName}
                    onChange={(e) => setManagerName(e.target.value)}
                  />
                </div>
                <div class="form-outline mb-4">
                  <input
                    type="number"
                    id="form7Example6"
                    class="form-control"
                    placeholder="Contact Number"
                    value={contactNumber}
                    onChange={(e) => setContactNumber(e.target.value)}
                  />
                </div>

                <button
                  type="button"
                  class="btn btn-primary btn-lg btn-block"
                  onClick={saveOrder}
                >
                  Add
                </button>
              </form>
            </div>
          </div>
     
  );
}

export default AddRestaurent;
