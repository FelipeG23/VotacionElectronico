import axios from "axios";

const baseURL = "http://192.190.43.117/VotoBack/v1/";

export const getAllVoters = async () => {
  await axios
    .get(`${baseURL}VotantesService/consultarTodosVotantes`)
    .then(response => response.data);
};

export const validateVoter = async voterId => {
  await axios
    .get(`${baseURL}VotantesService/validarVotante/${voterId}`)
    .then(response => response.data);
};

export const saveVote = async (voterId, idCandidate, votingPost) => {
  await axios
    .get(
      `${baseURL}VotantesService/guardarVoto/${voterId}/${idCandidate}/${votingPost}`
    )
    .then(response => response.data);
};
