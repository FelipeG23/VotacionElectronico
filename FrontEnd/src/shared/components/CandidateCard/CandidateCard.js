// Estilos
import "./CandidateCard.scss";

// React
import React from "react";

const CandidateCard = ({ candidate }) => {
  return (
    <div className="CandidateCard__container">
      <div className="CandidateCard__title">
        <h4>{candidate.name}</h4>
      </div>
      <div
        className="CandidateCard__photo"
        style={{ backgroundImage: `url('${candidate.photo}')` }}
      />
      <div
        className="CandidateCard__party"
        style={{ backgroundImage: `url('${candidate.party}')` }}
      />
    </div>
  );
};

export default CandidateCard;
