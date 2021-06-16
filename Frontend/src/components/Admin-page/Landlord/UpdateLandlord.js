// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function UpdateLandlord() {

   return (
      <React.Fragment>
        
       <form id = "" className="c2 booking-form updatelandlordform">
        <h1 className="form-text">Update Landlord</h1><br/>
        <input name="landlordname" type="text" placeholder="Landlord ID" className="col-md-4 address-tags"/><br/>
        <input name="landlordname" type="text" placeholder="Landlord Name" className="col-md-4 address-tags"/>
        <input name="landlordage" type="number" placeholder="Landlord Age" min="18" className="col-md-3 address-tags"/>

        <div className="col-md-12 text-center"> 
          <button id="singlebutton" name="singlebutton" className="btn btn-info">View Flat List</button> 
        </div>
        
        <button className="btn">Update All</button>
     </form>
<br/><br/>

     <table className="table table-data table-striped table-bordered view-table updatelandlordtable">
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

export default UpdateLandlord;