
// export default function Footer() {
//   return (
//     <div>Footer</div>
//   )
// }
import React from "react";
import "../App.css"
import POKEPALS from "../images/POKEPALS.png"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faFacebook, faTwitter, faInstagram } from "@fortawesome/free-brands-svg-icons"


const Footer = () => {
    return (
        <footer className="footer-container">

          
            <img className="footer-logo" src={POKEPALS} alt="pokepals logo"></img>
            
            <div className="footer-middle">
            <ul>
              <li><a href="#">< FontAwesomeIcon icon={faFacebook} className="social-icon"/></a></li>
              <li><a href="#">< FontAwesomeIcon icon={faTwitter} className="social-icon" /></a></li>
              <li><a href="#"><FontAwesomeIcon icon={faInstagram} className="social-icon"/></a></li>
            </ul>
            </div>
            <div className="footer-right">
              <p>Copyright © 2022 PokePals, All rights reserved.</p>
            </div>
                
        </footer> 
    );
};

export default Footer;