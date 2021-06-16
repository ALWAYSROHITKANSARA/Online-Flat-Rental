import React, { useState, useEffect } from "react";
import axios from 'axios'
import { useHistory } from "react-router-dom";
function UpdateBooking() {
    let initialBooking={bookingFromDate:null,bookingToDate:null};
    let [booking, setBooking] = useState(initialBooking);
    let [id, setId] = useState(0);
    let [uid,setUid]= useState(0);
    const history = useHistory();


    useEffect(()=>
    {
        const URL = `http://localhost:8080/FlatBookingCtrl/updateFlatBooking/${id}`;
        axios
          .put(URL , booking)
          .then((response) => {
             
              console.log(response.data)
              alert(`Flat with ${id} is updated successfully `)
              setUid(0);
           })
    },[uid])

    const handleUpdateBooking=(event)=>
    {
        event.preventDefault()
        setUid(1)
        //history.push('/addbooking')
        
    }     
    return (

        <form className="form-group" onSubmit={handleUpdateBooking} noValidate>
            <label>Booking ID</label>
          <input
          type="number"
          min="0"
          className="form-control"
          value={id}
          onChange={(e) =>setId(e.target.value)}
        />
        <label for="from">FROM</label> <br></br>
        <input type="date" 
          value={booking.bookingFromDate}
          onChange={e=>setBooking({...booking,bookingFromDate: e.target.value})} /> <br></br>
        <label for="to">TO</label> <br></br>
        <input type="date" value={booking.bookingToDate}
          onChange={e=>setBooking({...booking,bookingToDate: e.target.value})} /> <br></br>
        
       {/* <input type="submit" /> */}
       <div className="col-15 container">
                                    <button type="submit" className="btn btn-primary mt-3">Confirm Booking</button>
                                </div>
                                
        </form>


    )
}

export default UpdateBooking
