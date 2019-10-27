// React
import React from 'react'
import { Link } from 'react-router-dom'

const Home = () => {
    return (
        <div>
            <h1>Enrutamiento temporal</h1>
            <ul>
                <li><Link to="/candidateElection">candidateElection</Link></li>
                <li><Link to="/candidateAdmin">candidateAdmin</Link></li>
                <li><Link to="/electionAdmin">electionAdmin</Link></li>
                <li><Link to="/electionResults">electionResults</Link></li>
                <li><Link to="/idSignIn">idSignIn</Link></li>
            </ul>
        </div>
    )
}

export default Home
