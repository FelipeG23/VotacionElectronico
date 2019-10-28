import 'devextreme/dist/css/dx.common.css';
import 'devextreme/dist/css/dx.light.css';
// Componentes Propios
import MainContainer from "./layout/MainContainer/MainContainer";
// DevExtreme
import 'devextreme/dist/css/dx.common.css';
import 'devextreme/dist/css/dx.light.css';
// React
import React from "react";
// Toast
import { toast } from 'react-toastify';

toast.configure()

function App() {
  return (
    <div className="App">
      <MainContainer />
    </div>
  );
}

export default App;
