// pending

// After redirection page
// validation
// user added success message
//key is not provided in table data


import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllLandlord() {

    let initialCustomers=[];
    let [landlords,setLandlords]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/landlordCtrl/viewAllLandlord';
        axios.get(URL).then((response) => {
            console.log(response);
            setLandlords(response.data);
        })
        .catch((error) => console.log(error));
    },[]);





   return (
      <React.Fragment>
        
        <table className="table table-data table-striped table-bordered">
    <thead>
        <tr className="table-warning">
          <th className="col-md-2">ID</th>
          <th className="col-md-3">Landlord Name</th>
          <th className="col-md-1">Age</th>
          <th className="col-md-3">Flat List</th>
          <th className="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody className="table-success ">

      {
        landlords.map (
            landlord=>
        <tr>
          <td className="col-md-2">{landlord.landlordId}</td>
          <td className="col-md-3">{landlord.landlordName}</td>
          <td className="col-md-1">{landlord.landlordAge}</td>
          <td className="col-md-3">
            <button className="btn btn-info logout-btn" type="submit">Flat List</button>
          </td>
          <td className="col-md-3">
            <button className="btn btn-warning logout-btn" type="submit">Update</button>
            <button className="btn btn-danger logout-btn" type="submit">Delete</button>
          </td>
        </tr>
      )}
       
      </tbody>

  </table>     



    </React.Fragment>
    );
}

export default ViewAllLandlord;