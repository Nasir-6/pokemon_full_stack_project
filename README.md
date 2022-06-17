# PokePals Full Stack Project

By Hajr, Nasir, Rachel and Shirhan.

## Table of contents
<!--ts-->
* [Project Description](#project-description)
* [Local Setup Instructions](#local-setup-instructions)
* [Features](#features)
    * [Professional and Responsive UI](#professional-and-responsive-ui)
    * [Functional Login System](#functional-login-system)
    * [Intutive Booking System](#intuitive-booking-system)
* [Future Improvements](#future-improvements)
* [What we learnt](#what-we-learnt)
* [Contributors](#contributors)

<!--te-->



## Project Description

This is the front-end for the [Health First back-end project.](https://github.com/Nasir-6/health-first-back-end) (originally produced by [Aoife, Hajr, Jake, Michael and Suraya](https://github.com/Jake-Raffe/Back-end_Project))
It is a doctor appointment booking system allowing doctors to book, cancel or update appointments as well as allow both doctors and patients to view their upcoming appointments.

This project was the front-end group project as part of the Bright Network Technology Academy - Full Stack Bootcamp (Cohort 4). It utilised the previously developed back-end project from another group with the intention to work with an unseen API and develop a React front-end for it.

This front-end project was built using HTML, CSS and ReactJs.

If currently deployed it can be found [here](https://nasir-6.github.io/Tic-Tac-Toe-Group-Project/). Please email at mfinasir06@gmail.com if it isn't or there are any issues.
If you would like to deploy the application locally please follow the instructions below.

## Local Setup Instructions

1. Clone the Back-end Repo:
   ```git clone git@github.com:Nasir-6/health-first-back-end.git```
2. Follow the commands in the [database_setup_queries.md](https://github.com/Nasir-6/health-first-back-end/blob/main/database_setup_queries.md) file to create the database.
3. Run the back-end using the IntelliJ IDE - the server port should configure to 8080 by default (if not please kill any other processes to free up this port).
4. Clone the Front-end Repo:
   ```git clone git@github.com:Nasir-6/health-first-front-end-project.git```
5. Open the "health-first-front-end-project" folder using VsCode and run ```npm install``` to install the required node modules.
6. Run the front-end application using ```npm start``` - this should run the application on localhost:3000
7. Double check you are not running the production build by checking the console log in your browser telling you to make sure the server is running on port 8080.
8. Enjoy! ;)



## Features
### Professional and Responsive UI
![Responsive UI features](https://github.com/Nasir-6/health-first-front-end-project/blob/main/demo_gifs/responsive_UI_demo.gif)
- Professional website design with the NHS color scheme in mind
- About/Services pages to give users more information about the company
- Responsive design with a collapsing Navbar to allow use on mobile devices

### Functional Login System
![Login system features](https://github.com/Nasir-6/health-first-front-end-project/blob/main/demo_gifs/login_system_demo.gif)
- Users can log in as a doctor or patient
- They both their name and id in order to login successfully
- Warning text is shown if incorrect details are used
- Redirects to the user's dedicated page to show all appointments
- Keeps users logged in until they log out

### Intuitive Booking System
![booking system features](https://github.com/Nasir-6/health-first-front-end-project/blob/main/demo_gifs/Booking_system_demo.gif)
- Clean design laying out all current appointments
- Intuitive booking system allowing doctors to update, cancel or create new appointments
- Use of various input types such as dates, time and dropdown menus to aid the process


## What we learnt
- How to plan and develop an application and use HTML, CSS and ReactJS to develop a booking system application
- How to use GitHub for collaboration (using branches and dealing with merge conflicts)
- Connecting an external Java/SpringBoot Back-end to a React front-end
- The structuring of a React application to ensure states are at a suitable level within the app - This aims to minimise prop-drilling whilst still allowing access to states where needed
- The use of conditional rendering to show certain buttons or pages in different scenarios
- The use of React Hooks (UseEffect, UseState)
- The use of SessionStorage to keep track of logged-in user
- The use of ReactRouter to create a multipage React App
- The importance of developing the back-end with the front-end application in mind
- Security issues arising from using the url as a means of holding user information
- The use of flexbox, grid and media queries to create a responsive web application (including a collapsing navbar menu)
- The access to the various input types within HTML forms (date, time etc.)

## Future improvements
- Write tests for JS/ReactJs features
- Complete the SignUp section to allow new doctors/patients to register
- Show expired appointments and upcoming appointments (date order)
- Use Redux to manage states throughout the application (Useful for keeping track of logged-in user across the app, rather than using SessionStorage)
- Fix logout bug when refreshing page

## Contributors

- [Hajr](https://github.com/hdelli)
- [Nasir](https://github.com/Nasir-6)
- [Rachel](https://github.com/RKaurB)
- [Shirhan](https://github.com/shirhan25)
