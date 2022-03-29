import React from 'react'
import { useState, useEffect } from 'react'
import userSprite from '../images/ash_sprite.png'

export default function Home() {

  return (
    <>
      <h2>Home</h2>
      <div className='userSprite'>
        <img src = {userSprite} alt = "User sprite"/>
      </div> 
    </>
  );
}
