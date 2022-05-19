import React from 'react';
import {useState} from 'react';
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from '../Constants';
import charmander from '../images/charmander.png';


//may need to change classNames to increase sizing of boxes or just one part?


//Taking information from the user and setting that as currentUser (state)
//Taking that information and updating our database - addingTrainer & Post request
//catching the error if same email is added 
//flagging it to the user as well
export default function Signup() {


//use this to navigate to login page
const navigate = useNavigate();


// set the state
const [name,setName]= useState("");
const [email,setEmail] = useState("");
const [password,setPassword]= useState("");
const [invalidInputWarning, setInvalidInputWarning] = useState("");


const addTrainerToDb = async (newTrainerDetails) => {
  // console.log(newTrainerDetails);
  const trainer = await fetch(SERVER_URL + "/trainer", {
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
  .catch(error => setInvalidInputWarning("User email is already in use"))

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
      "password": password,
      "sprite_link": "replace with actual sprite link"
    }

    // console.log(newTrainerDetails);
    addTrainerToDb(newTrainerDetails);

    navigate("/Login");
    
  }

  const handleNameChange = (event) =>{
    setName(event.target.value);
  }

  const handleEmailChange = (event) =>{
    setEmail(event.target.value);
  }

  const handlePasswordChange = (event) =>{
    setPassword(event.target.value);
  }


  return (
    
    <div className='login-page'>
      <h1>Sign up</h1>
    
      <form action="post" className='signup-form' onSubmit={handleSignupButton}>      
      <input type="text" className="signup-inputs" placeholder="Choose username" onChange={handleNameChange}required></input>
      <input type="email" className="signup-inputs" placeholder="Enter email address" onChange={handleEmailChange}required></input>
      <input type="password" className="signup-inputs" placeholder="Password" onChange={handlePasswordChange}required></input>
      {/* <input type="password" className="signup-inputs" placeholder="Confirm" required></input> */}

      {/* <p className="invalidText">{invalidInputWarning}</p> */}
      <input type="submit" name="signup" id="signup-btn" className='btn signup-submit-btn' value="Sign up"/>
      </form>

      <img src={charmander} alt="charmander" />

    </div>
    
  )
}
