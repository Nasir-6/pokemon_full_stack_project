import { useState ,useEffect } from 'react'
import { Pokemon } from '../components/Pokemon';

export default function Pokedex({currentUser}) {

  //testing
  console.log(currentUser.id)

  const [userPokemon, setUserPokemon] = useState([]);

  useEffect(()=> {
fetch(`http://localhost:8080/pokemon/trainer/${currentUser.id}`)
.then(response => response.json())
//setting the state with setUserPokemon
.then(data => setUserPokemon(data))
//when currentUser changes the useEffect runs
  },[currentUser]);
  
//data is within userPokemon and we want to map the array to display the pokemons

//the rendered list will be in pokemonList 

const pokemonList = userPokemon.map((pokemon) => {
return (
//we need to make a component called Pokemon which has a singular pokemon 
//the details are passes down as a prop to the pokemon component and the details are stored in the pokemon variable

<Pokemon pokemon={pokemon}
key={pokemon.id}/>
)

})




  return (
    <div className="pokedex-page">
    <h2>Manage your pokémon team</h2>
    <h3>{`Hi ${currentUser.name}`}</h3>
    <div>Pokedex</div>

    <div className="all-pokemon-container">
      {/* pokemonList has the list of pokemon */}
      {pokemonList}
      </div>
   


    


    </div>
  )
}
