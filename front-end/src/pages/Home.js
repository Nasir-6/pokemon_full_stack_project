import React from 'react'
import { useState, useEffect } from 'react'
import userSprite from '../images/ash_sprite.png'
import Footer from '../containers/Footer';
import home from '../images/home.jpeg';
import home_background from '../images/home_background.webp'
import pikachu from '../images/pikachu.png'


export default function Home() {

  return (
    <>
      <h2>Welcome to PokePals</h2>
      <p>With new games, new updates, and new ways to play, 
      join one of the biggest communities in gaming and start pokemoning today!</p>
      <img src = {pikachu} alt = "User sprite" className="home_background"/>


      <div className="userSprite">
        {/* <img src = "" alt = "User sprite"/> */}
      </div> 
      
    </>
  );
}
