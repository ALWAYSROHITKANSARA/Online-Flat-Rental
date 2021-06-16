
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function AddUser() {


  let initialuser={userName:'',password:'',userType:''};
  let [user,setUser]=useState(initialuser);
  let [msg,setMsg]=useState('');
  let [id,setId]=useState(0);

  useEffect(() => {
      const URL='http://localhost:8080/user/addUser';
      axios.post(URL,user).then((response) => 
      {
          setMsg(response.data)
      }).catch(error => console.log(error.message))
  },[id])

  function handleBtnClick(e)
  {
      e.preventDefault();
      setId(1)
      setUser(initialuser)
      window.alert("User Added...");

  }


  return (
      <React.Fragment>
        <form className="c2" method="POST">
    <h1 className="form-text ">Add User</h1>
    <br/><br/><br/><br/>
       <input name="username" type="text" placeholder="Username*" className="username"
       value={user.userName} onChange={e=>setUser({...user,userName:e.target.value})}
       />
       <br/>
       <input name="password" type="password" placeholder="Password*" className="username"
       value={user.password} onChange={e=>setUser({...user,password:e.target.value})}
       />
       <br/>
       <select name="usertype" className="username" 
        value={user.userType} 
        onChange={e=>setUser({...user,userType:e.target.value})}
       >
         <option value="">Select one option</option>
         <option value="landlord">Landlord</option>
         <option value="tenant">Tenant</option>
         <option value="admin">Admin</option>

       </select>
    <br/>
    <button className="btn" type="submit" onClick={handleBtnClick}>Add User</button>
        </form>
     </React.Fragment>
    );
}

export default AddUser;