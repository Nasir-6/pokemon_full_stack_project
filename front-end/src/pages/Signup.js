import React from 'react';
import charmander from '../images/charmander.png';


//may need to change classNames to increase sizing of boxes or just one part?
export default function Signup() {
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

      <img src={charmander} alt="charmander image" />

    </div>
    
  )
}
