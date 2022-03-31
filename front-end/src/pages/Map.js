import React from "react";
import WildPokemon from "../containers/WildPokemon";
import userSprite from "../images/ash_sprite.png";
import { useEffect, useState } from "react";

export default function Map() {

  const [userPosition, setUserPostion] = useState(10);

  let gridIndexes = []; 
  // This array will have indexes from 1-GridLength^2 e.g [1,2,3, .... 98, 99, 100] - this is made via the for loop below
  const GRIDLENGTH = 10;
  for (let i = 1; i <= GRIDLENGTH ** 2; i++) {
    gridIndexes.push(i);
  }


  // UseEffect for running ilPokenmonID - when userPosition changes 
  useEffect(()=>{
    console.log("userPosition changed")
  }, [userPosition])

  const grids = gridIndexes.map((index) => {
    if (index == userPosition) {
      return <div className={`oneGrid grid-${index} user-grid`}></div>;
    } else {
      return <div className={`oneGrid grid-${index}`}></div>;
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
    const isOnBottomEdge = (userPosition>(GRIDLENGTH*(GRIDLENGTH-1)) && userPosition<=GRIDLENGTH**22)
    if(!isOnBottomEdge){
      setUserPostion(userPosition+GRIDLENGTH)
    } else{
      console.log('User is on the bottom edge');
    }
    
  }




  return (
    <div className="map-page">
      <div className="grid-container">
        {grids}
      </div>

      <div className="moves-container">
        <button className="btn up-btn" onClick={moveUp}>Up</button>
        <button className="btn right-btn" onClick={moveRight}>Right</button>
        <button className="btn down-btn" onClick={moveDown}>Down</button>
        <button className="btn left-btn" onClick={moveLeft}>Left</button>
        <img src={userSprite} alt="User sprite" className="user-sprite" />
      </div>

      <div className="wild-pokemon-container">
        <WildPokemon />
      </div>
    </div>
  );
}
