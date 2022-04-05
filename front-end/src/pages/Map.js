import userSprite from "../images/ashSprite.png";
import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faArrowRight, faArrowLeft, faArrowUp, faArrowDown } from "@fortawesome/free-solid-svg-icons";
import surprisedPikachu from '../images/surprised_pikachu.jpeg'



export default function Map({currentUser}) {

  const [userPosition, setUserPostion] = useState(10);

  let gridIndexes = []; 
  // This array will have indexes from 1-GridLength^2 e.g [1,2,3, .... 98, 99, 100] - this is made via the for loop below
  const GRIDLENGTH = 32;
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
  const [wildPokemon, setWildPokemon] = useState({
    trainer_id: null,
    name: null,
    pokeapi_id: null,
    sprite_link: null,
    hp: null,
    level: null
  });
  const [wildPokemonId, setWildPokemonId] = useState(1);
  const [foundWildPokemon, setFoundWildPokemon] = useState(true);

  // fetch a pokemon and console.log the url

  const grabPokemon = async () => {
    const newPokemon = await fetch(`https://pokeapi.co/api/v2/pokemon/${wildPokemonId}/`)
    .then(response => response.json())

    // use Slice and upperCase to make first letter UpperCase
    setWildPokemon({
      trainer_id: currentUser.id,
      name: newPokemon.name.charAt(0).toUpperCase() + newPokemon.name.slice(1),
      pokeapi_id: wildPokemonId,
      sprite_link: newPokemon.sprites.front_default,
      hp: 64,
      level: 10
    });
}

  useEffect(()=>{
      grabPokemon();
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
          setWildPokemon({
            trainer_id: currentUser.id,
            name: null,
            pokeapi_id: null,
            sprite_link: null,
            hp: null,
            level: null
          }); // set to null so previous pokemon not shown!!
          setFoundWildPokemon(false)
      }  
  }



  useEffect(()=>{
    wildPokemonIdGenerator();
  }, [userPosition])


  const addPokemonToDb = async () => {
    const result = await fetch("http://localhost:8080/pokemon",{
      method:"POST",
      headers:{
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(wildPokemon)
    })
    .then(response => {
      if (response.status >= 200 && response.status <= 299) {
        return response.json();
      } else {
        console.log(response);
        throw Error(response.statusText);
      }
    })
    .catch(error => console.log(error))

    console.log(result);
    
  }







  return (
    <div className="map-page">
      {currentUser == null ? (
        <div className="surprised-pikachu-page">
          <img src={surprisedPikachu} alt={`Image of surprised Pikachu`} className="surprised-pikachu" />
          <p>You can't catch Pokémon if you haven't logged in! Please login!</p>
        </div>
      ) : (
        <>
          <div className="grid-container">{grids}</div>

          <div className="moves-container">
            <FontAwesomeIcon
              icon={faArrowUp}
              onClick={moveUp}
              className="btn up-btn"
            />
            <FontAwesomeIcon
              icon={faArrowRight}
              onClick={moveRight}
              className="btn right-btn"
            />
            <FontAwesomeIcon
              icon={faArrowDown}
              onClick={moveDown}
              className="btn down-btn"
            />
            <FontAwesomeIcon
              icon={faArrowLeft}
              onClick={moveLeft}
              className="btn left-btn"
            />
            <img src={userSprite} alt="User sprite" className="user-sprite" />
          </div>

          <div className="wild-pokemon-container">
            {foundWildPokemon ? (
              <>
                <img
                  src={wildPokemon.sprite_link}
                  alt=""
                  className="wildPokemon-sprite"
                />
                <p>{`A wild ${wildPokemon.name} appeared.`}</p>
                <p>{`Level: ${wildPokemon.level}`}</p>
                <button className="btn" onClick={addPokemonToDb}>
                  Catch
                </button>
              </>
            ) : (
              <p>No wild pokemon found</p>
            )}
          </div>
        </>
      )}
    </div>
  );
}
