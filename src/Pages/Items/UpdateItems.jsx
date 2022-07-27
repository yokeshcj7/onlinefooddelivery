import { React, useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {
  BASE_URL,
  GET_ITEM_BY_ID_ENDPOINT,
  UPDATE_ITEM_ENDPOINT,
  GET_ALL_CATEGORIES_ENDPOINT,
  GET_ALL_RESTAURANTS_ENDPOINT,
} from "../../Constants/apiEndpoints";
import "./css/Items.css";
import TextField from "@mui/material/TextField";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import Button from "@mui/material/Button";
import FoodBankTwoToneIcon from "@mui/icons-material/FoodBankTwoTone";

import Select from "@mui/material/Select";

const data = {
  itemId:0,
  name: "",
  cost: 0.0,
  categoryId: 0,
  restaurentId: 0,
};



export default function UpdateItems() {
  // Hook for Form Data
  const [formData, setFormData] = useState(data);

  const navigate = useNavigate();

  // Function to handle change in form
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Category API call
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    console.log("Fetching Categories");
    axios.get(BASE_URL + GET_ALL_CATEGORIES_ENDPOINT).then((response) => {
      setCategories(response.data);
    });
  }, []);

  // Restaurant API call
  const [restaurants, setRestaurants] = useState([]);

  useEffect(() => {
    console.log("Restaurant API call");
    axios.get(BASE_URL + GET_ALL_RESTAURANTS_ENDPOINT).then((response) => {
      console.log(response.data);
      setRestaurants(response.data);
    });
  }, []);


  useEffect(() => {
    console.log("Fetching Item");
    // fetch id from url
    const id = window.location.pathname.split("/")[2];
    axios.get(BASE_URL + GET_ITEM_BY_ID_ENDPOINT+id).then((response) => {
      formData.itemId = response.data.itemId;
      formData.name = response.data.name;
      formData.cost = response.data.cost;
      formData.restaurentId = response.data.restaurentId;
      formData.categoryId = response.data.categoryId;
    }
    );
  }, [formData]);

  // Update Item API call
  const updateItem = async () => {
    try {
      const response = await axios.post(
        BASE_URL + UPDATE_ITEM_ENDPOINT,
        formData
      );
      console.log(response);
      alert("Item Updated Successfully");
      navigate("/adminItems");
    } catch (error) {
      console.log(error);
    }
  }



  return (
    <div class="container-fluid px-1 py-5 mx-auto body">
      <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
          <div class="card">
            <h2 class="text-center mb-4">Update Item</h2>
            <form class="form-card">
              <div class="row justify-content-between text-left">
                <div class="form-group col-sm-6 flex-column d-flex my-5">
                  <TextField
                    id="item-name"
                    label="Item Name"
                    variant="standard"
                    className="w-100"
                    required="true"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                  />
                </div>
                <div class="form-group col-sm-6 flex-column d-flex my-5">
                  <TextField
                    id="item-price"
                    label="Item Price"
                    variant="standard"
                    className="w-100"
                    required="true"
                    name="cost"
                    value={formData.cost}
                    onChange={handleChange}
                    inputProps={{
                      inputMode: "numeric",
                      pattern: "^[0-9]+.?[0-9]*$",
                    }}
                  />
                </div>
              </div>
              <div class="row justify-content-between text-left my-5">
                <div class="form-group col-sm-6 flex-column d-flex">
                  <InputLabel id="item-category-label">Category</InputLabel>
                  <Select
                    labelId="item-category-label"
                    id="item-category"
                    name="categoryId"
                    value={formData.categoryId}
                    onChange={handleChange}
                  >
                    {categories.map((cat) => (
                      <MenuItem key={cat.id} value={cat.id}>
                        {cat.name}
                      </MenuItem>
                    ))}
                  </Select>
                </div>
                <div class="form-group col-sm-6 flex-column d-flex">
                  <InputLabel id="item-restaurent-label">Restaurent</InputLabel>
                  <Select
                    labelId="item-restaurent-label"
                    id="item-restaurent"
                    name="restaurentId"
                    value={formData.restaurentId}
                    onChange={handleChange}
                  >
                    {restaurants.map((res) => (
                      <MenuItem key={res.id} value={res.id}>
                        {res.restaurentName}
                      </MenuItem>
                    ))}
                  </Select>
                </div>
              </div>

              <div class="row justify-content-end">
                <div class="form-group col-sm-6">
                  <Button
                    variant="contained"
                    startIcon={<FoodBankTwoToneIcon />}
                    onClick={updateItem}
                  >
                    Update
                  </Button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
