import { React, useState, useEffect } from "react";
import axios from "axios";
import {
  BASE_URL,
  GET_ITEM_DETAILS_BY_RESTAURANT_ITEM_ID_ENDPOINT,
  DELETE_ITEM_FROM_CART_ENDPOINT,
  INCREASE_ITEM_QUANTITY_ENDPOINT,
  DECREASE_ITEM_QUANTITY_ENDPOINT,
} from "../../Constants/apiEndpoints";
import { getUserInfo } from "./../../Utils/UserInfo";
import { IconButton } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";

const initialData = {
  itemName: "",
  category: "",
  restaurentName: "",
};

export default function CartItem(props) {
  const [data, setData] = useState(initialData);

  const customerId = getUserInfo().customerId;

  useEffect(() => {
    axios
      .get(
        BASE_URL +
          GET_ITEM_DETAILS_BY_RESTAURANT_ITEM_ID_ENDPOINT +
          props.restItemId
      )
      .then((response) => {
        //Destructure previous state data then overwrite with new data{itemName}
        setData(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [props.restItemId]);

  // Handle Incrrese Quantity
  const handleIncreaseQuantity = () => {
    axios
      .put(
        BASE_URL +
          INCREASE_ITEM_QUANTITY_ENDPOINT +
          customerId +
          "/" +
          props.restItemId
      )
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  // Handle Reduce Quantity
  const handleReduceQuantity = () => {
    axios
      .put(
        BASE_URL +
          DECREASE_ITEM_QUANTITY_ENDPOINT +
          customerId +
          "/" +
          props.restItemId
      )
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  // Handle Delete Item from Cart
  const handleDelete = () => {
    console.log("Delete clicked");
    axios
      .delete(
        BASE_URL +
          DELETE_ITEM_FROM_CART_ENDPOINT +
          customerId +
          "/" +
          props.restItemId
      )
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="d-flex flex-row justify-content-between align-items-center p-2 bg-white mt-4 px-3 rounded">
      <div className="d-flex flex-column align-items-center product-details">
        <span className="font-weight-bold">{data.itemName}</span>
      </div>
      <div className="d-flex flex-column align-items-center product-details">
        <span className="font-weight-bold text-grey">{data.category}</span>
      </div>
      <div className="d-flex flex-column align-items-center product-details">
        <span className="font-weight-bold text-grey">
          {data.restaurentName}
        </span>
      </div>
      <div className="d-flex flex-row align-items-center qty">
        <IconButton color="error" onClick={handleReduceQuantity}>
          <RemoveIcon />
        </IconButton>
        <h5 className="mt-1 mr-2 ml-2">{props.quantity}</h5>
        <IconButton color="success" onClick={handleIncreaseQuantity}>
          <AddIcon />
        </IconButton>
      </div>
      <div>
        <h5 className="text-grey">$ {props.totalAmount}</h5>
      </div>
      <div className="d-flex align-items-center">
        <IconButton color="error" value={props.id} onClick={handleDelete}>
          <DeleteIcon />
        </IconButton>
      </div>
    </div>
  );
}
