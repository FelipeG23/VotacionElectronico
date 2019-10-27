// Ant Design
import { notification } from "antd";

// React
import React, { useEffect } from "react";

// Redux
import { connect } from "react-redux";

const ErrorHandler = ({ errorMessage, children }) => {
  useEffect(() => {
    if (!errorMessage) {
      return;
    }
    const args = {
      message: 'Notification Title',
      description:
        'I will never close automatically. I will be close automatically. I will never close automatically.',
      duration: 0,
    };
    notification.open(args);
  }, [errorMessage]);

  return <React.Fragment>{children}</React.Fragment>;
};

const mapStateToProps = state => {
  return {
    errorMessage: state.uiReducer.error
  };
};

export default connect(mapStateToProps)(ErrorHandler);
