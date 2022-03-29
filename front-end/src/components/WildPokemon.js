import React from 'react'
import { useState, useEffect } from 'react';

export default function WildPokemon() {

    const [spriteUrl, setSpriteUrl] = useState("")
    const [wildPokemonId, setWildPokemonId] = useState("1")
    const [foundWildPokemon, setFoundWildPokemon] = useState(true);

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

    // Function to generate wildPokemonId (between 1 and 493)
    const wildPokemonIdGenerator = () => {

        //generate probability 
        const wildPokemonProbability = Math.random();
        console.log(wildPokemonProbability);
        if(wildPokemonProbability >= 0.6){
            // if more than 0.6 - set to found and also set id - 
            setFoundWildPokemon(true)
            setWildPokemonId(Math.floor(Math.random() * 493) + 1);
        } else if(wildPokemonProbability < 0.6){
            setFoundWildPokemon(false)
        }
        
        // else set found to false (used for conditional rendering)
        
    }

  return (
    <>
    {foundWildPokemon ? <img src={spriteUrl} alt=""/> : <p>No wild pokemon found</p>}
    <button onClick={wildPokemonIdGenerator}>Generate New Pokemon</button>   
    </>
  )
}
