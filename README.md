# PokéPals Full Stack Project

By Hajr, Nasir, Rachel, Shirhan and Suraya.

## Table of contents
<!--ts-->
* [Project Description](#project-description)
* [Local Setup Instructions](#local-setup-instructions)
* [Features](#features)
    * [Pokémon Themed UI](#pokemon-themed-ui)
    * [Functional Login/Signup System](#functional-loginsignup-system)
    * [2D Map System and Personal Pokédex](#2d-map-system-and-personal-pokdex)
* [Future Improvements](#future-improvements)
* [What we learnt](#what-we-learnt)
* [Contributors](#contributors)

<!--te-->



## Project Description

This is a full-stack project which utilises the [PokéAPI](https://pokeapi.co/) to attempt to build a Pokémon game based off the formerly known fan game - [Pokémon Crater](https://bulbapedia.bulbagarden.net/wiki/Pok%C3%A9mon_Vortex).  

This project was the full-stack group project as part of the Bright Network Technology Academy - Full Stack Bootcamp (Cohort 4).

The front-end was built using HTML, CSS and ReactJs, whilst the back-end was developed using Java, SpringBoot and a PostgreSQL database.

[//]: # (If currently deployed it can be found [here]&#40;https://nasir-6.github.io/Tic-Tac-Toe-Group-Project/&#41;. Please email at mfinasir06@gmail.com if it isn't or there are any issues.)
If you would like to deploy the application locally please follow the instructions below.

## Local Setup Instructions

1. Clone the Repo:
   ```git clone git@github.com:Nasir-6/pokemon_full_stack_project.git```
2. Follow the commands in the [sql_queries.md](https://github.com/Nasir-6/pokemon_full_stack_project/blob/main/pokemon-back-end/sql_queries.md) file to create the database.
3. Run the back-end by opening the "pokemon-back-end" folder using the IntelliJ IDE and running it - the server port should configure to 8080 by default (if not please kill any other processes to free up this port).
4. Open the "front-end" folder using VsCode and run ```npm install``` to install the required node modules.
5. Run the front-end application using ```npm start``` - this should run the application on localhost:3000
6. Double check you are not running the production build by checking the console log in your browser telling you to make sure the server is running on port 8080.
7. Enjoy! ;)



## Features
### Pokemon Themed UI
![Pokemon UI](https://github.com/Nasir-6/pokemon_full_stack_project/blob/main/demo-gifs/pokepal-theme-demo.gif)
- Website designed with the official Pokémon color scheme in mind
- Utilises the [PokéAPI](https://pokeapi.co/) to grab official sprites of Pokémon

### Functional Login/Signup System
![Login system features](https://github.com/Nasir-6/pokemon_full_stack_project/blob/main/demo-gifs/login-demo.gif)
- Users can signup for a new account, using a username, email and password 
- They can then login using their email and password and begin catching Pokémon to fill in their Pokédex
- Inputs are validated and popups are used to warn users
- Keeps users logged in until they log out

### 2D Map System and Personal Pokédex
![booking system features](https://github.com/Nasir-6/pokemon_full_stack_project/blob/main/demo-gifs/map-demo.gif)
- A 2D map system allowing users to move around and catch various Pokémon
- Boundary detection to prevent user leaving the map
- Randomised Pokémon, level and HP during each new encounter
- All caught Pokémon are saved in the Pokédex and can be viewed/released by the user



## What we learnt
- How to plan and develop a full-stack application which also utilises an external API
- How to use GitHub for collaboration (using branches and dealing with merge conflicts)
- Connecting an external API as well as a Java/SpringBoot Back-end to a React front-end
- The structuring of a React application to ensure states are at a suitable level within the app - This aims to minimise prop-drilling whilst still allowing access to states where needed
- The use of conditional rendering to show certain buttons or pages in different scenarios
- The use of React Hooks (UseEffect, UseState)
- Better understanding of the React Lifecycle and Virtual DOM - due to development of the map mechanics
- The use of SessionStorage to keep track of logged-in user
- The use of ReactRouter to create a multi-page React App
- The access to the various input types within HTML forms (date, time etc.) - allowing basic validation of inputs 

## Future improvements
- Write tests for JS/ReactJs features
- Have Encryption for user details in the database - perhaps using Spring Security
- Use Redux to manage states throughout the application (Useful for keeping track of logged-in user across the app, rather than using SessionStorage)
- Email confirmation during signup
- Integrate a Pokémon Battle system - was a stretch goal but deemed very difficult due to the nature of the game mechanics
- Improved Map mechanics - prevent user from jumping/climbing buildings/trees


## Contributors

- [Hajr](https://github.com/hdelli)
- [Nasir](https://github.com/Nasir-6)
- [Rachel](https://github.com/RKaurB)
- [Shirhan](https://github.com/shirhan25)
- [Suraya](https://github.com/SurayaHasan)
