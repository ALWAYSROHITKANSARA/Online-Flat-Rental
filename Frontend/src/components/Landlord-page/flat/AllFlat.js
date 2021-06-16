import React, { useState, useEffect } from "react";
import axios from "axios";
import trash from "../img/trash.png";
{/*Responsive done 
validation needed
styling needed*/}
function AllFlat(props) {
  let initialLandlord = {
    flatList: [],
    landlordAge: 0,
    landlordName: "",
    landlordId:0
  };
  let [Landlord, setLandlord] = useState(initialLandlord);
  let [id, setId] = useState(null);
  let [btnId,setBtnId]=useState(0);
  let [flatId,setFlatId]=useState(0);
  let [btnDelete,setBtnDelete]=useState(0);
  let [msg,setMsg]=useState('');


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
  const  handleDeleteFlat=(flat)=>
  {
    setFlatId(flat);
    setBtnDelete(flat);
  }
  useEffect(()=>{
    const URL=`http://localhost:8080/flat/removeflat/${flatId}`
    axios.delete(URL).then(response=>
        {
            setMsg(response.data);
            setBtnDelete(0);
            setBtnId(-1);
        }).catch(error=>console.log(error.response));
  },[btnDelete]);
  
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
  return (
    (btnId!==0)?(Landlord.flatList.length>0)?(btnId==-1)?
    <>
     <div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
    <h2 className="text-primary container">Flat List</h2>
      <hr />
      <div className="form-group container">
        <form className="col-3" onSubmit={handleBtnClick}>
        <h6 className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</h6>
                <input  name="landlordid"
                type="number"
                min="1" max='10000'
                className="form-control"
                value={id}
                onInput={formValidate}
                onChange={(e) =>setId(e.target.value)}
                placeholder="Landlord ID"
                />
                <button id="getbtn"  style={{margin:"10px 0px"}} className='btn btn-success'>Get Flats</button>
                <h6 id="error" className="text text-danger"></h6>
        </form>
        <h6  className="text text-danger">{msg}</h6>
      <table className="table table-bordered table-hover marginTop">
        <thead style={{backgroundImage: "linear-gradient(15deg, #5680e9 0%, #999999 100%)"}}>
          <tr>
          <th>Flat ID</th>
            <th>House no</th>
            <th>Street</th>
            <th>City</th>
            <th>Pincode</th>
            <th>State</th>
            <th>Country</th>
            <th>Flat cost</th>
            <th>Availability</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody style={{backgroundImage: "linear-gradient(15deg, #e7e3d4 0%, #c4dbf6 100%)"}}> 
          {Landlord.flatList.map((flat) => (
            <tr>
                <td>{flat.flatId}</td>
                <td>{flat.flatAddress.houseNo}</td>
                <td>{flat.flatAddress.street}</td>
                <td>{flat.flatAddress.city}</td>
                <td>{flat.flatAddress.pin}</td>
                <td>{flat.flatAddress.state}</td>
                <td>{flat.flatAddress.country}</td>
                <td>{flat.flatCost}</td>
                <td>{flat.flatAvailability}</td>
                <td><button onClick={()=>{handleDeleteFlat(flat.flatId)}} className='btn btn-danger'><img src={trash}width="20" height="25"/></button></td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
    </div>
    </>: <>
    <div style={{height:"auto",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
    <h2 className="text-primary container">Flat List</h2>
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
                <button id="getbtn" style={{margin:"10px 0px"}} className='btn btn-success'>Get Flats</button>
                <h6 id="error" className="text text-danger"></h6>
        </form>
        <h6  className="text text-danger">{msg}</h6>
      <table className="table table-bordered table-hover marginTop">
        <thead style={{backgroundImage: "linear-gradient(15deg, #5680e9 0%, #999999 100%)"}}>
          <tr>
          <th>Flat ID</th>
            <th>House no</th>
            <th>Street</th>
            <th>City</th>
            <th>Pincode</th>
            <th>State</th>
            <th>Country</th>
            <th>Flat cost</th>
            <th>Availability</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody style={{backgroundImage: "linear-gradient(15deg, #e7e3d4 0%, #c4dbf6 100%)"}}> 
          {Landlord.flatList.map((flat) => (
            <tr>
                <td>{flat.flatId}</td>
                <td>{flat.flatAddress.houseNo}</td>
                <td>{flat.flatAddress.street}</td>
                <td>{flat.flatAddress.city}</td>
                <td>{flat.flatAddress.pin}</td>
                <td>{flat.flatAddress.state}</td>
                <td>{flat.flatAddress.country}</td>
                <td>{flat.flatCost}</td>
                <td>{flat.flatAvailability}</td>
                <td><button onClick={()=>{handleDeleteFlat(flat.flatId)}} className='btn btn-danger'><img src={trash}width="20" height="25"/></button></td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
    </div>
      
    </>:<>
    <div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
    <h2 className="text-primary container">Flat List</h2>
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
                <button id="getbtn" style={{margin:"10px 0px"}} className='btn btn-success'>Get Flats</button>
                <h6 id="error" className="text text-danger"></h6>
        </form>
        <h6 className="text text-danger">{Landlord.landlordName} you don't have any flats.</h6>
      </div>
    </div>
    
    </>:<>
    <div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
    <h2 className="text-primary container">Flat List</h2>
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

export default AllFlat;