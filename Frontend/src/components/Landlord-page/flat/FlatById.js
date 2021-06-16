import React, { useEffect, useState } from "react";
import axios from "axios";
import trash from "../img/trash.png";

function FlatById(props) {
    let initialFlat = {
        flatAddress: {
          city: "",
          country: "",
          houseNo: null,
          pin: null,
          state: "",
          street: ""
        },
        flatAvailability: "",
        flatCost: null
      };
    let [flat,setFlat]=useState(initialFlat);
    let [flatId,setFlatId]=useState(0);
    let [btnFlatId,setBtnFlatId]=useState(0);
    let [msg,setMsg]=useState('');
    let [btnDelete,setBtnDelete]=useState(0);

    function formValidate() {
      const form = document.querySelector('form');
      var fid=form.elements.flatid.value;
      var error=document.getElementById("error");
  
      var gbtn=document.getElementById("getbtn");
  
      if(fid<=0){
        error.innerHTML="Flat Number: Provide a positive integer";
      }
      else if(fid%1!==0){
        error.innerHTML="Flat Number: Provide an integer value";
      }
      else{
        error.innerHTML="";
        gbtn.style.pointerEvents="auto";
    }
}
  const  handleDeleteFlat=(event)=>
  {
    event.preventDefault();
    setBtnDelete(flatId);
     
  }
  useEffect(()=>{
    const URL=`http://localhost:8080/flat/removeflat/${flatId}`
    axios.delete(URL).then(response=>
        {
            setMsg(response.data);
            setFlat(initialFlat);
            setFlatId(0);
            setBtnFlatId(0);
        }).catch(error=>console.log(error.response));
  },[btnDelete]);

    useEffect(() => {
        const URL = `http://localhost:8080/flat/viewflatbyid/${flatId}`;
        axios
          .get(URL)
          .then((response) => {
            setFlat(response.data);
          })
          .catch((error) => console.log(error.response));
      }, [btnFlatId]);
    
      const handleBtnClick=(event)=>
  {
    event.preventDefault();
    setBtnFlatId(flatId)
  }

  return (
    (btnFlatId!==0)?(flat.flatCost>0)?<div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
      <h2 className="text-primary container">Search Flat</h2>
      <hr />
      <div className="form-group container">
        <form className="col-3" onSubmit={handleBtnClick}>
        <label className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</label>
                <input
                name="flatid"
                type="number"
                max='10000'
                className="form-control"
                value={flatId}
                onInput={formValidate}
                onChange={(e) =>setFlatId(e.target.value)}
                placeholder="Flat ID"
                />
                <button id="getbtn"  style={{margin:"10px 0px"}} className='btn btn-success'>Search</button>
                <h6 id="error" className="text text-danger"></h6>
        </form>
      <table className="table table-bordered table-hover marginTop text-center">
        <thead style={{backgroundImage: "linear-gradient(15deg, #5680e9 0%, #5ab9ea 100%)"}}>
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
        <tbody style={{backgroundImage: "linear-gradient(15deg, #e7e3d4 0%, #999999 100%)"}}> 
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
                <td><button onClick={handleDeleteFlat} className='btn btn-danger'><img src={trash}width="20" height="25"/></button></td>
            </tr>
        </tbody>
      </table>
      </div>
    </div>:
    <div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
    <h2 className="text-primary container">Search Flat</h2>
      <hr />
      <div className="form-group container">
        <form className="col-3" onSubmit={handleBtnClick}>
        <label className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</label>
                <input
                 name="flatid"
                type="number"
                min="1" max='10000'
                className="form-control"
                value={flatId}
                onInput={formValidate}
                onChange={(e) =>setFlatId(e.target.value)}
                placeholder="Flat ID"
                />
                <button id="getbtn" style={{margin:"10px 0px"}} className='btn btn-success'>Search</button>
                <h6 id="error" className="text text-danger"></h6>
        </form>
        <h6  className="text text-danger">Flat with {flatId} does not exist</h6>
      </div>
    </div>
    :<div style={{height:"460px",backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
    <h2 className="text-primary container">Search Flat</h2>
      <hr />
      <div className="form-group container">
        <form className="col-3" onSubmit={handleBtnClick}>
        <label className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</label>
                <input
                 name="flatid"
                type="number"
                min="1" max='10000'
                className="form-control"
                value={flatId}
                onInput={formValidate}
                onChange={(e) =>setFlatId(e.target.value)}
                placeholder="Flat ID"
                />
                <button id="getbtn" style={{margin:"10px 0px"}} className='btn btn-success'>Search</button>
                <h6 id="error" className="text text-danger"></h6>
        </form>
        <h6  className="text text-danger">{msg}</h6>
      </div>
    </div>
  );
}

export default FlatById;