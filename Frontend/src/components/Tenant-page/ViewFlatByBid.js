import React, { useState, useEffect } from "react";
import axios from 'axios'
import { useHistory } from "react-router-dom";
function ViewFlatByBid() {
//   let initialBooking = [] ;
  let initialBooking={bookingNo:null,bookingFromDate:null,bookingToDate:null,flat:{flatId: null},tenantId:{tenantId : null}}
  let [booking, setBooking] = useState(initialBooking);
  let [id, setId] = useState(0);
  let [btnId,setBtnId]=useState(0)
  const history = useHistory();
  const formStyle = {
    backgroundColor: "#FFFAFA",
    padding: "15px"
};
const mystyle = {
    color: "white",
    backgroundColor: "DodgerBlue",
    padding: "10px",
    fontFamily: "Arial",
  };

   useEffect(() => {
     const URL = `http://localhost:8080/FlatBookingCtrl/viewFlatBookingByID/${id}`;
     axios
      .get(URL)
      .then((response) => {
          setBooking(response.data)
          console.log(response.data)
          console.log(response.statusText)
      })
      .catch((error) =>{
        if(id != 0 && error.response){
          alert("Booking with ID is not available")
        }else if(id != 0 && error.request){
          alert("Server Not connected")
        }
      });
   },[btnId])

  function handleDeleteBooking(id){
      
       const URL = `http://localhost:8080/FlatBookingCtrl/deleteFlatBooking/${id}`;
       axios
         .delete(URL)
         .then((response) => {
            
             console.log(response.data)
             alert(`Flat with ${id} is deleted successfully `)
             
             setId(0);
          })
    }
    function handleUpdateBooking(id)
    {
        
     history.push('/updatebooking')
    }
function handleBtnClick()
{
    setBtnId(id);
    
}
  return (
       

    <div style={formStyle}>
           <div className="col-3">
        <label>Booking ID</label>
        <input
        type="number"
        min="0"
          className="form-control"
          value={id}
          onChange={(e) =>setId(e.target.value)}
        />
        <button onClick={handleBtnClick} className='btn btn-success mt-2'>Get Details</button>
        <br></br>
        </div>

      <table className="table table-hover table-striped border-dark">
        <thead>
          <tr className="table-dark">
            <th>BOOKING NUMBER</th>
            <th>FROM DATE</th>
            <th>TO DATE</th>
            <th>FLAT ID</th>
            <th>TENANT ID</th>
            </tr>
          </thead>
          
          <tbody>
            
              <tr>
                <td>{booking.bookingNo}</td>
                <td>{booking.bookingFromDate}</td>
                <td>{booking.bookingToDate}</td>
                <td>{booking.flat.flatId}</td>
                <td>{booking.tenantId.tenantId}</td>
                <td><button className="btn btn-outline" onClick={()=>handleUpdateBooking(booking.bookingNo)}>UPDATE</button></td>
                <td><button className="btn btn-outline-danger" onClick={()=>handleDeleteBooking(booking.bookingNo)}>Delete</button></td> 
              </tr>
        
            
          </tbody>
        
      </table>
    </div>
  );
}

export default ViewFlatByBid;
