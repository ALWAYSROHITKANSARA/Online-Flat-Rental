// pending

// After redirection page
// validation
// user added success message
//address is not inserted yet

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllFlat() {

    let initialCustomers=[];
    let [flats,setFlats]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/flat/getallflats';
        axios.get(URL).then((response) => {
            setFlats(response.data);
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
          <th class="col-md-1">Flat ID</th>
          <th class="col-md-2">Flat Cost</th>
          <th class="col-md-5">Flat Address</th>
          <th class="col-md-1">Flat Availability</th>
          <th class="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody class="table-success ">
      {
      flats.map (

                    flat =>

        <tr>
          <td class="col-md-1">{flat.flatId}</td>
          <td class="col-md-2">{flat.flatCost}</td>
          <td class="col-md-5">Some address</td>    
          <td class="col-md-1">{flat.flatAvailability}</td>
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

export default ViewAllFlat;