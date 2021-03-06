import React from 'react'
import { useState } from 'react';
import { useNavigate } from 'react-router-dom'
import squirtle from '../images/squirtle.png';
import { SERVER_URL } from '../Constants';


export default function Login({updateCurrentUser}) {

  // NEED THIS TO USE NAVIGATE COMMAND
  const navigate = useNavigate();


  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [invalidInputWarning, setInvalidInputWarning] = useState("");

  const getTrainerIfDetailsAreValid = async (trainerDetails) => {
    const trainer = await fetch(SERVER_URL + "/trainer/login",{
      method:"POST",
      headers:{
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(trainerDetails)
    })
    .then(response => {
      if (response.status >= 200 && response.status <= 299) {
        return response.json();
      } else {
        console.log(response);
        throw Error(response.statusText);
      }
    })
    .catch(error => setInvalidInputWarning("Invalid Email or Password"))

    return trainer;
  }


  
  // Define logic for submit button press
  const handleSubmitButton = async (event) => {
    event.preventDefault();
    setInvalidInputWarning("")

    // Now send email and password back to get checked by Java Backend
    // create trainer details object to be passed back to backend
    const trainerDetails = {
      "email": email,
      "password": password 
    }

    const trainerInDb = await getTrainerIfDetailsAreValid(trainerDetails);
    console.log(trainerInDb)

    if(trainerInDb != undefined){
      updateCurrentUser({
        id: trainerInDb.id,
        name: trainerInDb.name,
        sprite_link: trainerInDb.sprite_link
      })
      navigate("/pokedex");
    }

  }

  const handleEmailChange = (event) =>{
    setEmail(event.target.value);
  }

  const handlePasswordChange = (event) =>{
    setPassword(event.target.value);
  }

  const handleDemoLoginButton = () => {
    document.getElementById("email-input").value= "nasir@gmail.com";
    document.getElementById("password-input").value= "password";
    setEmail("nasir@gmail.com")
    setPassword("password")
  }



  return (
    <div className='login-page'>
      <h1>Login</h1>

      <form  action="post" className='login-form' onSubmit={handleSubmitButton}>
      <input type="email"  id="email-input" className="login-inputs" placeholder="Enter email address" onChange={handleEmailChange} required></input>
      <input type="password"  id="password-input" className="login-inputs" placeholder="Enter password" onChange={handlePasswordChange} required></input>
      <p className="invalidText">{invalidInputWarning}</p>
      <input type="submit" name="login" id="login-btn" className='btn login-submit-btn' value="Login"/>
      <button className='btn demo-login-btn' onClick={handleDemoLoginButton}>Demo Login</button>
      </form>

      <img src={squirtle} alt="spurtle" />


    </div>
  )
}
