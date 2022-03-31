import React from 'react';
import POKEPALS from '../images/POKEPALS.png';


export default function Navbar() {
  return (
    <div className="navbar">
      <div className="navbar-left">
        <p>
        < img src = {POKEPALS} width="auto" height="100px" alt= "Logo"/>

        </p>
      </div>

      <div className="navbar-right">
        <button className="btn">Home</button>
        <button className="btn">Login</button>
        <button className='btn'>Sign up</button>
      </div>
    </div>
  );
}
