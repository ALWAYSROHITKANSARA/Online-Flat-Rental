import React,{useState} from 'react';
import './admin.css';
import { Link } from 'react-router-dom';
import './dropdown-script';
import 'bootstrap/dist/css/bootstrap.min.css';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown'
import {Nav,  Navbar, NavDropdown } from 'react-bootstrap';


function AdminPageDemo(props) {

    



    return (
        <React.Fragment>
        <form className="c2">
    <h1 className="form-text ">SIGN UP</h1>
    <br/><br/><br/><br/>
       <input name="username" type="text" placeholder="Username*" className="username"/>
       <br/>
       <input name="password" type="password" placeholder="Password*" className="username"/>
       <br/>
       <select name="usertype" className="username">
         <option value="">Select one option</option>
         <option value="landlord">Landlord</option>
         <option value="tenant">Tenant</option>
       </select>
    <br/>
    <button className="btn">Add User</button>
        </form>
     </React.Fragment>
    );
}

export default AdminPageDemo;