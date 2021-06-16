// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function AddFlat() {

  return (
      <React.Fragment>
        <form className="c2">
                <h1 className="form-text ">Add Flat</h1>
           
                <input name="flatcost" type="number" placeholder="Flat Cost" min = "1000" className="username col-md-4"/>
                
                <label className="lable-tag">Address</label>

                <input name="houseNumber" type="number" placeholder="House Number" className="col-md-3 address-tags"/>
         
                <input name="street" type="text" placeholder="Street" className="address-tags col-md-8"/>
                <input name="city" type="text" placeholder="City" className="col-md-4 address-tags"/>
                <input name="state" type="text" placeholder="State" className="col-md-4 address-tags"/>
                <input name="country" type="text" placeholder="Country" className="col-md-4 address-tags"/>
                <input type="text" name="pincode" placeholder="Pin Code" pattern="[0-9]{6}" maxlength="6" className="col-md-4 address-tags"/>
            <br/><br/>
                <button className="btn">Add Flat</button>
            </form>

    
     </React.Fragment>
    );
}

export default AddFlat;