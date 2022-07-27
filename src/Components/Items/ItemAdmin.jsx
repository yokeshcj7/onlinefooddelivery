import { React, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import {
  BASE_URL,
  DELETE_ITEM_ENDPOINT,
  GET_ITEM_DETAILS_BY_ITEM_ID_ENDPOINT,
} from "../../Constants/apiEndpoints";
import { IconButton } from "@mui/material";
import EditIcon from "@mui/icons-material/Edit";
import DeleteForeverIcon from "@mui/icons-material/DeleteForever";

export default function ItemAdmin(props) {
  const navigate = useNavigate();

  const [itemDetails, setItemDetails] = useState({});

  useEffect(() => {
    axios
      .get(BASE_URL + GET_ITEM_DETAILS_BY_ITEM_ID_ENDPOINT + props.itemId)
      .then((response) => {
        setItemDetails(response.data);
        console.log(response.data);
      });
  }, [props.itemId]);

  // Delete item Function
  const deleteItem = () => {
    // Confirm delete
    console.log("Delete item called");
    if (window.confirm("Are you sure you want to delete this item?")) {
      // Delete item
      console.log("Delete item");
      console.log(props.itemId);
      axios
        .delete(BASE_URL + DELETE_ITEM_ENDPOINT + props.itemId)
        .then((response) => {
          console.log(response.data);
          alert("Item deleted");
        })
        .catch((error) => {
          console.log(error);
          alert("Error deleting item");
        });
    }
  };

  // Edit item Function
  const handleEditItem = () => {
    console.log("Edit item called");
    navigate("/updateItem/" + props.itemId);
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
        <p className="table-link update">
          <IconButton
            className="fa-stack"
            color="primary"
            onClick={handleEditItem}
          >
            <EditIcon />
          </IconButton>
        </p>
        <p className="table-link danger">
          <IconButton
            className="fa-stack"
            color="error"
            value={props.Item}
            onClick={deleteItem}
          >
            <DeleteForeverIcon />
          </IconButton>
        </p>
        <div className="clear"></div>
      </td>
    </tr>
  );
}
