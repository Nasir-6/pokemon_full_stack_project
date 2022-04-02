import React from 'react'


//passing in the single pokemon as a prop
export const Pokemon = ({pokemon}) => {
  return (
    <div className="pokemonCard">
      <h3 className='card-title'>{pokemon.name}</h3>
      <div className='card-img-container'>
        <img src={pokemon.sprite_link} alt= {`Image of ${pokemon.name}`} className="pokemon-sprite" />
      </div>
      <br/>
      <p>{`National Pokedex Number: #${pokemon.pokeapi_id}`}</p>
      <br/>
      <p>{`Pokemon HP: ${pokemon.hp}`}</p>
      <p>{`Pokemon Level: ${pokemon.level}`}</p>
    </div>
  )
}
