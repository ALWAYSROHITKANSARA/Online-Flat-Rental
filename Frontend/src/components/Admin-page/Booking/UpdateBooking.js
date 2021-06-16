// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function UpdateBooking() {

   return (
      <React.Fragment>
        
        <form id = "update-landlord" className="c2">
            <h1 className="form-text">Update Booking</h1><br/>
            <input name="landlordname" type="text" placeholder="Booking ID" className="col-md-4 address-tags"/>
            <input name="tenantid" type="number" placeholder="Tenant ID" className="col-md-4 address-tags"/>
            <input name="flatid" type="number" placeholder="Flat ID" className="col-md-4 address-tags"/>
            <label for="" className="lable-tag col-md-3">From</label>
            <input type="date" value="2017-06-01" className="col-md-4 address-tags"/>
            <label for="" className="lable-tag col-md-3">To</label>
            <input type="date" value="2017-07-01" className="col-md-4 address-tags"/>
            
           

    
    
                <button className="btn">Update All</button>
        </form>


    </React.Fragment>
    );
}

export default UpdateBooking;