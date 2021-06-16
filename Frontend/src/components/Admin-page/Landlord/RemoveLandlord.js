// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveLandlord() {

   return (
      <React.Fragment>
        <form className="c2">
            <h1 className="form-text ">Remove Landlord By ID</h1>
            <br/>
            <input name="tenentid" type="number" placeholder="Tenant ID*" className="username"/>
            <br/><br/>
            <label for="" className="lable-tag col-md-3">Landlord Name: Rohit</label>
            <button className="btn btn-info logout-btn" type="submit">View Flat List</button>
            
            <label for="" className="lable-tag col-md-4">Landlord Age: 24</label>
            
           

            <br/><br/><br/>
            <button className="btn">Remove Landlord</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveLandlord;