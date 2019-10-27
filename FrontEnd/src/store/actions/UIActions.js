import * as actionTypes from '../types/UITypes'

export const setError = (error) => dispatch => {
    dispatch({
        type: actionTypes.SET_ERROR,
        payload: error
    })
}