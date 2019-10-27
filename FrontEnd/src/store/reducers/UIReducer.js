import * as actionTypes from '../types/UITypes'

const initialState = {
    error : null
}

const reducer = (state = initialState, action) => {
    switch(action.type){
        case actionTypes.SET_ERROR:
            return {...state, error: action.payload}
        default: 
            return state
    }
}

export default reducer