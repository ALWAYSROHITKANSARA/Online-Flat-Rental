// pending

// After redirection page
// validation
// user added success message

import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllBooking() {

    let initialCustomers=[];
    let [bookings,setBookings]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/FlatBookingCtrl/viewAllFlatBooking';
        axios.get(URL).then((response) => {
            setBookings(response.data);
        })
        .catch((error) => console.log(error));
    },[]);

    function goToAddCustomer(){
        //props.history.push('/addCustomer');
    }


  return (
      <React.Fragment>
        <table class="table table-data table-striped table-bordered">
                <thead>
                    <tr class="table-warning">
                    <th class="col-md-1">Booking No.</th>
                    <th class="col-md-1">Flat ID</th>
                    <th class="col-md-1">Tenant ID</th>
                    <th class="col-md-2">Booking From</th>
                    <th class="col-md-2">Booking From</th>
                    <th class="col-md-3">Actions</th>
                    </tr>
                </thead>
                <tbody class="table-success">
                {
                bookings.map (
                    booking =>

                    <tr>
                    <td class="col-md-1">{booking.bookingNo}</td>
                    <td class="col-md-1">{booking.flatId}</td>
                    <td class="col-md-1">{booking.tenantId}</td>
                    <td class="col-md-2">{booking.bookingFromDate}</td>
                    <td class="col-md-2">{booking.bookingToDate}</td>
                    <td class="col-md-3">
                        <button class="btn btn-warning logout-btn" type="submit">Update</button>
                        <button class="btn btn-danger logout-btn" type="submit">Delete</button>
                    </td>
                    </tr>
                
                )}
                </tbody>

            </table>
    </React.Fragment>
    );
}

export default ViewAllBooking;