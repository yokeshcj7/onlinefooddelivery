import React from "react";
import "./App.css";
import AddItems from "./Pages/Items/AddItems";
import ItemList from "./Pages/Items/ItemList";
import ItemListAdmin from "./Pages/Items/ItemListAdmin";
import UpdateItems from "./Pages/Items/UpdateItems";
import Navbar from "./Components/NavBar/Navbar";
import FoodCart from "./Pages/Foodcart/FoodCart";
import Home from "./Pages/Home/Home";

import AddOrder from "./Pages/Order/AddOrder";
import ViewByCustomer from "./Pages/Order/ViewByCustomer";
import ViewByOrder from "./Pages/Order/ViewByOrder";
import UpdateOrder from "./Pages/Order/UpdateOrder";

import ViewCategory from "./Components/Category/ViewCategory";
import EditCategory from "./Components/Category/EditCategory";
import AddCategory from "./Components/Category/AddCategory";
import ViewAllCategory from "./Components/Category/ViewAllCategory";

import Login from "./Pages/User/Login";
import Register from "./Components/User/Register";

import GetCustomerById from "./Components/Customer/GetCustomerById";
import ListofCustomers from "./Components/Customer/ListOfCustomers";
import Updatecustomer from "./Components/Customer/UpdateCustomer";


import AddRestaurent from "./Components/Restaurent/AddRestaurent";
import UpdateRestaurent from "./Components/Restaurent/UpdateRestaurent";
import ViewResturent from "./Components/Restaurent/ViewRestaurent";

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { getUserInfo } from "./Utils/UserInfo";

function App() {
  const [isLoggedIn, setIsLoggedIn] = React.useState(false);
  const user = getUserInfo();

  React.useEffect(() => {
    if (user) {
      setIsLoggedIn(true);
    } else {
      setIsLoggedIn(false);
    }
  }, [user]);
  console.log(isLoggedIn);

  return (
    <div className="App">

      <Router>
      {/* If User is present */}
      {isLoggedIn && <Navbar />}
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />

          <Route path="/home" element={<Home />} />

          <Route exact path="/items" element={<ItemList />} />
          <Route path="/foodCart" element={<FoodCart />} />

          <Route path="/adminItems" element={<ItemListAdmin />} />
          <Route path="/addItems" element={<AddItems />} />
          <Route path="/updateItem/:id" element={<UpdateItems />} />

          {/* Category Routes */}
          <Route path="/addCategory" element={<AddCategory />} />
          <Route path="/viewAllCategory" element={<ViewAllCategory />} />
          <Route path="/findCategory/:id" element={<ViewCategory />} />
          <Route path="/editCategory/:id" element={<EditCategory />} />

          {/* Oeder Routes */}
          <Route path="/addOrder" element={<AddOrder />} />
          <Route path="/viewByCustomer" element={<ViewByCustomer />} />
          <Route path="/viewByOrder/:id" element={<ViewByOrder />} />
          <Route path="/updateOrder/:id" element={<UpdateOrder />} />

          {/* Customer Routes */}
          <Route path="/getCustomerById/:id" element={<GetCustomerById />} />
          <Route path="/listOfCustomers" element={<ListofCustomers />} />
          <Route path="/updateCustomer/:id" element={<Updatecustomer />} />

          {/* Restaurent Routes */}
          <Route path="/addRestaurent" element={<AddRestaurent />} />
          <Route path="/updateRestaurent/:id" element={<UpdateRestaurent />} />
          <Route path="/viewResturent" element={<ViewResturent />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
