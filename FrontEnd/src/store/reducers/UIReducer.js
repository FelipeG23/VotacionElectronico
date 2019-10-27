import * as actionTypes from "../types/UITypes";

const initialState = {
  toast: {
    type: null,
    message: null
  }
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.SET_ERROR_TOAST ||
      actionTypes.SET_SUCCESS_TOAST ||
      actionTypes.SET_WARNING_TOAST:
      return { ...state, toast: action.payload };
    default:
      return state;
  }
};

export default reducer;
