import React from 'react'
import { useState, useEffect } from 'react'
import userSprite from '../images/ashSprite.png'
import Footer from '../containers/Footer';
import home from '../images/home.jpeg';
import home_background from '../images/home_background.webp'
import pikachu from '../images/pikachu.png'
import green_background from '../images/green_background.png'
import pikachu_sleep from '../images/pikachu_sleep.jpeg'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faGamepad } from "@fortawesome/free-solid-svg-icons";
import { useNavigate } from 'react-router-dom'




export default function Home({currentUser}) {

  const navigate = useNavigate();

  const handleStartButton = () =>{
    if(currentUser==="" || currentUser== null){
      navigate("/login")
    } else{
      navigate("/map")
    }
  }

  return (
    <div className="home-container">
      <div className="home-background-overlay">
        <h2 className="home-title">Welcome to PokePals </h2>

        <p className="home-text">
          With new games, new updates, and new ways to play, join one of the
          biggest communities in gaming and start catching pokemon today!
        </p>

        <button className="home-btn btn" onClick={handleStartButton}>
          {" "}
          <FontAwesomeIcon icon={faGamepad} /> START GAME
        </button>
      </div>

      {/* <img src={pikachu_sleep} alt="User sprite" className="home_background" /> */}
    </div>

    // <div className="userSprite">
    //   {/* <img src = "" alt = "User sprite"/> */}
    // </div>
  );
}
