import React,{useState} from 'react';
import './admin.css';
import { Link } from 'react-router-dom';
import './dropdown-script';
import 'bootstrap/dist/css/bootstrap.min.css';

import { BrowserRouter as Router, Switch, Route} from "react-router-dom"

import AddUser from '../Users/AddUser';
import ViewAllUser from '../Users/ViewAllUser';
import RemoveUser from '../Users/RemoveUser';
import ViewUser from '../Users/ViewUser';
import UpdateUser from '../Users/UpdateUser';

import UpdateLandlord from '../Landlord/UpdateLandlord';
import ViewLandlord from '../Landlord/ViewLandlord';
import ViewAllLandlord from '../Landlord/ViewAllLandlord';
import RemoveLandlord from '../Landlord/RemoveLandlord';
import AddLandlord from '../Landlord/AddLandlord';


import ViewAllBooking from '../Booking/ViewAllBooking';
import ViewBooking from '../Booking/ViewBooking';
import RemoveBooking from '../Booking/RemoveBooking';
import AddBooking from '../Booking/AddBooking';
import UpdateBooking from '../Booking/UpdateBooking';

import ViewAllTenant from '../Tenant/ViewAllTenant';
import AddTenant from '../Tenant/AddTenant';
import RemoveTenant from '../Tenant/RemoveTenant';
import UpdateTenant from '../Tenant/UpdateTenant';
import ViewTenant from '../Tenant/ViewTenant';

import ViewAllFlat from '../Flat/ViewAllFlat';
import AddFlat from '../Flat/AddFlat';
import ViewFlat from '../Flat/ViewFlat';
import RemoveFlat from '../Flat/RemoveFlat';
import UpdateFlat from '../Flat/UpdateFlat';



function AdminPage(props) {
    const [value,setValue]=useState('');
    const handleSelect=(e)=>{
      console.log(e);
      setValue(e)
    }

function togglebtn(){
      var dropdown = document.getElementsByClassName("dropdown-btn");

      var i;

      for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function() {
          this.classList.toggle("active");
          var dropdownContent = this.nextElementSibling;
          if (dropdownContent.style.display === "block") {
            dropdownContent.style.display = "none";
          } else {
            dropdownContent.style.display = "block";
          }
        });
      }
    }

    



    return (
      
     <React.Fragment>

     <Router>
       <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <Link className="navbar-brand navbar-brand-margin">Admin Panel</Link>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>

      <div className="sidenav col-md-2">
        <button className="dropdown-btn" onClick={togglebtn}>Users
          <i className="fa fa-caret-down"></i>
        </button>
        <div className="dropdown-container">
          <Link to="/admin/user/adduser">Add User</Link>
          <Link to="/admin/user/updateuser">Update User</Link>
          <Link to="/admin/user/removeuser">Remove User</Link>
          <Link to="/admin/user/viewuser">View User By ID</Link>
          <Link to="/admin/user/viewalluser">View All User</Link>
        </div>
        
        <button  className="dropdown-btn" onClick={togglebtn}>Landlord 
          <i className="fa fa-caret-down"></i>
        </button>
        <div className="dropdown-container">
          <Link to="/admin/landlord/addlandlord">Add Landlord</Link>
          <Link to="/admin/landlord/updatelandlord">Update Landlord</Link>
          <Link to="/admin/landlord/removelandlord">Delete Landlord</Link>
          <Link to="/admin/landlord/viewlandlord">View Landlord By ID</Link>
          <Link to="/admin/landlord/viewalllandlord">View All Landlord</Link>
        </div>

        <button  className="dropdown-btn" onClick={togglebtn}>Tenant
          <i className="fa fa-caret-down"></i>
        </button>
        <div  className="dropdown-container">
          <Link to="/admin/tenant/addtenant">Add Tenant</Link>
          <Link to="/admin/tenant/updatetenant">Update Tenant</Link>
          <Link to="/admin/tenant/removetenant">Remove Tenant</Link>
          <Link to="/admin/tenant/viewtenant">View Tenant By ID</Link>
          <Link to="/admin/tenant/viewalltenant">View All Tenant</Link>
        </div>

        <button  className="dropdown-btn" onClick={togglebtn}>Booking
          <i className="fa fa-caret-down"></i>
        </button>
        <div className="dropdown-container">
          <Link to="/admin/booking/addbooking">Add Booking</Link>
          <Link to="/admin/booking/updatebooking">Update Booking</Link>
          <Link to="/admin/booking/deletebooking">Delete Booking</Link>
          <Link to="/admin/booking/viewbooking">View Booking By ID</Link>
          <Link to="/admin/booking/viewallbooking">View All Bookings</Link>
        </div>

        <button  className="dropdown-btn" onClick={togglebtn}>Flat
          <i className="fa fa-caret-down"></i>
        </button>
        <div className="dropdown-container">
          <Link to="/admin/flat/addflat">Add Flat</Link>
          <Link to="/admin/flat/updateflat">Update Flat</Link>
          <Link to="/admin/flat/removeflat">Delete Flat</Link>
          <Link to="/admin/flat/viewflat">View Flat By ID</Link>
          <Link to="/admin/flat/viewallflat">View All Flat</Link>
        </div>
    
  
    
    
      </div>
      <div className="content-area col-md-10">     
      <Switch>
        <Route path="/admin/user/adduser" component = {AddUser}/>
        <Route path="/admin/user/viewalluser" component = {ViewAllUser}/>
        <Route path="/admin/user/removeuser" component = {RemoveUser}/>
        <Route path="/admin/user/updateuser" component = {UpdateUser}/>
        <Route path="/admin/user/viewuser" component = {ViewUser}/>   

        <Route path="/admin/landlord/addlandlord" component = {AddLandlord}/>       
        <Route path="/admin/landlord/removelandlord" component = {RemoveLandlord}/>       
        <Route path="/admin/landlord/updatelandlord" component = {UpdateLandlord}/>        
        <Route path="/admin/landlord/viewlandlord" component = {ViewLandlord}/>        
        <Route path="/admin/landlord/viewAllLandlord" component = {ViewAllLandlord}/>        

        <Route path="/admin/tenant/addtenant" component = {AddTenant}/>        
        <Route path="/admin/tenant/removetenant" component = {RemoveTenant}/>        
        <Route path="/admin/tenant/updatetenant" component = {UpdateTenant}/>        
        <Route path="/admin/tenant/viewtenant" component = {ViewTenant}/>       
        <Route path="/admin/tenant/viewAlltenant" component = {ViewAllTenant}/>         

        <Route path="/admin/booking/addbooking" component = {AddBooking}/>        
        <Route path="/admin/booking/removebooking" component = {RemoveBooking}/>        
        <Route path="/admin/booking/updatebooking" component = {UpdateBooking}/>       
        <Route path="/admin/booking/viewbooking" component = {ViewBooking}/>      
        <Route path="/admin/booking/viewAllbooking" component = {ViewAllBooking}/>         

        <Route path="/admin/flat/addflat" component = {AddFlat}/>        
        <Route path="/admin/flat/removeflat" component = {RemoveFlat}/>        
        <Route path="/admin/flat/updateflat" component = {UpdateFlat}/>        
        <Route path="/admin/flat/viewflat" component = {ViewFlat}/>          
        <Route path="/admin/flat/viewAllflat" component = {ViewAllFlat}/>          

        </Switch>
       </div>
<script src="dropdown-script.js" type="text/javascript"></script>
</Router>
     </React.Fragment>
     
    );
}

export default AdminPage;