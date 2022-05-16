
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

          
            <a href='./'> <img className="footer-logo" src={POKEPALS} alt="pokepals logo"></img></a>
            <div className="footer-middle">
              <a href="https://www.facebook.com/PokemonUKGB/?brand_redir=230809307041021">< FontAwesomeIcon icon={faFacebook} className="social-icon"/></a>
              <a href="https://twitter.com/Pokemon?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor">< FontAwesomeIcon icon={faTwitter} className="social-icon" /></a>
              <a href="https://www.instagram.com/pokemon/?hl=en"><FontAwesomeIcon icon={faInstagram} className="social-icon"/></a>
            </div>
            <div className="footer-right">
              <p>Copyright © 2022 PokePals</p>
            </div>
                
        </footer> 
    );
};

export default Footer;