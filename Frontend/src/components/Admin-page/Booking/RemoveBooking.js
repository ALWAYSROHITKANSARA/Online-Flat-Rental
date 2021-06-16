// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveBooking() {

   return (
      <React.Fragment>
        <form className="c2">
            <h1 className="form-text ">Remove Booking By ID</h1>
            <br/>
            <input name="tenentid" type="number" placeholder="Booking ID*" className="username"/>
            
            <label for="" className="lable-tag col-md-3">Booking Number: 101</label>
            <label for="" className="lable-tag col-md-3">Flat ID: 201</label>
            <label for="" className="lable-tag col-md-3">Tenant ID: 301</label>
            <label for="" className="lable-tag col-md-3">Booking From: 06/05/2021</label>
            <label for="" className="lable-tag col-md-4">Booking to: 08/10/2021</label>

            <br/>
            <button className="btn">Remove Booking</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveBooking;