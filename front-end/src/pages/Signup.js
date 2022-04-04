import React from 'react';
import {useState} from 'react';
import { useNavigate } from 'react-router-dom'
import charmander from '../images/charmander.png';


//may need to change classNames to increase sizing of boxes or just one part?


//Taking information from the user and setting that as currentUser (state)
//Taking that information and updating our database - addingTrainer & Post request
//catching the error if same email is added 
//flagging it to the user as well
export default function Signup(createCurrentUser) {


//use this to navigate to login page
const navigate =useNavigate();


// set the state
const [name,setName]= useState("");
const [email,setEmail] = useState("");
const [password,setPassword]= useState("");
const [invalidInputWarning, setInvalidInputWarning] = useState("");


const addTrainer = async (newTrainerDetails) => {

  const trainer = await fetch("http://localhost:8080/trainer", {
  method:"POST",
  headers:{
    'Content-Type':'application/json'
  },
  body: JSON.stringify(newTrainerDetails)
  })
  .then(response => {
  if (response.status >= 200 && response.status <= 299) {
    console.log(response);
  } else {
    console.log(response);
    throw Error(response.statusText);
  }
  })
  .catch(error => setInvalidInputWarning("Invalid Email or Password"))

  return trainer;
  }


//handle the user pressing the signup button

  const handleSignupButton = async (event) =>{
    event.preventDefault();
    setInvalidInputWarning("")

//creating new trainer object to be passed onto the backend
    const newTrainerDetails = {
      "name":name,
      "email": email,
      "password": password 
    }

    navigate("/Login");
    
    
  }



  return (
    
    <div className='login-page'>
      <h1>Sign up</h1>
    
      <form  action="post" className='signup-form'>      
      <input type="text" className="signup-inputs" placeholder="Choose username"required></input>
      <input type="text" className="signup-inputs" placeholder="Enter valid email address" required></input>
      <input type="password" className="signup-inputs" placeholder="Password" required></input>
      {/* <input type="password" className="signup-inputs" placeholder="Confirm" required></input> */}

      {/* <p className="invalidText">{invalidInputWarning}</p> */}
      <input type="submit" name="login" id="login-btn" className='btn signup-submit-btn' value="Sign up"/>
      </form>

      <img src={charmander} alt="charmander" />

    </div>
    
  )
}
