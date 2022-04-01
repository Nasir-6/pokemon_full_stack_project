import React from 'react'


//passing in the single pokemon as a prop
export const Pokemon = ({pokemon}) => {
  return (
    <div className="pokemonCard">
<h3>{pokemon.name}</h3>
<p>{`National Pokedex Number: #${pokemon.pokeapi_id}`}</p>
<img src={pokemon.sprite_link} alt= {`Image of ${pokemon.name}`} className="pokemon-sprite" />
<p>{`Pokemon HP: ${pokemon.hp}`}</p>
<p>{`Pokemon Level: ${pokemon.level}`}</p>




    </div>
  )
}
