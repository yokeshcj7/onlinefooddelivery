import { React, useState, useEffect } from "react";
import axios from "axios";
import {
  BASE_URL,
  ADD_ITEMS_ENDPOINT,
  GET_ALL_CATEGORIES_ENDPOINT,
  GET_ALL_RESTAURANTS_ENDPOINT,
} from "./../../Constants/apiEndpoints";
import "./css/Items.css";
import TextField from "@mui/material/TextField";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import Button from "@mui/material/Button";
import MenuBookIcon from "@mui/icons-material/MenuBook";
import Select from "@mui/material/Select";

const data = {
  name: "",
  cost: 0.0,
  categoryId: 0,
  restaurentId: 0,
};

export default function AddItems() {
  // Utility for Loading screen
  // const [isLoading, setIsLoading] = useState(true);

  // Hook for Form Data
  const [formData, setFormData] = useState(data);

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

  // Add Item API call
  const addItem = async () => {
    try {
      const response = await axios.post(
        BASE_URL + ADD_ITEMS_ENDPOINT,
        formData
      );
      console.log(response);
      alert("Item Added Successfully");
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div class="container-fluid px-1 py-5 mx-auto body">
      <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
          <div class="card">
            <h2 class="text-center mb-4">Add Item</h2>
            <form class="form-card" onSubmit={addItem}>
              <div class="row justify-content-between text-left">
                <div class="form-group col-sm-6 flex-column d-flex my-5">
                  <TextField
                    id="item-name"
                    label="Item Name"
                    variant="standard"
                    className="w-100"
                    required="true"
                    name="name"
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
                    required="true"
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
                    required="true"
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
                  type="submit"
                    variant="contained"
                    startIcon={<MenuBookIcon />}
                  >
                    Add Item
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
