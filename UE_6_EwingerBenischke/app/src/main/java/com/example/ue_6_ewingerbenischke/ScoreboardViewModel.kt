package com.example.ue_6_ewingerbenischke

import androidx.lifecycle.ViewModel

class ScoreboardViewModel : ViewModel() {
    var teamAScore = 0
    var teamBScore = 0

    fun increaseTeamAScore() {
        teamAScore++
    }

    fun decreaseTeamAScore() {
        if(teamAScore > 0){
            teamAScore--
        }

    }

    fun decreaseTeamBScore() {
        if(teamBScore > 0){
            teamBScore--
        }
    }

    fun increaseTeamBScore() {
        teamBScore++
    }

    fun resetTeamAScore() {
        teamAScore = 0
    }

    fun resetTeamBScore() {
        teamBScore = 0
    }
}