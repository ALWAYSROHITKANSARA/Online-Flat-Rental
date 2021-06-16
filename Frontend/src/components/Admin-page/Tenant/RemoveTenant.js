// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveTenant() {

   const [status, setStatus] = useState(null);
   const [tenantid,setUser] = useState(0);

   useEffect(() => {
      axios.delete(`http://localhost:8080/tenant/deletetenant/${tenantid}`)
      .then(() => setStatus('Delete successful'));

  }, [tenantid]);


  const handleBtnClick = (e)=>{
      console.log(e.target.response)
      window.alert("User Removed");
  }

   return (
      <React.Fragment>
        <form className="c2 view-form" method="POST">
            <h1 className="form-text ">Remove Tenant By ID</h1>
            <br/>
            <input name="tenentid" type="number" placeholder="Tenant ID*" className="username"
            value = {tenantid}
            onChange={e=>setUser(e.target.value)}
            />
            <br/><br/>
            

        
            <button className="btn" onSubmit={handleBtnClick}>Remove Tenant</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveTenant;