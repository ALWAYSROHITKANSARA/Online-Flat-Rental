import React from 'react'
import { Link } from 'react-router-dom'
function Menu() {
    return (
      
  <nav className="navbar navbar-expand-lg navbar-dark " style={{backgroundImage: "linear-gradient(15deg, #5680e9 0%, #5ab9ea 100%)"}}>
  
  <div className="container-fluid">
    <Link className="navbar-brand text-uppercase" aria-current="page" to="">Landlord Services</Link>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
          <Link className="nav-link" aria-current="page" to="/landlord">Home</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link" to="info">Profile</Link>
        </li>
        <li className="nav-item dropdown">
          <a className="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Flat Services
          </a>
          <ul style={{backgroundColor: "#5ab9ea"}} className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><Link style={{ fontWeight: "bold"}} className="dropdown-item" to="addFlat">Add Flat</Link></li>
            <li><Link style={{ fontWeight: "bold"}} className="dropdown-item" to="allFlat">Flat List</Link></li>
            <li><Link style={{ fontWeight: "bold"}} className="dropdown-item" to="flatbyid">Flat By ID</Link></li>
            <li><Link style={{ fontWeight: "bold"}} className="dropdown-item" to="updateFlat">Update Flat</Link></li>
          </ul>
        </li>  
      </ul>  
      <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
    </div>
  </div>
</nav>
        
    )
}

export default Menu
