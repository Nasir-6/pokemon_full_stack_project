import React from 'react'
import { useState, useEffect } from 'react'

export default function Home() {

    const [spriteUrl, setSpriteUrl] = useState("")
    const [wildPokemonId, setWildPokemonId] = useState("1")

    // fetch a pokemon and console.log the url
    const grabPokemonSprite = async () => {
        const newSpriteUrl = await fetch(`https://pokeapi.co/api/v2/pokemon/${wildPokemonId}/`)
        .then(response => response.json())
        .then(onePokemon => onePokemon.sprites.front_default)

        setSpriteUrl(newSpriteUrl);

    }

    useEffect(()=>{
        grabPokemonSprite();
    },[wildPokemonId])

    useEffect(()=>{
        wildPokemonIdGenerator();
    },[])


    // Function to generate wildPokemonId (between 1 and 493)
    const wildPokemonIdGenerator = () => {
        setWildPokemonId(Math.floor(Math.random() * 493) + 1);
    }



    


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
