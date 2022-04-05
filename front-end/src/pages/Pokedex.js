import { useState ,useEffect, useRef } from 'react';
import { Pokemon } from '../components/Pokemon';

export default function Pokedex({ currentUser }) {
  // Testing
  // console.log(currentUser.id);

  const [userPokemon, setUserPokemon] = useState([]);

  const isMounted = useRef(false);


  const getPokemonList= async () => {
    await fetch(`http://localhost:8080/pokemon/trainer/${currentUser.id}`)
    .then((response) => response.json())
    // Setting the state with setUserPokemon
    .then((data) => setUserPokemon(data));
  // When currentUser changes the useEffect runs
   }

  useEffect(() => {
    
    if (!isMounted.current && currentUser!="") {
      getPokemonList();
      isMounted.current = true;
    }
    // this return is only on cleanup - when you unmount component (i.e refreshing page)
    return function cleanup(){isMounted.current = false}
  }, [currentUser]);

  // Maybe useEffect on unmounting

  // useEffect running on prop change 
  // Never have a useEffect on a propChange 
 // delete button function



 const deletePokemonFromDb = async (pokemonId) =>{
  await fetch(`http://localhost:8080/pokemon/${pokemonId}`,
    {
    method: "DELETE",
  });
  // Update rendered list after delete
  getPokemonList();
 }




  // Data is within userPokemon and we want to map the array to display the pokemon

  // The rendered list will be in pokemonList

  const pokemonList = userPokemon.map((pokemon) => {
    return (
      // We need to make a component called Pokemon which has a singular pokemon
      // The details are passes down as a prop to the pokemon component and the details are stored in the pokemon variable

      <Pokemon key={pokemon.id} pokemon={pokemon} releasePokemon ={(pokemonId) => {deletePokemonFromDb(pokemonId)}} />
    );
  });

  return (
    <div className="pokedex-page">
      <div className="pokedex-header">
        {/* <h2>{`Hi ${currentUser.name}`}</h2> */}
        <h1>{`${currentUser.name}'s Pokédex`}</h1>
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
