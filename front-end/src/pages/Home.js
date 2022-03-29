import React from 'react'
import { useState, useEffect } from 'react'

export default function Home() {

    const [spriteUrl, setSpriteUrl] = useState("")

    // fetch a pokemon and console.log the url
    const grabPokemonSprite = async () => {
        const newSpriteUrl = await fetch("https://pokeapi.co/api/v2/pokemon/2/")
        .then(response => response.json())
        .then(onePokemon => onePokemon.sprites.front_default)

        setSpriteUrl(newSpriteUrl);

    }

    useEffect(()=>{
        grabPokemonSprite();
    },[])

    


  return (
    <>
      <h2>Home</h2>
      <img
        src={spriteUrl}
        alt=""
      />      
    </>
  );
}
