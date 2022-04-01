import React from 'react'
import { useState } from 'react';
import { useNavigate } from 'react-router-dom'
import squirtle from '../images/squirtle.png';


export default function Login({updateCurrentUser}) {

  // NEED THIS TO USE NAVIGATE COMMAND
  const navigate = useNavigate();


  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [invalidInputWarning, setInvalidInputWarning] = useState("");

  const getTrainerIfDetailsAreValid = async (trainerDetails) => {
    const trainer = await fetch("http://localhost:8080/trainer/login",{
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



  return (
    <div className='login-page'>
      <h1>Login</h1>

      <form  action="post" className='login-form' onSubmit={handleSubmitButton}>
      <input type="text"  className="login-inputs" placeholder="Enter email address" onChange={handleEmailChange} required></input>
      <input type="password"  className="login-inputs" placeholder="Enter password" onChange={handlePasswordChange} required></input>
      <p className="invalidText">{invalidInputWarning}</p>
      <input type="submit" name="login" id="login-btn" className='btn login-submit-btn' value="Login"/>
      </form>

      <img src={squirtle} alt="spurtle image" />


    </div>
  )
}
