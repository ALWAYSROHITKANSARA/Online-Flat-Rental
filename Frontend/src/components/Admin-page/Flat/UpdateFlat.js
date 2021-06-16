// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function UpdateFlat() {

  return (
      <React.Fragment>
        
      <form id = "update-landlord" class="c2">
        <h1 class="form-text">Update Landlord</h1>
        <br/><br/>
        <input name="landlordid" type="text" placeholder="Landlord ID" class="col-md-4 address-tags"/>
        <input name="landlordname" type="text" placeholder="Landlord Name" class="col-md-4 address-tags"/>
        <input name="landlordage" type="number" placeholder="Landlord Age" min="18" class="col-md-3 address-tags"/>
            <br/><br/>
        <div class="col-md-12 text-center"> 
          <button id="singlebutton" name="singlebutton" class="btn btn-info">View Flat List</button> 
        </div>
        <br/><br/><br/>
        <button class="btn">Update All</button>
     </form>




    
     </React.Fragment>
    );
}

export default UpdateFlat;