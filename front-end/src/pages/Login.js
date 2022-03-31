import React from 'react'

export default function Login() {
  return (
    <div className='login-page'>
      <h1>Login</h1>

      <form  action="Name" className='login-form'>
      <input type="text"  className="inputs" placeholder="Enter email address"></input>

      <input type="text"  className="inputs" placeholder="Enter password"></input>

      <input type="submit" name="login" id="login-btn" className='btn'/>

      </form>

      <img src="" alt="" />

    </div>
  )
}
