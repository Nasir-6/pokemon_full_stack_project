
import './App.css';
import Navbar from './containers/Navbar';
import Footer from './containers/Footer';
import Home from './pages/Home';
import Login from './pages/Login';
import Map from './pages/Map';
import Signup from './pages/Signup';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'


function App() {
  return (
    <Router>
      <div className="app">
        <Navbar/>
        {/* <i class="fa-solid fa-x fa-3x"></i> */}

        <Routes>
          <Route exact path="/" element={<Home/>} />
          {/* <Route exact path="/doctor/:doctorName" element={<DoctorPage/>} /> */}
          
          <Route exact path="/login" element={<Login/>}/>
          <Route exact path="/signup" element={<Signup/>} />
          <Route exact path="/map" element={<Map/>} />

        </Routes>

        <Footer/>
      </div>
    </Router>
  );
}

export default App;
