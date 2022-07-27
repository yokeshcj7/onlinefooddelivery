import React from "react";
import { getUserInfo, removeUserInfo } from "./../../Utils/UserInfo";
import { Link } from "react-router-dom";
export default function Navbar() {
  const customerId = getUserInfo().customerId;
  const role = getUserInfo()?.role || "";
  const isAdmin = role === "admin";
  console.log(isAdmin);

  const logOut = () => {
    removeUserInfo();
  };
  return (
    <nav className="navbar navbar-expand-lg bg-light">
      <div className="container-fluid">
        <Link className="navbar-brand" to="home">
          OFD
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavDropdown"
          aria-controls="navbarNavDropdown"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavDropdown">
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-link active" aria-current="page" to="home/">
                Home
              </Link>
            </li>

            {/* If UserRole is Admin */}

            {isAdmin ? (
              <li className="nav-item dropdown">
                <Link
                  className="nav-link dropdown-toggle"
                  to="items"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Items
                </Link>
                <ul className="dropdown-menu">
                  <li>
                    <Link className="dropdown-item" to="items">
                      Items
                    </Link>
                  </li>
                  <li>
                    <Link className="dropdown-item" to="adminItems">
                      adminItems
                    </Link>
                  </li>
                  <li>
                    <Link className="dropdown-item" to="addItems">
                      addItems
                    </Link>
                  </li>
                </ul>
              </li>
            ) : (
              <li className="nav-item">
                <Link className="nav-link" to="items">
                  Items
                </Link>
              </li>
            )}
            {/* End of If UserRole is Admin */}

            <li className="nav-item">
              <Link
                className="nav-link active"
                aria-current="page"
                to="foodcart"
              >
                Foodcart
              </Link>
            </li>

            <li className="nav-item">
              <Link
                className="nav-link active"
                aria-current="page"
                to="viewByCustomer"
              >
                Orders
              </Link>
            </li>

            {/* Category Start */}

            {isAdmin ? (
              <li className="nav-item dropdown">
                <Link
                  className="nav-link dropdown-toggle"
                  to="items"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Category
                </Link>
                <ul className="dropdown-menu">
                  <li>

                    <Link className="dropdown-item" to="addCategory">
                      Add Category
                    </Link>
                  </li>
                  <li>
                    <Link className="dropdown-item" to="viewAllCategory">
                      View All Category
                    </Link>
                  </li>
                </ul>
              </li>
            ) : (
              <li className="nav-item"></li>
            )}
            {/* Category End */}

            {/* Customer Start */}

            {isAdmin ? (
              <li className="nav-item dropdown">
                <Link
                  className="nav-link dropdown-toggle"
                  to="items"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Customer
                </Link>
                <ul className="dropdown-menu">
                  <li>
                    <Link className="dropdown-item" to="listOfCustomers">
                      View All Customer
                    </Link>
                  </li>
                </ul>
              </li>
            ) : (
              <li className="nav-item">
                <Link className="nav-link" to={"getCustomerById/"+customerId}>
                  Profile
                </Link>
              </li>
            )}

            {/* Customer End */}

            {/* Restaurent */}
            {isAdmin ? (
              <li className="nav-item dropdown">
                <Link
                  className="nav-link dropdown-toggle"
                  to="viewResturent"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Restaurent
                </Link>
                <ul className="dropdown-menu">
                  <li>
                    <Link className="dropdown-item" to="viewResturent">
                      View All Restaurent
                    </Link>
                  </li>
                  <li>
                    <Link className="dropdown-item" to="addRestaurent">
                      Add Restaurent
                    </Link>
                  </li>
                </ul>
              </li>
            ) : (
              <li className="nav-item">
              
              </li>
            )}
            {/* Restaurent End */}

            <li className="nav-item">
              <Link
                className="nav-link active"
                aria-current="page"
                onClick={logOut}
                to="/"
              >
                logout
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}
