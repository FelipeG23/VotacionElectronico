import * as actionTypes from '../types/UITypes'
import { ToastTypeEnum } from '../../shared/enums/ToastTypeEnum'

export const setErrorToast = (message) => dispatch => {
    const toastData = {
        type: ToastTypeEnum.Danger,
        message: message
    }
    dispatch({
        type: actionTypes.SET_ERROR_TOAST,
        payload: toastData
    })
}

export const setSuccessToast = (message) => dispatch => {
    const toastData = {
        type: ToastTypeEnum.Success,
        message: message
    }
    dispatch({
        type: actionTypes.SET_SUCCESS_TOAST,
        payload: toastData
    })
}

export const setWarningToast = (message) => dispatch => {
    const toastData = {
        type: ToastTypeEnum.Warning,
        message: message
    }
    dispatch({
        type: actionTypes.SET_WARNING_TOAST,
        payload: toastData
    })
}