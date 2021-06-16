// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllUser() {

    let initialCustomers=[];
    let [users,setUsers]=useState(initialCustomers);
    const [userid,setUser] = useState(0);
    const [deletebtn,setdeleteButton] = useState(0);


    useEffect(() => {
        const URL = 'http://localhost:8080/user/viewAllUser';
        axios.get(URL).then((response) => {
            setUsers(response.data);
        })
        .catch((error) => console.log(error));
    },[]);

    useEffect(() => {
        // DELETE request using axios inside useEffect React hook
        axios.delete(`http://localhost:8080/user/removeUser/${userid}`)
        .then(response=>{
            console.log(response);



        });
    // empty dependency array means this effect will only run once (like componentDidMount in classes)
    }, [deletebtn]);





    function goToAddCustomer(){
        //props.history.push('/addCustomer');
    }


const deletebtnhandler = (e)=>{
        e.preventDefault();
        setdeleteButton(userid)
        console.log(userid)

               
    }

  return (
      <React.Fragment>
            <table className="table table-data table-striped table-bordered">
                <thead>
                <tr className="table-warning">
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>User Type</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody className="table-success ">
                {
                users.map (
                    user =>
                    <tr>
                        <td className="col-md-2">{user.userId}</td>
                        <td className="col-md-3">{user.userName}</td>
                        <td className="col-md-3">{user.userType}</td>
                        <td className="col-md-3">
                        <button className="btn btn-warning logout-btn" type="submit" onClick={goToAddCustomer}>Update</button>
                        <button className="btn btn-danger logout-btn" type="submit" onClick={deletebtnhandler}>Delete</button>
                    </td>
                </tr>
                )}

                                    
                </tbody>
            </table>
    </React.Fragment>
    );
}

export default ViewAllUser;