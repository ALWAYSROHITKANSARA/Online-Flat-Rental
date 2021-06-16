// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllTenant() {

    let initialCustomers=[];
    let [tenents,setTenants]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/tenant/viewAllTenant';
        axios.get(URL).then((response) => {
            setTenants(response.data);
        })
        .catch((error) => console.log(error));
    },[]);

    function goToAddCustomer(){
        //props.history.push('/addCustomer');
    }


  return (
      <React.Fragment>
            <table class="table table-data table-striped table-bordered">
    <thead>
        <tr class="table-warning">
          <th class="col-md-2">ID</th>
          <th class="col-md-3">Tenant Name</th>
          <th class="col-md-1">Age</th>
          <th class="col-md-3">Flat List</th>
          <th class="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody class="table-success ">
      {
                tenents.map (
                    tenant =>
        <tr>
          <td class="col-md-2">{tenant.tenantId}</td>
          <td class="col-md-3">{tenant.tenantName}</td>
          <td class="col-md-1">{tenant.age}</td>
          <td class="col-md-3">
            <button class="btn btn-info logout-btn" type="submit">Flat List</button>
          </td>
          <td class="col-md-3">
            <button class="btn btn-warning logout-btn" type="submit">Update</button>
            <button class="btn btn-danger logout-btn" type="submit">Delete</button>
          </td>
        </tr>
      
                )}
      </tbody>

  </table> 
    </React.Fragment>
    );
}

export default ViewAllTenant;