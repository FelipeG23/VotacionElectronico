import * as actionType from "../types/VoteTypes";

const initialState = {
  user: 1033792101,
  name: "Cristian Mateus"
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actionType.SET_USER:
      return { ...state };
    default:
      return { ...state };
  }
};

export default reducer;
