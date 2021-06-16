// pending

// After redirection page
// validation
// user added success message

import React from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import Home from '../Tenant-page/Home';
import Header from '../Tenant-page/Header';
import Menu from '../Tenant-page/Menu';
import GetAllFlats from '../Tenant-page/GetAllFlats';
import ViewFlatByBid from '../Tenant-page/ViewFlatByBid';
import UpdateBooking from '../Tenant-page/UpdateBooking';
import AddFlatBooking from '../Tenant-page/AddFlatBooking';
import Footer from '../Tenant-page/Footer';




function Tenant() {

   return (
      <React.Fragment>
            <Router>
    <div className="container mt-2">
      {/* <AddFlatBooking /> */}
      <Header />
      <Menu />  
      <Route path="/tenant" exact component={Home} />
      <Route path="/getallflats" exact component={GetAllFlats} />
      <Route path="/viewflatbybid" exact component={ViewFlatByBid} />
      <Route path="/updatebooking" exact component={UpdateBooking} />
      <Route path="/addbooking" exact component={AddFlatBooking} />
      <Footer />
      

    </div>
    </ Router>
      </React.Fragment>
    );
}

export default Tenant;