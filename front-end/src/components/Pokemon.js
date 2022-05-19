import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faTrash } from "@fortawesome/free-solid-svg-icons";

// Passing in the single pokemon as a prop


export const Pokemon = ({ pokemon, releasePokemon }) => {

  const handleReleaseButton = ()=>{    
    releasePokemon(pokemon.id)
  }

  return (
    <div className="pokemonCard">
      <h3 className="card-title">{pokemon.name}</h3>
      <div className="card-img-container">
        <img src={pokemon.sprite_link} alt={`Image of ${pokemon.name}`} className="pokemon-sprite" />
      </div>
      <br />
      <p>{`National Pokedex Number: #${pokemon.pokeapi_id}`}</p>
      <br />
      <p className='pokemon-hp'>{`HP: ${pokemon.hp}`}</p>
      <p className='pokemon-level'>{`Level: ${pokemon.level}`}</p>

      <button className="release-btn" onClick={handleReleaseButton}>Release</button>
    </div>
  );
};
