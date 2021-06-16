// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveUser() {

   
   const [status, setStatus] = useState(null);
   const [userid,setUser] = useState(0);

   useEffect(() => {
      // DELETE request using axios inside useEffect React hook
      axios.delete(`http://localhost:8080/user/removeUser/${userid}`)
      .then(() => setStatus('Delete successful'));
  // empty dependency array means this effect will only run once (like componentDidMount in classes)
  }, [userid]);


  const handleBtnClick = (e)=>{
      console.log(e.target.response)
      window.alert("User Removed");
  }

   return (
      <React.Fragment>
        <form className="c2 view-form" method="POST">
            <h1 className="form-text ">Remove User By ID</h1>
           <br/>
            <input name="userid" type="number" placeholder="User ID*" className="username" 
             value = {userid}
             onChange={e=>setUser(e.target.value)}
            //   onChange={e=>console.log(e.target.value)}
             
            />
            <br/>
           
            <button className="btn" onSubmit={handleBtnClick}>Remove User</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveUser;