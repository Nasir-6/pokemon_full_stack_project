
import './App.css';
import Navbar from './containers/Navbar';
import Footer from './containers/Footer';
import Home from './pages/Home';
import Login from './pages/Login';
import Map from './pages/Map';
import Signup from './pages/Signup';
import Pokedex from './pages/Pokedex';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import { useState, useEffect } from 'react';


function App() {

  const [currentUser, setCurrentUser] = useState("");

  //Store the currentUser in sessionStorage everytime it changes
  useEffect(()=>{
    // What about when you logout how do you deal with this!!!!
    if(currentUser != ""){
      sessionStorage.setItem("currentUser", JSON.stringify(currentUser))
    }
  }, [currentUser])



  // On mount (when Refreshed) retrieve the currentUser stored in sessionStorage 
  useEffect(()=>{
    // First grab from sessionStorage - Parse into a object as stored as a string in sessionStorage
    const currentUserInSessionStorage = JSON.parse(sessionStorage.getItem("currentUser"))
    console.log(currentUserInSessionStorage)
    setCurrentUser(currentUserInSessionStorage)
  }, [])

  const logout = () => {
    setCurrentUser(null)
  }





  return (
    <Router>
      <div className="background-overlay">
        <div className="app">
          <Navbar />
          <button className='btn' onClick={logout}>Logout</button>

          <Routes>
            <Route exact path="/" element={<Home />} />
            <Route exact path="/login" element={<Login updateCurrentUser={(update)=> setCurrentUser(update)} />}/>
            <Route exact path="/signup" element={<Signup updateCurrentUser={(update)=> setCurrentUser(update)}/>} />
            <Route exact path="/map" element={<Map currentUser={currentUser}/>} />
            <Route exact path="/pokedex" element={<Pokedex currentUser={currentUser}/>} />
          </Routes>

          <Footer />
        </div>
      </div>
    </Router>
  );
}

export default App;
