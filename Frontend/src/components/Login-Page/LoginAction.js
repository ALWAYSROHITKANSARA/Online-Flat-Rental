import {useEffect,useState} from 'react'
import {connect} from 'react-redux'
import { useHistory } from 'react-router'
import axios from 'axios'
import React from 'react'

function LoginAction(props)
{


    function preback()
        {
          window.history.forward();
        }
        setTimeout(preback(),0);
      
        window.onunlod=()=>(null);
      
    const history=useHistory()

        const [msg,setMsg]=useState("")

        

     useEffect(()=>
    {     
        axios
        .get(`http://localhost:8080/login/authenticateUser/${props.username}/${props.password}/${props.usertype}`)
        .then((response) => {

console.log(response)
            if(response.data.userType==="admin")
            {
             sessionStorage.setItem("password",response.data.password)
             sessionStorage.setItem("userName",response.data.username)
             sessionStorage.setItem("usertype",response.data.usertype)
                      
             console.log('hello admin')
            history.push('/admin')
  
            setTimeout(function(){
                myFunction()
              },500)
        }
        else if(response.data.userType==="tenant")
            {
             sessionStorage.setItem("password",response.data.password)
             sessionStorage.setItem("userName",response.data.username)
             sessionStorage.setItem("usertype",response.data.usertype)
                      
             console.log('hello tenant')
            history.push('/tenant')
  
            setTimeout(function(){
                myFunction()
              },500)
        }
        else if(response.data.userType==="landlord")
            {
             sessionStorage.setItem("password",response.data.password)
             sessionStorage.setItem("userName",response.data.username)
             sessionStorage.setItem("usertype",response.data.usertype)
                      
             console.log('hello landlord')
            history.push('/landlord')
  
            setTimeout(function(){
                myFunction()
              },500)
        }
        else{
            sessionStorage.setItem("username",response.data.username)
            sessionStorage.setItem("password",response.data.password)
            sessionStorage.setItem("usertype",response.data.usertype)
            console.log('Hello error')
            window.alert('Invalid credentials')
            history.push({
                 pathname:'/'
            })
  
            setTimeout(function(){
                myFunction()
              },500)
        }

        })
        .catch((error) => {
            if(error.status===401)
          setMsg("Not Authorized");
         
        });
      
    },[])


    function myFunction()
    {
     window.location.reload(false)
    }
   

     return (
        <React.Fragment>
             <h3 style={{backgroundColor:"#FA8072", textAlign: "center", padding:5}}>
                 Login Failed=&gt;<a href="/login" class="btn btn-secondary">Try Again</a>
                 </h3>
             
             </React.Fragment>
     );
     }

export default LoginAction;