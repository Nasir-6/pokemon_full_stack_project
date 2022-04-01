import React from 'react'

export default function Pokedex({currentUser}) {

  console.log(currentUser.id)
  return (
    <>
    <h2>Manage your pokémon team</h2>
    <div>Pokedex</div>

    <div className="all-cards"></div>
    <div className="card-container"></div>


    


    </>
  )
}
