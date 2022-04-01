import { Link } from 'react-router-dom';
import POKEPALS from '../images/POKEPALS.png';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom'


export default function Navbar({currentUser, updateCurrentUser}) {


  // NEED THIS TO USE NAVIGATE COMMAND
  const navigate = useNavigate();

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(()=>{
    if(currentUser == null){
      setIsLoggedIn(false);
    } else {
      setIsLoggedIn(true);
    }
  }, [currentUser])


  const handleLogoutButtonClick = () => {
    console.log('Logging OUt');
    updateCurrentUser(null);
    navigate("/");
  }


  return (
    <div className="navbar">
      <div className="navbar-left">
        <p>
        <a href='./'>< img src = {POKEPALS} width="auto" height="65px" alt= "Logo"/></a>
        </p>
      </div>
      <div className="navbar-right">
        <Link to="/" className="btn">Home</Link>
        { isLoggedIn ? <button className='btn' onClick={handleLogoutButtonClick}>Logout</button> : <Link to="/login" className="btn">Login</Link>}
        { isLoggedIn ? <></> : <Link to="/signup" className='btn'>Sign up</Link>}
      </div>
    </div>
  );
}
