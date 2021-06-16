// pending

// After redirection page
// validation
// tenant added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function AddTenant() {


  let initialtenant={tenantName:'',age:''};
  let [tenant,setTenant]=useState(initialtenant);
  let [msg,setMsg]=useState('');
  let [id,setId]=useState(0);

  useEffect(() => {
    const URL='http://localhost:8080/tenant/addTenant';
    axios.post(URL,tenant).then((response) => 
    {
        setMsg(response.data)
    }).catch(error => console.log(error.message))
    },[id])

    function handleBtnClick(e)
    {
        e.preventDefault();
        setId(1)
        window.alert("tenant Added...");

    }




  return (
      <React.Fragment>
        <form className="c2">
            <h1 className="form-text">Add Tenant</h1>
         <br/><br/><br/>
            
            <input name="tenantid" type="text" placeholder="Tenant ID" className="col-md-4 address-tags"
             value={tenant.tenantId} onChange={e=>setTenant({...tenant,tenantId:e.target.value})}
            /><br/><br/>
            <input name="tenantname" type="text" placeholder="Tenant Name" className="col-md-4 address-tags"
             value={tenant.tenantName} onChange={e=>setTenant({...tenant,tenantName:e.target.value})}
            /><br/><br/>
            <input name="tenantage" type="number" placeholder="Tenant Age" className="col-md-4 address-tags"
             value={tenant.age} onChange={e=>setTenant({...tenant,age:e.target.value})}
            />
        <br/><br/>
            <button className="btn" onClick={handleBtnClick}>Add Tenant</button>
        </form>
    
     </React.Fragment>
    );
}

export default AddTenant;