import React from 'react'
import { useState, useEffect } from 'react'
import userSprite from '../images/ash_sprite.png'
import Footer from '../containers/Footer';
import home from '../images/home.jpeg';
import home_background from '../images/home_background.webp'
import pikachu from '../images/pikachu.png'
import green_background from '../images/green_background.png'
import pikachu_sleep from '../images/pikachu_sleep.jpeg'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faGamepad } from "@fortawesome/free-solid-svg-icons";




export default function Home() {

  return (
    <div className="home-container">
      <h2 className="home-title">Welcome to PokePals </h2>

      <p className="home-text">
        With new games, new updates, and new ways to play, join one of the
        biggest communities in gaming and start pokemoning today!
      </p>

      <a href="./login">
        <button className="home-btn">
          {" "}
          <FontAwesomeIcon icon={faGamepad} /> START GAME
        </button>
      </a>

      <img src={pikachu_sleep} alt="User sprite" className="home_background" />
    </div>

    // <div className="userSprite">
    //   {/* <img src = "" alt = "User sprite"/> */}
    // </div>
  );
}
