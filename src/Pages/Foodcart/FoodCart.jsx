import { React, useState, useEffect } from "react";
import axios from "axios";
import {
  BASE_URL,
  CLEAR_FOOD_CART_ENDPOINT,
  GET_FOOD_CART_ENDPOINT,
} from "../../Constants/apiEndpoints";
import { getUserInfo } from "./../../Utils/UserInfo";
import "./css/FoodCart.css";
import CartItem from "../../Components/Foodcart/CartItem";

export default function FoodCart() {
  const [cart, setCart] = useState({});
  const customerId = getUserInfo().customerId;
  const [orderId, setOrderId] = useState();

  useEffect(() => {
    axios
      .get(BASE_URL + GET_FOOD_CART_ENDPOINT + customerId)
      .then((response) => {
        setCart(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [customerId]);

  console.log(cart);

  // function to add data in order
  const addOrder = () => {
    const newOrder = {
      customerId: customerId,
      status: "pending",
      orderAmount: cart.cartTotal,
    };
    axios
      .post(BASE_URL + "orderDetails/addOrder", newOrder)
      .then((response) => {
        setOrderId(response.data.id);
        console.log(orderId);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  useEffect(() => {
    if (orderId) {
      (async () => {
        // add order details
        const orderDetails = {
          id: orderId,
          customerId: customerId,
          status: "pending",
          orderAmount: cart.totalAmount,

          orderItems: cart.foodCartItems.map((item) => {
            return {
              orderId: orderId,
              restaurentId: item.restItemId,
              itemId: item.restItemId,
              itemName: item.quantity,
              ammount: item.totalAmount,
            };
          }),
        };
        console.log(orderDetails);
        await axios
          .post(BASE_URL + "orderDetails/addOrderItems", orderDetails)
          .then((response) => {
            console.log(response.data);
          })
          .catch((error) => {
            console.log(error);
          });

        // clear food cart
        // clear cart
        await axios
          .get(BASE_URL + CLEAR_FOOD_CART_ENDPOINT + customerId)
          .then((response) => {
            console.log(response.data);
          })
          .catch((error) => {
            console.log(error);
          });
        alert("Order Placed Successfully");
        
      })();
    }
  }, [orderId, customerId, cart]);

  return (
    <div className="container mt-5 mb-5">
      <div className="d-flex justify-content-center row">
        <div className="col-md-8">
          <div className="p-2">
            <h4>Food cart</h4>
          </div>
          {/* Cart Item Loop Start */}
          {cart?.foodCartItems &&
            cart.foodCartItems.map((item) => (
              <CartItem
                key={item.id}
                id={item.id}
                restItemId={item.restItemId}
                quantity={item.quantity}
                totalAmount={item.totalAmount}
              />
            ))}
          {/* Cart Item Loop End */}
          <div className="d-flex mt-4 px-3 rounded">
            <div className="col-md-6">
              <div className="p-2">
                <h5>Total</h5>

                <h5 className="text-grey">$ {cart.cartTotal}</h5>
              </div>
            </div>
            <div className="col-md-6">
              <div className="p-2 text-right">
                <button className="btn btn-primary" onClick={addOrder}>
                  Checkout
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
