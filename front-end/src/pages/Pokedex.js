import { useState ,useEffect, useRef } from 'react';
import { Pokemon } from '../components/Pokemon';

export default function Pokedex({ currentUser }) {
  // Testing
  // console.log(currentUser.id);

  const [userPokemon, setUserPokemon] = useState([]);

  const isMounted = useRef(false);

  useEffect(() => {
    if (isMounted.current) {
      fetch(`http://localhost:8080/pokemon/trainer/${currentUser.id}`)
        .then((response) => response.json())
        // Setting the state with setUserPokemon
        .then((data) => setUserPokemon(data));
      // When currentUser changes the useEffect runs
    } else {
      isMounted.current = true;
    }
  }, [currentUser]);

  // Data is within userPokemon and we want to map the array to display the pokemon

  // The rendered list will be in pokemonList

  const pokemonList = userPokemon.map((pokemon) => {
    return (
      // We need to make a component called Pokemon which has a singular pokemon
      // The details are passes down as a prop to the pokemon component and the details are stored in the pokemon variable

      <Pokemon pokemon={pokemon} key={pokemon.id} />
    );
  });

  return (
    <div className="pokedex-page">
      <div className="pokedex-header">
        {/* <h2>{`Hi ${currentUser.name}`}</h2> */}
        <h1>{`${currentUser.name}'s Pokedéx`}</h1>
        {/* Change this to user's chosen trainer sprite */}
        <h2>Manage your Pokémon team</h2>
      </div>
      <div className="all-pokemon-container">
        {/* pokemonList has the list of pokemon */}
        {pokemonList}
      </div>
    </div>
  );
}
