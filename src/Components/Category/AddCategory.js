import axios from "axios";
import React, { useState } from "react";
function AddCategory() {
  const [categoryName, setCategoryName] = useState("");

  const handleSubmit = () => {
    const payload = {
      //   "id"  : categoryName.length,
      name: categoryName,
    };
    axios
      .post("http://localhost:8080/category/addCategory", payload)
      .then((resp) => resp.data.id)
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <div>
      <h3 className="text-center ">Please! add a Category Name</h3>
      <div>
        <label className="text-center ">Category Name</label>
        <input
          type="text"
          id="categoryName"
          name="categoryName"
          value={categoryName}
          onChange={(e) => setCategoryName(e.target.value)}
        ></input>
      </div>
      <div>
        <button
          type="button"
          className="btn btn-outline-dark"
          onClick={handleSubmit}
        >
          Add
        </button>
      </div>
    </div>
  );
}
export default AddCategory;
