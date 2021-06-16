import React ,{useState,useEffect} from 'react';
import axios from 'axios';
function UpdateFlat() {

    {/*let initialFlat={
        flatAddress:{
            houseNo:0,
            street:'',
            city:'',
            state:'',
            pin:0,
            country:''
            },
        flatAvailability:'',
        flatCost:0,
        landlord:{landlordId:0}
        };
    let [Flat,setFlat]=useState(initialFlat);
    let [flatId,setFlatId]=useState(0);
    let [msg,setMsg]=useState('');
    let [id,setId]=useState(0);
    useEffect(()=>
    {
        const URL=`http://localhost:8080/flat/updateflat/${flatId}`
        axios.put(URL,Flat).then(response=>
            {
                setMsg(response.data)
                setFlat(initialFlat)
                setId(0);
            }).catch(error=>console.log(error.response))
    },[id])

    useEffect(() => {
        const URL = `http://localhost:8080/flat/viewflatbyid/${flatId}`;
        axios
          .get(URL)
          .then((response) => {
            setFlat(response.data);
          })
          .catch((error) => console.log(error.response));
      }, [btnId]);
   const handleBtnClick=(event)=>
    {
        event.preventDefault()
        setId(1)
        
    }*/}

    return (
        {/*(flatId!==0)?<>
        <div style={{backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
        <h2 className='text-primary container'>Update flat details</h2>
            <hr/>
            <form method="put" onSubmit={handleBtnClick}  o className="col-4 container">
                <div className='form-group'>
                    <label>Enter ID</label>
                    <input placeholder="Landlord ID" type='number' className='form-control' value={Flat.landlord.landlordId} onChange={e=>setFlat({...Flat,landlord:{...Flat.landlord,landlordId:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Flat ID</label>
                    <input placeholder="Flat Number" type='number' className='form-control' value={Flat.flatAddress.houseNo} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,houseNo:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Street</label>
                    <input placeholder="Street name" className='form-control' value={Flat.flatAddress.street} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,street:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Pin code</label>
                    <input placeholder="If other than India--> 999999" type='number' max='999999' min='100000' className='form-control' value={Flat.flatAddress.pin} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,pin:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>City</label>
                    <input placeholder="City name" className='form-control' value={Flat.flatAddress.city} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,city:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>State</label>
                    <input placeholder="State name" className='form-control' value={Flat.flatAddress.state} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,state:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Country</label>
                    <input placeholder="Country name"  className='form-control' value={Flat.flatAddress.country} onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,country:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Monthly rent</label>
                    <input placeholder="in RS" className='form-control' value={Flat.flatCost} onChange={e=>setFlat({...Flat,flatCost:e.target.value})}/>
                </div>
                <div className='form-group'>
                    <label>Flat Availability</label>
                    <div>
                        <div className="form-check form-check-inline">
                        <input className="form-check-input" type="radio" name="flatA" id="flatYes" value="Yes" onChange={e=>setFlat({...Flat,flatAvailability:e.target.value})}/>
                            <label className="form-check-label" for="flatYes">
                                Yes
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <input className="form-check-input" type="radio" name="flatA" id="flatNo" value="No" onChange={e=>setFlat({...Flat,flatAvailability:e.target.value})}/>
                            <label className="form-check-label" for="flatNo">
                                No
                            </label>
                        </div>
                    </div>
                </div>
                <button className='btn btn-success mt-2'>Update Flat</button>
            </form>
            <h6>{msg}</h6>
        </div>
           
        </>:<>
        <div>
        <h2 className="text-primary container">Enter Flat ID</h2>
      <hr />
      <div className="form-group container">
        <form className="col-3" onSubmit={handleBtnClick}>
        <label className="text text-primary" style={{margin:"10px 0px"}}>Confirm your Identification</label>
                <input
                type="number"
                min="1" max='10000'
                className="form-control"
                value={flatId}
                onChange={(e) =>setFlatId(e.target.value)}
                placeholder="Flat ID"
                />
                <button  style={{margin:"10px 0px"}} className='btn btn-success'>Search</button>
        </form>
            </div>

        </div>
        
        </>*/}
        
    )
}
           

export default UpdateFlat