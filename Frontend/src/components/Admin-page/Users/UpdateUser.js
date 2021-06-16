// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function UpdateUser() {

   const [user,setUserDetail] = useState([]);
   const [userid,setUser] = useState(0);
   const [btn,setButton] = useState(0);


   useEffect(() => {
      const URL='http://localhost:8080/user/updateUser';
      axios.put(URL,user).then((response) => 
      setUserDetail(response.data)
      )
      .catch(error => console.log(error.message))
  },[btn]);
  
  function handleBtnClick(e)
  {
      e.preventDefault();
      setButton(userid)
      window.alert("User Updated...");

  }
  
   return (
      <React.Fragment>
        <form className="c2">
            <h1 className="form-text ">Update User</h1>
            <br/>  <br/>  
       <input name="userid" type="nummber" placeholder="User ID" className="username" 
       value={user.userid} onChange={e=>setUser({...user,userid:e.target.value})}
       />
       <input name="username" type="text" placeholder="New Username*" className="username"
       value={user.userName} onChange={e=>setUser({...user,userName:e.target.value})}
       />

       <input name="password" type="password" placeholder="New Password*" className="username"
       value={user.password} onChange={e=>setUser({...user,password:e.target.value})}
       />


        <select name="usertype" className="username"
        value={user.userType} onChange={e=>setUser({...user,userType:e.target.value})}
        
        >
          <option value="">New User Type</option>
          <option value="landlord">Landlord</option>
          <option value="tenant">Tenant</option>
         </select>

        <br/>  <br/>  <br/>
    <button className="btn" onClick={handleBtnClick}>Update User</button>
 </form>
    </React.Fragment>
    );
}

export default UpdateUser;