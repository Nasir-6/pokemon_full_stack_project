import React from 'react';
import { Link } from 'react-router-dom';
import POKEPALS from '../images/POKEPALS.png';


export default function Navbar() {
  return (
    <div className="navbar">
      <div className="navbar-left">
        <p>
        < img src = {POKEPALS} width="auto" height="65px" alt= "Logo"/>
        </p>
      </div>
      <div className="navbar-right">
        <Link to="/" className="btn">Home</Link>
        <Link to="/login" className="btn">Login</Link>
        <Link to="/signup" className='btn'>Sign up</Link>
      </div>
    </div>
  );
}
