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
import React, { useState, useEffect } from "react";

// Redux
import { connect } from "react-redux";
import { setErrorToast } from "../../../store/actions/UIActions";

// Servicios
import { validateVoter, getAllVoters } from "../../../shared/services/VoteServices";

const logo = "/assets/images/loginLogo.png";

const IdLogin = ({ setErrorToast }) => {
  const [voterDataState] = useState({ id: null });

  useEffect(() => {
    getAllVotersOnLoad()
  }, [])

  const getAllVotersOnLoad = async () => {
    await getAllVoters().then(response => {
      console.log(response)
    }).catch(error => {
      setErrorToast(error.toString())
      console.error(error.toString)
    })
  }

  const handleVoterLogin = async e => {
    e.preventDefault();
    await validateVoter(voterDataState.id)
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        setErrorToast(error.toString())
        console.error(error);
      });
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

export default connect(
  null,
  { setErrorToast }
)(IdLogin);
