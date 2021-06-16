// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';


function ViewFlat() {

   return (
      <React.Fragment>
        
        <form className="view-form">
    <h1 className="form-text ">View Flat By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="Flat ID*" className="username"/>
    <br/>
    <button className="btn">View Flat</button>
   </form>
   

 <table className="table table-data table-striped table-bordered view-table">
    <thead>
        <tr className="table-warning">
          <th className="col-md-1">Flat ID</th>
          <th className="col-md-2">Flat Cost</th>
          <th className="col-md-5">Flat Address</th>
          <th className="col-md-1">Flat Availability</th>
          <th className="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td className="col-md-1">Rohit</td>
          <td className="col-md-2">2000</td>
          <td className="col-md-5">Newadsdasd</td>
          <td className="col-md-1">Yes</td>
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

export default ViewFlat;