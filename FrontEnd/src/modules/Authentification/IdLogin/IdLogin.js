// DevExtreme
import Form, {
  ButtonItem,
  GroupItem,
  SimpleItem,
  Label,
  RequiredRule,
  PatternRule
} from "devextreme-react/form";

// Estilos
import "./IdLogin.scss";

// React
import React, { useState } from "react";

// Redux
import { connect } from 'react-redux'
import  { setError } from '../../../store/actions/UIActions'

const logo = "/assets/images/loginLogo.png";

const IdLogin = ({setError}) => {
  const [voterDataState] = useState({ id: null });

  const handleVoterLogin = e => {
    e.preventDefault();
    setError('Error en servicio')
  };

  return (
    <div className="IdLogin__container">
      <div className="IdLogin__logo">
        <img src={logo} alt="logo" />
      </div>
      <form onSubmit={e => handleVoterLogin(e)} className="IdLogin__form">
        <Form
          formData={voterDataState}
          labelLocation="top"
          showColonAfterLabel={false}
        >
          <GroupItem showColonAfterLabel={true} labelLocation="top">
            <SimpleItem dataField="id" editorType={"dxTextBox"}>
              <Label text={"Id personal"} />
              <RequiredRule message={"Campo requerido"} />
              <PatternRule
                message={"Sólo digitos minimo 8, máximo 10"}
                pattern={/^[0-9]{8,10}$/}
              />
            </SimpleItem>
          </GroupItem>
          <ButtonItem
            buttonOptions={{
              text: "Iniciar mi voto",
              type: "success",
              useSubmitBehavior: true
            }}
            horizontalAlignment="center"
          />
        </Form>
      </form>
    </div>
  );
};

export default connect(null, { setError })(IdLogin);
