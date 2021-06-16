// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';


function ViewLandlord() {

   return (
      <React.Fragment>
        
        <form className="view-form">
    <h1 className="form-text ">View LandLord By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="User ID*" className="username"/>
    <br/>
    <button className="btn">View Landlord</button>
   </form>
   

 <table className="table table-data table-striped table-bordered view-table">
    <thead>
        <tr className="table-warning">
          <th className="col-md-2">ID</th>
          <th className="col-md-3">Landlord Name</th>
          <th className="col-md-1">Age</th>
          <th className="col-md-3">Flat List</th>
          <th className="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td className="col-md-2">101</td>
          <td className="col-md-3">Rohit</td>
          <td className="col-md-1">24</td>
          <td className="col-md-3">
            <button className="btn btn-info logout-btn" type="submit">Flat List</button>
          </td>
          <td className="col-md-3">
            <button className="btn btn-warning logout-btn" type="submit">Update</button>
            <button className="btn btn-danger logout-btn" type="submit">Delete</button>
          </td>
        </tr>
      
       
      </tbody>

  </table>     


    </React.Fragment>
    );
}

export default ViewLandlord;