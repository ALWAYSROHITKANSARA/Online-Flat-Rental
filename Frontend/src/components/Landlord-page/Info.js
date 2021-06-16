import React, { useState, useEffect } from "react";
import axios from "axios";
{/*You will provide only your landlord id */}
function Info(props) {
    let initialLandlord = {
        flatList: [],
        landlordAge: 0,
        landlordName: "",
        landlordId:0
      };
    let [Landlord, setLandlord] = useState(initialLandlord);
    let [id, setId] = useState(null);
    let [btnId,setBtnId]=useState(0);
    
    function formValidate() {
        const form = document.querySelector('form');
        var lid=form.elements.landlordid.value;
    
        var error=document.getElementById("error")
    
        var gbtn=document.getElementById("getbtn")
    
        if(lid<=0){
          error.innerHTML="Landlord ID: Provide a positive integer"
        }
        else if(lid%1!==0){
            error.innerHTML="Landlord ID: Provide an integer value"
        }
        else{
          error.innerHTML=""
          gbtn.style.pointerEvents="auto"
      }
    
      }
      useEffect(() => {
        const URL = `http://localhost:8080/landlordCtrl/viewLandlordByID/${id}`;
        axios
          .get(URL)
          .then((response) => {
            setLandlord(response.data);
            setBtnId(id);
          })
          .catch((error) => console.log(error.response));
      }, [btnId]);
      const handleBtnClick=(event)=>
        {
            event.preventDefault();
            setBtnId(id)
        }
    return(((btnId!==0)&&Landlord.landlordAge!==0)?<>
    <div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
    <h2 className="text-primary container">Profile</h2>
      <hr />
      <div className="form-group container">
        <form className="col-3" onSubmit={handleBtnClick}>
        <h6 className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</h6>
                <input
                name="landlordid"
                type="number"
                min="1" max='10000'
                className="form-control"
                value={id}
                onInput={formValidate}
                onChange={(e) =>setId(e.target.value)}
                placeholder="Landlord ID"
                />
                <button id="getbtn" style={{margin:"10px 0px"}} className='btn btn-success'>Get Info</button>
                <h6 id="error" className="text text-danger"></h6>
        </form>
        </div>
        <table className="table table-bordered table-hover container table-striped">
            <thead style={{color:"white",backgroundColor: "#b23850"}}>
                    <tr><th colspan="2">Landlord Details</th></tr>
            </thead>
            <tbody style={{backgroundColor: "#c4dbf6 "}}>
                <tr>
                    <td><b>Landlord ID:</b></td>
                    <td>{Landlord.landlordId}</td>
                </tr>
                <tr>
                    <td><b>Name:</b></td>
                    <td>{Landlord.landlordName}</td>
                </tr>
                <tr>
                    <td><b>Age:</b></td>
                    <td>{Landlord.landlordAge}</td>
                </tr>
                <tr>
                    <td><b>Total Flats:</b></td>
                    <td>{Landlord.flatList.length}</td>
                </tr>
            </tbody>
        </table>
        
        </div>
        </>:<>
        <div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
            <h2 className="text-primary container">Profile</h2>
            <hr />
            <div className="form-group container">
                <form className="col-3" onSubmit={handleBtnClick}>
                <h6 className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</h6>
                        <input
                        name="landlordid"
                        type="number"
                        min="1" max='10000'
                        className="form-control"
                        value={id}
                        onInput={formValidate}
                        onChange={(e) =>setId(e.target.value)}
                        placeholder="Landlord ID"/>
                        <button id="getbtn" style={{margin:"10px 0px"}} className='btn btn-success'>Get Flats</button>
                        <h6 id="error" className="text text-danger"></h6>
                </form>
            </div>
            </div>
        </>
        
        );
}
export default Info;