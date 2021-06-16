// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';


function ViewBooking() {

   return (
      <React.Fragment>
        
        <form class="view-form">
    <h1 class="form-text ">View Booking By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="Booking Number*" class="username"/>
    <br/>
    <button class="btn">View Booking</button>
   </form>
   

 <table class="table table-data table-striped table-bordered view-table">
    <thead>
        <tr class="table-warning">
          <th class="col-md-1">Booking No.</th>
          <th class="col-md-1">Flat ID</th>
          <th class="col-md-1">Tenant ID</th>
          <th class="col-md-2">Booking From</th>
          <th class="col-md-2">Booking From</th>
          <th class="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody class="table-success ">
        <tr>
          <td class="col-md-1">101</td>
          <td class="col-md-1">202</td>
          <td class="col-md-1">501</td>
          <td class="col-md-2">22/01/2020</td>
          <td class="col-md-2">22/01/2021</td>
          <td class="col-md-3">
            <button class="btn btn-warning logout-btn" type="submit">Update</button>
            <button class="btn btn-danger logout-btn" type="submit">Delete</button>
          </td>
        </tr>
      
       
      </tbody>

</table>    


    </React.Fragment>
    );
}

export default ViewBooking;