// Estilos
import "./Header.scss";

// React
import React from "react";
import { withRouter } from "react-router-dom";

const logo = "/assets/images/pageLogo.png";

const Header = ({ history }) => {
  return (
    <div className="Header__container">
      <div className="Header__page-info">
        <img src={logo} alt="logo"/>
        <h3 onClick={() => history.push("/")  }>Votación Electrónica</h3>
      </div>
      <div className="Header__voter-info">
        <p>Cristian Camilo Mateus Fierro</p>
        <small>1033792101</small>
      </div>
    </div>
  );
};

export default withRouter(Header);
