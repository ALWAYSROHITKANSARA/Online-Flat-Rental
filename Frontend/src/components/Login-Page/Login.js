
import React, { useState } from 'react';
import styles from '../Login-Page/login.module.css';
import LoginAction from './LoginAction';
import { BrowserRouter as Router, Switch, Route, Link, useHistory} from "react-router-dom"





function Login() {

   
   function formValidate()
   {
      const form = document.querySelector('form')
      var uName=form.elements.username.value
      var upassword=form.elements.password.value
      var uType = form.elements.usertype.value

      var error=document.getElementById("error")
      //   var error1=document.getElementById("error1")

      var lgn=document.getElementById("formlogin")
      //   error1.innerHTML=""


      if(uName.length<3)
      {
         error.innerHTML="User Name must be minimum 3 char"
      }
      else if(upassword.length<8)
      {
         error.innerHTML="Password must be minimum 8 char"
      }
      else if(uType=""){
         error.innerHTML="Select an option"
      }
      else{ 
         error.innerHTML="Ready to Submit"
         lgn.style.pointerEvents="auto"
         
      }
   }





   const history = useHistory();
   const [username,setUsername] = useState('');
   const [password,setPassword] = useState(''); 
   const [usertype,setUserType] = useState(''); 

   const {errors} = {username,password}

const selectOption = (e)=>{
   setUserType(e.target.value)
}

   return (
      <React.Fragment>
       <Router>     
       <Switch>



      <div className={styles.loginbox}>   
         <div className={styles.c1}>
            
            <div className={styles.c11}>
               
              
                      <Route path="/loginactions">
                      <LoginAction username={username} password={password} usertype = {usertype}/>
                     </Route>
                     <h1 className={styles.mainhead}>Welcome</h1>
                
            </div>
         </div>
         <div className={styles.c2}>
         
            <form className={styles.signin} method="post">
               <h1 className={styles.signup1}>SIGN IN</h1>
               <Route path="/loginactions">
                      <LoginAction username={username} password={password} usertype = {usertype}/>
                     </Route>
            
               
               <input name="username" type="text" required={true} placeholder="Username*" className={styles.username}
                  value = {username}
                  onChange= {(e)=>setUsername(e.target.value)}
                  onInput={formValidate}
                  style={{marginTop:20}}
                  />
                
               <input name="password" type="password" required={true} placeholder="Password*" className={styles.username}
               value = {password}
               onChange= {(e)=>setPassword(e.target.value)}
               onInput={formValidate}
               />

                  <h6 style={{paddingLeft:40}}>Select User Type</h6>

                  <select name="usertype" required={true} className={styles.username} value={usertype} 
                  onChange= {selectOption}
                  >
                     <option value="">Select type</option>
                     <option value="landlord"  >landlord</option>
                     <option value="tenant"  >tenant</option>
                     <option value="admin"  >admin</option>
                    
                  </select>

                  <p id="error" style={{backgroundColor:"#D6EAF8", textAlign:"center"}}></p>
                  
               <button id="formlogin" type="submit" className={styles.btnlogin}><Link to="/loginactions">Get Started</Link></button>
            
            </form>
            
         </div>
         
         <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
         <script src="script.js" type="text/jsx"></script>
      </div>
      </Switch>
      </Router>
      </React.Fragment>
    );
   }

export default Login;