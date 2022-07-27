import { React,useEffect,useState } from "react";
import axios from "axios";
import {
  BASE_URL,
  ADD_ITEM_TO_CART_ENDPOINT,
  GET_ITEM_DETAILS_BY_ITEM_ID_ENDPOINT,
} from "../../Constants/apiEndpoints";
import { getUserInfo } from "./../../Utils/UserInfo";
import { IconButton } from "@mui/material";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";

export default function Item(props) {
  const customerId = getUserInfo().customerId;
  const data = {
    itemId: props.itemId,
    customerId: customerId,  //Change this to the logged in customer
  };

  const [itemDetails, setItemDetails] = useState({});

  useEffect(() => {
    axios.get(BASE_URL + GET_ITEM_DETAILS_BY_ITEM_ID_ENDPOINT + props.itemId).then((response) => {
      setItemDetails(response.data);
      console.log(response.data);
    }
    );
  }
  , [props.itemId]);


  const addToCart = () => {
    console.log("Add to cart");
    console.log(props.itemId);
    
    axios
      .post(BASE_URL + ADD_ITEM_TO_CART_ENDPOINT,data )
      .then((response) => {
        console.log(response.data);
        alert("Item added to cart");
      })
      .catch((error) => {
        console.log(error);
        alert("Error adding item to cart");
      });
  };

  return (
    <tr>
      <td>
        <p className="user-link">{props.name}</p>
      </td>
      <td>{itemDetails.category}</td>
      <td className="text-center">
        <span className="label label-default">{itemDetails.restaurentName}</span>
      </td>
      <td>
        <p>$ {props.cost}</p>
      </td>
      <td style={{ width: "20%" }}>
        <p className="table-link cart">
          <IconButton
            className="fa-stack"
            value={props.itemId}
            onClick={addToCart}
          >
            <AddShoppingCartIcon />
          </IconButton>
        </p>
        <div className="clear"></div>
      </td>
    </tr>
  );
}
