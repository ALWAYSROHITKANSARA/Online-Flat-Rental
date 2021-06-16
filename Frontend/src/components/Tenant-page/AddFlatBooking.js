import React ,{useState,useEffect} from 'react'
import axios from 'axios'
import { useHistory } from "react-router-dom";
// const validateForm = errors => {
//     let valid = true;
//     Object.values(errors).forEach((val) => val.length > 0 && (valid = false));
//     return valid;
// };

const formStyle = {
    backgroundColor: "#fff",
    padding: "60px",
    width: '500px',
    marginLeft: '54px'
};
var dates = new Date();
    var date = dates.getDate();
    if(date<10)
    {
      date='0' + date;
    }
    var month = dates.getMonth()+1;
    if(month<10)
    {
      month='0' + month;
    }

    var year = dates.getFullYear();
    var minDate=year+"-"+month+"-"+date;

 function AddFlatBooking(){
    
    let initialFlat={
        bookingFromDate: null,
        bookingToDate: null ,
        flat:{flatId:null},
        tenantId:{tenantId:null},

        }
    let [Flat,setFlat]=useState(initialFlat)
    // let [id,setId]=useState(0)
    const history = useHistory();
    // useEffect(()=>
    // {
    //     const URL=`http://localhost:8080/FlatBookingCtrl/addFlatBooking`
    //     axios.post(URL,Flat).then(response=>
    //         {
    //             setFlat(initialFlat)
    //             setId(0);
    //             history.push('/addbooking')
    //         }).catch(error=>console.log(error.response))
    // },[id])


   const handleBtnClick=(event)=>
    {
        event.preventDefault()
        const URL=`http://localhost:8080/FlatBookingCtrl/addFlatBooking`
        axios.post(URL,Flat).then(response=>
            {
                alert(`Flat Booking successfully `)
                setFlat(initialFlat)
                // setId(0);
                history.push('/addbooking')
            }).catch(error=>console.log(error.response))
        //history.push('/addbooking')
        
    }

    // submitHandler = (event) => {
    //     event.preventDefault()
    //     console.log(this.state);
    //     this.setState({...this.state ,id : 1} );
    //    // if (validateForm(this.state.errors)) {
    //         let booking = {
    //             tenantId:{tenantId: this.state.tenantId.tenantId,},
    //             flat:{flatId : this.state.flat.flatId,},
    //             bookingFromDate: this.state.bookingFromDate,
    //             bookingToDate: this.state.bookingToDate,
                
    //         }
    //         axios.post('http://localhost:8080/FlatBookingCtrl/addFlatBooking',booking)
    //             .then(response => {
    //                 console.log(response);
    //                 alert("Details Updated Successfully")
    //             })
    //             .catch(error => {
    //                 console.log(error);
    //             }, [this.state.id]); 
    //     // }
    // }

        //const {errors} = this.state;
        //const { tenantId, flat , bookingFromDate, bookingToDate} = this.state
        return (
            <div style={{backgroundColor: "#1a85bf", minHeight: '100vh'}}>
                <div className="row mx-auto mt-5" >
                    <div className="row mx-auto mt-5">
                        <div style={formStyle} className="card">
                            <h1>Booking Form</h1>
                            <hr/>
                            <form className="form-group" onSubmit={handleBtnClick} noValidate>
                            <div>
                                
                                <div className="col mt-2">
                                    <label className="form-label">Tenant Id</label>
                                    <input className="form-control"
                                        type="number"
                                        range min='1'
                                        name="tenant Id"
                                        value={Flat.tenantId.tenantId}
                                        onChange={e=>setFlat({...Flat,tenantId:{tenantId : e.target.value}})}
                                        placeholder="Enter Tenant Id"
                                        required
                                    ></input>
                                </div>
                                <div className="col mt-2">
                                    <label className="form-label">Flat Id</label>
                                    <input className="form-control"
                                        type="number"
                                        range min='1'
                                        name="flat Id"
                                        value={Flat.flat.flatId}
                                        onChange={e=>setFlat({...Flat,flat:{flatId : e.target.value}})}
                                        placeholder="Enter Flat Id"
                                        required
                                    ></input>
                                </div>
                                
                                <div className="row mt-2">
                                <div className="col">
                                    <label className="form-label">Book From Date</label>
                                    <input className="form-control"
                                        type="Date"
                                        min={minDate}
                                        name="bookingfromDate"
                                        value={Flat.bookingFromDate}
                                        onChange={e=>setFlat({...Flat,bookingFromDate: e.target.value})}
                                        required
                                    ></input>
                                </div>
                                <div className="col">
                                    <label className="form-label">Book To Date</label>
                                    <input className="form-control"
                                        type="Date"
                                        min={minDate}
                                        name="bookingtoDate"
                                        value={Flat.bookingToDate}
                                        onChange={e=>setFlat({...Flat,bookingToDate: e.target.value})}
                                        required
                                    ></input>
                                </div>
                                </div>
                                </div>
                                <div className="col-15 container">
                                    <button type="submit" className="btn btn-primary mt-3">Confirm Booking</button>
                                </div>
                                </form>
                                </div>
                    </div>
                </div>
            </div>

        );
    }




export default AddFlatBooking