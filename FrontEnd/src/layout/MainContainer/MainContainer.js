// Componentes Propios
import Header from "../Header/Header";
import ComponentContainer from "../../shared/components/ComponentContainer/ComponentContainer";
import Home from "../../modules/Home/Home";
import NotFound from "../../shared/components/404NotFound/NotFound";
import IdLogin from "../../modules/Authentification/IdLogin/IdLogin";
import CandidateElection from "../../modules/Vote/CandidateElection/CandidateElection";
import ElectionResults from "../../modules/Vote/ElectionResults/ElectionResults";
import CandidateAdmin from "../../modules/Administration/CandidateAdmin/CandidateAdmin";
import ElectionAdmin from "../../modules/Administration/ElectionAdmin/ElectionAdmin";

// Estilos
import "./MainContainer.scss";

// React
import React from "react";

// React Router
import { Switch, Route } from "react-router-dom";

const MainContainer = () => {
  return (
    <div className="MainContainer__container">
      <Header />
      <div className="MainContainer__component-container">
        <Switch>
          <Route path="/" exact component={Home} />
          <Route
            path="/candidateElection"
            exact
            render={() => (
              <ComponentContainer title="Elecciónes" isVotingProcess>
                <CandidateElection />
              </ComponentContainer>
            )}
          />
          <Route
            path="/candidateAdmin"
            exact
            render={() => (
              <ComponentContainer title="Administrador Candidatos">
                <CandidateAdmin />
              </ComponentContainer>
            )}
          />
          <Route
            path="/electionAdmin"
            exact
            render={() => (
              <ComponentContainer title="Administrador Elecciones">
                <ElectionAdmin />
              </ComponentContainer>
            )}
          />
          <Route
            path="/electionResults"
            exact
            render={() => (
              <ComponentContainer title="Resultado Elecciones">
                <ElectionResults />
              </ComponentContainer>
            )}
          />
          <Route
            path="/idLogin"
            exact
            render={() => (
              <ComponentContainer title="Login Votante" isVotingProcess>
                <IdLogin />
              </ComponentContainer>
            )}
          />
          <Route component={NotFound} />
        </Switch>
      </div>
    </div>
  );
};

export default MainContainer;
