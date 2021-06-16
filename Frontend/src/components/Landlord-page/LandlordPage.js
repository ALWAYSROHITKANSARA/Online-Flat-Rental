// pending

// After redirection page
// validation
// user added success message

import React from 'react';

import { BrowserRouter as Router,Route,Switch} from 'react-router-dom'

import Home from '../Landlord-page/Home';
import Menu from '../Landlord-page/Menu';
import AddFlat from '../Landlord-page/flat/AddFlat';
import AllFlat from '../Landlord-page/flat/AllFlat';
import FlatById from '../Landlord-page/flat/FlatById';
import Footer from '../Landlord-page/Footer';
import Header from '../Landlord-page/Header';
import UpdateFlat from '../Landlord-page/flat/UpdateFlat';
import Info from '../Landlord-page/Info';

function LandLord() {

   return (
      <React.Fragment>
           <Router>
        <Header/>
        <Menu/>
        <div className='container-fluid'>
        <Switch>
          <Route exact path='/landlord' component={Home}/>
          <Route path='/info' component={Info}/>
          <Route path='/addFlat' component={AddFlat}/>
          <Route path='/allFlat' component={AllFlat}/>
          <Route path='/flatbyid' component={FlatById}/>
          <Route path='/updateFlat' component={UpdateFlat}/>
        </Switch>
        </div>
        <Footer/>
      </Router>
      </React.Fragment>
    );
}

export default LandLord;