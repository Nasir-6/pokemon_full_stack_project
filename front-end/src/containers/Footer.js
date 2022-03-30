
// export default function Footer() {
//   return (
//     <div>Footer</div>
//   )
// }

import React from "react";
import "../App.css"
import POKEPALS from "../images/POKEPALS.png"


const Footer = () => {
    return (
        <footer className="footer-container">
            <ul>
  <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
  <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
  <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
  <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
</ul>
            
              <img className="footer-logo" src={POKEPALS} alt="pokepals logo"></img>
            

            <div className="footer-middle">
            <a href="#" class="fa fa-facebook"></a>
            <a href="#" class="fa fa-twitter"></a>
            </div>

            <div className="footer-right">
              <p>Copyright</p>
              <span className="copyright-symbol">©</span>
            </div>
                
        </footer> 
    );
};

export default Footer;