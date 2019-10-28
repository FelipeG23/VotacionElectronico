// Componentes Propios
import CardLayout from "../../../shared/components/CardLayout/CardLayout";
import CandidateCard from "../../../shared/components/CandidateCard/CandidateCard";

// Estilos
import "./CandidateElection.scss";

// Mockups
import { candidates } from "../../../mockups/CandidatesMockup";

// React
import React from "react";

const CandidateElection = () => {
  return (
    <div className="CandidateElection__container">
      <CardLayout>
        {candidates.map(candidate => (
          <CandidateCard key={candidate.id} candidate={candidate} />
        ))}
      </CardLayout>
    </div>
  );
};

export default CandidateElection;
