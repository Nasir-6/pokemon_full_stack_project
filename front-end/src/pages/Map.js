import React from "react";
import userSprite from "../images/ashSprite.png";
import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faArrowRight, faArrowLeft, faArrowUp, faArrowDown } from "@fortawesome/free-solid-svg-icons";



export default function Map() {

  const [userPosition, setUserPostion] = useState(10);

  let gridIndexes = []; 
  // This array will have indexes from 1-GridLength^2 e.g [1,2,3, .... 98, 99, 100] - this is made via the for loop below
  const GRIDLENGTH = 10;
  for (let i = 1; i <= GRIDLENGTH ** 2; i++) {
    gridIndexes.push(i);
  }

  const grids = gridIndexes.map((index) => {
    if (index == userPosition) {
      return <div className={`oneGrid user-grid`}></div>;
    } else {
      return <div className={`oneGrid`}></div>;
    }
  });

  const moveRight = () => {
    
    const isOnRightEdge = (userPosition%GRIDLENGTH == 0)
    if(!isOnRightEdge){
      setUserPostion(userPosition+1)
    } else{
      console.log('User is on the right edge');
    }
  }

  const moveLeft = () => {
    const isOnLeftEdge = (userPosition%GRIDLENGTH == 1)
    if(!isOnLeftEdge){
      setUserPostion(userPosition-1)
    } else{
      console.log('User is on the left edge');
    }
  }

  const moveUp = () => {
    const isOnTopEdge = (userPosition>0 && userPosition<=GRIDLENGTH)
    if(!isOnTopEdge){
      setUserPostion(userPosition-GRIDLENGTH)
    } else{
      console.log('User is on the top edge');
    }
    
  }

  const moveDown = () => {
    const isOnBottomEdge = (userPosition>(GRIDLENGTH*(GRIDLENGTH-1)) && userPosition<=GRIDLENGTH**2)
    if(!isOnBottomEdge){
      setUserPostion(userPosition+GRIDLENGTH)
    } else{
      console.log('User is on the bottom edge');
    }
    
  }


  // =============== WILD POKEMON GENERATOR CODE =================

  // UseEffect for running ilPokenmonID - when userPosition changes 
  const [spriteUrl, setSpriteUrl] = useState("")
  const [wildPokemonId, setWildPokemonId] = useState(1)
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
  // Run above useEffect on mount aswell as when wildPokemonId changes state (i.e grabSprite when wildPokemonId change )

  // Function to generate wildPokemonId (between 1 and 493)
  const wildPokemonIdGenerator = () => {

      //generate probability 
      const wildPokemonProbability = Math.random();
      if(wildPokemonProbability >= 0.6){
          // if more than 0.6 - set to found and also set id - 
          setWildPokemonId(Math.floor(Math.random() * 493) + 1);
          setFoundWildPokemon(true)
          
      } else if(wildPokemonProbability < 0.6){
          setSpriteUrl(null); // set to null so previous pokemon not shown!!
          setFoundWildPokemon(false)
      }  
  }



  useEffect(()=>{
    wildPokemonIdGenerator();
  }, [userPosition])








  return (
    <div className="map-page">
      <div className="grid-container">
        {grids}
      </div>

      <div className="moves-container">
        
        <FontAwesomeIcon icon={faArrowUp} onClick={moveUp} className="btn up-btn"/> 
        <FontAwesomeIcon icon={faArrowRight} onClick={moveRight} className="btn right-btn"/> 
        <FontAwesomeIcon icon={faArrowDown} onClick={moveDown} className="btn down-btn"/> 
        <FontAwesomeIcon icon={faArrowLeft} onClick={moveLeft} className="btn left-btn"/> 
        <img src={userSprite} alt="User sprite" className="user-sprite" />
      </div>

      <div className="wild-pokemon-container">
      {foundWildPokemon ? <img src={spriteUrl} alt=""/> : <p>No wild pokemon found</p>}
      </div>
    </div>
  );
}
