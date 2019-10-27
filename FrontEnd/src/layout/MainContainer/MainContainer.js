// Componentes Propios
import Header from '../Header/Header'
import Home from '../../modules/Home/Home'
import NotFound from '../../shared/components/404NotFound/NotFound'
import IdSignIn from '../../modules/Authentification/IdSignIn/IdSignIn'
import CandidatElection from '../../modules/Vote/CandidateElection/CandidateElection'
import ElectionResults from '../../modules/Vote/ElectionResults/ElectionResults'
import CandidateAdmin from '../../modules/Administration/CandidateAdmin/CandidateAdmin'
import ElectionAdmin from '../../modules/Administration/ElectionAdmin/ElectionAdmin'

// React
import React from 'react'

// React Router
import { Switch, Route } from 'react-router-dom'

const MainContainer = () => {
    return (
        <div>
            <Header/>
            <Switch>
                <Route path="/" exact component={Home}/>
                <Route path="/candidatElection" exact component={CandidatElection}/>
                <Route path="/candidateAdmin" exact component={CandidateAdmin}/>
                <Route path="/electionAdmin" exact component={ElectionAdmin}/>
                <Route path="/electionResults" exact component={ElectionResults}/>
                <Route path="/idSignIn" exact component={IdSignIn}/>
                <Route component={NotFound}/>
            </Switch>
        </div>
    )
}

export default MainContainer
