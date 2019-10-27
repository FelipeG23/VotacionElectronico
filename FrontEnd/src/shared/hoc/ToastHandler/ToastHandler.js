// React
import React, { useEffect } from "react";

// Redux
import { connect } from "react-redux";

import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { ToastTypeEnum } from "../../enums/ToastTypeEnum";

const ToastHandler = ({ toastRedux, children }) => {
  useEffect(() => {
    if (!toastRedux.message) {
      return;
    }
    switch (toastRedux.type) {
      case ToastTypeEnum.Warning:
        toast.warn(toastRedux.message);
        break;
      case ToastTypeEnum.Danger:
        toast.error(toastRedux.message);
        break;
      case ToastTypeEnum.Success:
        toast.success(toastRedux.message);
        break;
      default:
        toast("No se envio mensaje");
    }
  }, [toastRedux]);

  return (
    <React.Fragment>
      <ToastContainer />
      {children}
    </React.Fragment>
  );
};

const mapStateToProps = state => {
  return {
    toastRedux: state.uiReducer.toast
  };
};

export default connect(mapStateToProps)(ToastHandler);
