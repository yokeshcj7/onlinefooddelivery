import {React,useState,useEffect} from "react";
import axios from "axios";
import { BASE_URL, GET_ALL_ITEMS_ENDPOINT } from "../../Constants/apiEndpoints";
import "./css/Items.css";
import ItemAdmin from "../../Components/Items/ItemAdmin";

export default function ItemListAdmin() {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    console.log("Fetching Items");
    axios.get(BASE_URL + GET_ALL_ITEMS_ENDPOINT).then((response) => {
      setItems(response.data);
      console.log(response.data);
      setLoading(false);
    });
  }, []);
  return (
    <div className="container my-5">
      {/* Loading If Condition */}
      {loading ? (
        <div className="text-center">
          <div className="spinner-border text-primary" role="status">
            <span className="sr-only"></span>
          </div>
        </div>
      ) : (
        // {/* Loading Else Condition */}
      <div className="row">
        <div className="col-lg-12">
          <div className="main-box clearfix">
            <div className="table-responsive">
              <table className="table user-list">
                <thead>
                  <tr>
                    <th>
                      <span>Product Name</span>
                    </th>
                    <th>
                      <span>Category</span>
                    </th>
                    <th className="text-center">
                      <span>Restaurent</span>
                    </th>
                    <th>
                      <span>Cost</span>
                    </th>
                    <th>&nbsp;</th>
                  </tr>
                </thead>
                <tbody>
                  {/* Looping ItemAdmin Start */}

                  {items.map((item) => (
                    <ItemAdmin
                      key={item.itemId}
                      itemId={item.itemId}
                      name={item.name}
                      category={item.categoryId}
                      restaurant={item.restaurentId}
                      cost = {item.cost}
                    />
                  ))}

                  {/* Loop ItemAdmin End */}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      )}
    </div>
  );
}
