// pending

// After redirection page
// validation
// tenant added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewTenant() {

  const [tenantid,setTenant] = useState(0);
  const [tenant,setTenantDetail] = useState([]);
  const [btn,setButton] = useState(0);
  const [deletebtn,setdeleteButton] = useState(0);

  useEffect(() => {
    // DELETE request using axios inside useEffect React hook
    axios.get(`http://localhost:8080/tenant/tenant/${tenantid}`)
    .then((response) => {
      
      console.log(response);
      setTenantDetail(response.data)});

}, [btn]);

     useEffect(()=>{
         const URL=`http://localhost:8080/tenant/deletetenant/${tenantid}`
         axios.delete(URL).then(response=>
             {
                 setTenantDetail([]);
                 setTenant(0);
                 btn(0);
             }).catch(error=>console.log(error.response));
     },[deletebtn]);




const handleBtnClick = (e)=>{
 e.preventDefault();
 setButton(tenantid)
   
}


const handleDeleteBtnClick =(e)=>{
   e.preventDefault();
   setdeleteButton(1)
}


   return (
      <React.Fragment>
            <form class="view-form">
    <h1 class="form-text ">View Tenant By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="Tenant ID*" class="username"
     value = {tenantid}
     onChange={e=>setTenant(e.target.value)}
    />
    <br/>
    <button class="btn" onClick={handleBtnClick}>View Tenant</button>
   </form>
   

 <table class="table table-data table-striped table-bordered view-table">
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
        <tr>
          <td class="col-md-2">{tenant.tenantId}</td>
          <td class="col-md-3">{tenant.tenantName}</td>
          <td class="col-md-1">{tenant.age}</td>
          <td class="col-md-3">
            <button class="btn btn-info logout-btn" type="submit">View Flats</button>
          </td>
          <td class="col-md-3">
            <button class="btn btn-warning logout-btn" type="submit">Update</button>
            <button class="btn btn-danger logout-btn" type="submit"
            onClick={handleDeleteBtnClick}
            >Delete</button>
          </td>
        </tr>
      
       
      </tbody>

  </table>     

      </React.Fragment>
    );
}

export default ViewTenant;