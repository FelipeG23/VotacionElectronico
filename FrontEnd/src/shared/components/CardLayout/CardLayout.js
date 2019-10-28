// Estilos
import './CardLayout.scss'

// React
import React from 'react'

const CardLayout = ({children}) => {
    return (
        <div className="CardLayout__container">
            {children}
        </div>
    )
}

export default CardLayout
