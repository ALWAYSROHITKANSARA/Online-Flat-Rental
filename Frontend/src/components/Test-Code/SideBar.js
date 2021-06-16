import React from 'react';
import {Link} from 'react-router-dom';



const SideBar = ()=>{
    return (
        <React.Fragment>
          <nav class="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <a class="navbar-brand navbar-brand-margin">Admin Panel</a>
        <span class="header-right">Flat Rental Application</span>
        <form class="form-inline">
          <button class="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit">Logout</button>
        </form>
      </nav>

      <div class="sidenav col-md-2">
        
        <button class="dropdown-btn">Users
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
          <a href="#">Add User</a>
          <a href="#">Update User</a>
          <a href="#">Update Password</a>
          <a href="#">Remove User</a>
          <a href="#">View User By ID</a>
          <a href="#">View All User</a>
        </div>
        
        <button class="dropdown-btn">Landlord 
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
          <a href="#">Update Landlord</a>
          <a href="#">View Landlord By ID</a>
          <a href="#">View All Landlord</a>
        </div>

        <button class="dropdown-btn">Tenant
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
          <a href="#">Update Tenant</a>
          <a href="#">View Tenant By ID</a>
          <a href="#">View All Tenant</a>
        </div>

        <button class="dropdown-btn">Booking
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
          <a href="#">Add Booking</a>
          <a href="#">Update Booking</a>
          <a href="#">Delete Booking</a>
          <a href="#">View Booking By ID</a>
          <a href="#">View All Bookings</a>
        </div>

        <button class="dropdown-btn">Flat
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
          <a href="#">Add Flat</a>
          <a href="#">Update Flat</a>
          <a href="#">Delete Flat</a>
          <a href="#">View Flat By ID</a>
          <a href="#">View All Flat</a>
        </div>
      </div>
      <div class="content-area col-md-10">
      

       
       
    
     <table class="table table-data table-striped table-bordered view-table">
        <thead>
            <tr class="table-active">
              <th class="col-md-1">Flat ID</th>
              <th class="col-md-2">Flat Cost</th>
              <th class="col-md-5">Flat Address</th>
              <th class="col-md-1">Flat Availability</th>
              <th class="col-md-3">Actions</th>
            </tr>
          </thead>
          <tbody class="table-success ">
            <tr>
              <td class="col-md-1">Rohit</td>
              <td class="col-md-2">2000</td>
              <td class="col-md-5">Newadsdasd</td>
              <td class="col-md-1">Yes</td>
              <td class="col-md-3">
                <button class="btn btn-warning logout-btn" type="submit">Update</button>
                <button class="btn btn-danger logout-btn" type="submit">Delete</button>
              </td>
            </tr>
          
           
          </tbody>
          </table>




       </div>
<script src="dropdown-script.js"></script>

        
        
        
        
        
        
        
        
        </React.Fragment>
    );
}

export default SideBar;