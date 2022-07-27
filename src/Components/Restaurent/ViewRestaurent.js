import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import "./css/view.css";

function ViewResturent() {
  const [restaurentDetails, setRestaurentDetails] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/Restaurent/getAllRestaurents")
      .then((resp) => setRestaurentDetails(resp.data));
  },[]);
  const cancel = (id1) => {
    const next = [...restaurentDetails];
    axios
      .delete("http://localhost:8080/Restaurent/deleteRestaurent/" + id1)
      .then(
        (resp) => {
          console.log(resp.data);
          alert("Restaurent is deleted with id: " + id1);
        }
      );
    setRestaurentDetails(next);
  };

  return (
    <div className="container card mb-4">
      <div className="card-header py-3">
        <h5 className="mb-0">View Restaurent</h5>
      </div>
      <div className="row">
        <div className="col-lg-12">
          <div className="main-box clearfix">
            <div className="table-responsive">
              <table className="table user-list">
                <thead>
                  <tr>
                    <th>
                      <span>Id</span>
                    </th>
                    <th>
                      <span>Name</span>
                    </th>
                    <th>
                      <span>Address</span>
                    </th>
                    <th className="text-center">
                      <span>Manager Name</span>
                    </th>
                    <th>
                      <span>Phone Number</span>
                    </th>
                    <th>&nbsp;</th>
                  </tr>
                </thead>
                <tbody>
                  {restaurentDetails.map((p) => (
                    <tr key={p.id}>
                      <td>
                        <span>{p.id}</span>
                      </td>
                      <td>
                        <span>{p.restaurentName}</span>
                      </td>
                      <td className="Address">
                        <span>{p.restaurentAddress} </span>
                      </td>
                      <td className="text-center">
                        <span className="label label-default">
                          {p.managerName}
                        </span>
                      </td>
                      <td>
                        <span>{p.contactNumber}</span>
                      </td>
                      <td style={{ width: "20%" }}>
                        <a href="#" className="table-link">
                          <span className="fa-stack">
                            {/* <i className="fa fa-square fa-stack-2x" />
                            <i className="fa fa-pencil fa-stack-1x fa-inverse" /> */}
                            <Link to={"../updateRestaurent/" + p.id}>
                              <button className="btn btn-secondary">
                                Edit
                              </button>
                            </Link>
                          </span>
                        </a>
                      
                          <span className="fa-stack">
                            {/* <i className="fa fa-square fa-stack-2x" />
                            <i className="fa fa-trash-o fa-stack-1x fa-inverse" /> */}
                            <button
                              onClick={() => cancel(p.id)}
                              className="btn btn-danger"
                            >
                              Delete
                            </button>
                          </span>
                        {/* </a> */}
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ViewResturent;
