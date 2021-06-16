import React from 'react'
import back from './img/Bgpic.png'
function Home() {
    return (
        <>
            <div className="container-fluid"style={{backgroundColor:"#fdf9f1", backgroundSize:"cover",backgroundImage: `url(${back})`,backgroundRepeat: 'no-repeat'}}>
            <h2 className="text-center text-primary">Home Page</h2>
            <div className="card-deck">
            <div className="card border-success mb-3" style={{maxWidth: "40rem",margin:"auto"}}>
              <div className="card-header"><b>LOCATIONS</b></div>
              <div className="card-body text-primary">
                <ul className="list-unstyled">
                  <li>India</li>
                  <li>France</li>
                  <li>Germany</li>
                  <li>U.S.A.</li>
                  <li>Pakistan</li>
                </ul>
              </div>
            </div>
            <div className="card border-success mb-3" style={{maxWidth: "40rem",margin:"auto"}}>
              <div className="card-header"><b>CUSTOMERS</b></div>
              <div className="card-body text-primary">
              <ul className="list-unstyled">
                  <li>Landlords&nbsp;  1000+</li>
                  <li>Tenants &nbsp;&nbsp;&nbsp;&nbsp;   5000+</li>
                </ul>
              </div>
              
              </div>
              <div className="card border-success mb-3" style={{maxWidth: "40rem",margin:"auto"}}>
              <div className="card-header"><b>ACHIEVEMENTS</b></div>
              <div className="card-body text-primary">
              <ul className="list-unstyled">
                  <li>Most promising rental site&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Year-&nbsp;2020</li>
                  <li>Highest users on E-Commerce&nbsp;&nbsp;&nbsp;Year-&nbsp;2016</li>
                </ul>
              </div>
              
              </div> 


            </div>
                   
            </div>
        </>
        
    )
}

export default Home