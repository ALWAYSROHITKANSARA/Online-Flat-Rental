// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewUser() {

    
   // const [status, setStatus] = useState(null);
    const [userid,setUser] = useState(0);
    const [user,setUserDetail] = useState([]);
    const [btn,setButton] = useState(0);
    const [deletebtn,setdeleteButton] = useState(0);

 
    useEffect(() => {
       // DELETE request using axios inside useEffect React hook
       axios.get(`http://localhost:8080/user/viewUserByID/${userid}`)
       .then((response) => setUserDetail(response.data));

   }, [btn]);

        useEffect(()=>{
            const URL=`http://localhost:8080/user/removeUser/${userid}`
            axios.delete(URL).then(response=>
                {
                    setUserDetail([]);
                    setUser(0);
                    btn(0);
                }).catch(error=>console.log(error.response));
        },[deletebtn]);


 
 
   const handleBtnClick = (e)=>{
    e.preventDefault();
    setButton(userid)
      
  }


  const handleDeleteBtnClick =(e)=>{
      e.preventDefault();
      setdeleteButton(userid)
  }


   return (
      <React.Fragment>
            <form className="view-form"> 
                <h1 className="form-text ">View User By ID</h1>
                <br/>
                <input name="userId" type="number" placeholder="User ID*" className="username"
                  value = {userid}
                  onChange={e=>setUser(e.target.value)}
                
                />
                <br/>
                <button className="btn" onClick={handleBtnClick}>View User</button>
            </form>
            
        
            <table className="table table-data table-striped table-bordered view-table">
            <thead>
                <tr className="table-warning">
                <th className="col-md-2">User ID</th>
                <th className="col-md-4">User Name</th>
                <th className="col-md-4">User Type</th>
                <th className="col-md-2">Actions</th>
                </tr>
            </thead>
            <tbody className="table-success ">
            
                    <tr>
                        <td className="col-md-2">{user.userId}</td>
                        <td className="col-md-3">{user.userName}</td>
                        <td className="col-md-3">{user.userType}</td>
                        <td className="col-md-3">
                    <button className="btn btn-warning logout-btn" type="submit">Update</button>
                    <button className="btn btn-danger logout-btn" type="submit" 
                     onClick={handleDeleteBtnClick}
                    >Delete</button>
                </td>
                </tr>
                 
            </tbody>
            </table>
      </React.Fragment>
    );
}

export default ViewUser;