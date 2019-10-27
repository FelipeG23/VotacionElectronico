// DevExtreme
import Form, {
  ButtonItem,
  GroupItem,
  SimpleItem
} from "devextreme-react/form";

// React
import React, { Fragment, useState } from "react";

const IdLogin = () => {
  const [voterDataState] = useState({ id: null });

  const handleVoterLogin = (e) => {
    e.preventDefault();
    console.log(voterDataState)
  }

  return (
    <Fragment>
      <form onSubmit={(e) => handleVoterLogin(e)}>
        <Form
          formData={voterDataState}
          labelLocation="top"
          showColonAfterLabel={false}
        >
          <GroupItem showColonAfterLabel={true} labelLocation="top">
            <SimpleItem dataField="id" editorType={"dxTextBox"} />
          </GroupItem>
          <ButtonItem
            buttonOptions={{
              text: "Guardar",
              type: "Success",
              useSubmitBehavior: true
            }}
            horizontalAlignment="center"
          />
        </Form>
      </form>
    </Fragment>
  );
};

export default IdLogin;
