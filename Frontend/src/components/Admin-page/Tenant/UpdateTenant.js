// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function UpdateTenant() {

   return (
      <React.Fragment>
        <form id = "update-landlord" class="c2 ">
            <h1 class="form-text">Update Tenant</h1><br/><br/><br/>
            <input name="tenantid" type="text" placeholder="Tenant ID" class="col-md-4 address-tags"/><br/>
            <input name="tenantname" type="text" placeholder="Tenant Name" class="col-md-4 address-tags"/>
            <input name="tenantage" type="number" placeholder="Tenant Age" min="18" class="col-md-3 address-tags"/>

            <div class="col-md-12 text-center"> 
            <button id="singlebutton" name="singlebutton" class="btn btn-info">View Flat</button> 
            </div>
    
    <button class="btn">Update All</button>
 </form>

    </React.Fragment>
    );
}

export default UpdateTenant;