import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./component/Navbar/Navbar";
import MainContainer from "./component/MainContainer/MainContainer";
import Login from "./component/Login/Login";

function App() {
  return (
    <Router>
      <div className="App">
        {/* Navbar sera toujours visible */}
        <Navbar />
        <Routes>
          {/* Route par défaut pour la page principale */}
          <Route path="/reservation" element={<MainContainer />} />
          {/* Route pour la page de login */}
          <Route path="/login" element={<Login />} />
          {/* Exemple de dashboard */}
          <Route path="/dashboard" element={<h1>Bienvenue au Dashboard</h1>} />
          {/* Exemple de SignUp */}
          <Route path="/SignUp" element={<h1>In progress </h1>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;