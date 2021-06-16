// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function AddLandlord() {

  return (
      <React.Fragment>
        <form class="c2">
    <h1 class="form-text">Add Landlord</h1>
    <br/><br/>
    <input name="landlordid" type="number" placeholder="Landlord ID" class="col-md-4 address-tags"/>
    <button className="btn btn-info logout-btn" type="submit">Add Flat</button>

    <input name="landlordname" type="text" placeholder="Landlord Name" class="col-md-4 address-tags"/>
    <input name="landlordeage" type="number" placeholder="Landlord Age" class="col-md-4 address-tags"/>
    <br/><br/><br/><br/>
  
    <button class="btn">Add Landlord</button>
 </form>
    
     </React.Fragment>
    );
}

export default AddLandlord;