package com.example.ue_6_ewingerbenischke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Task4 : AppCompatActivity() {
    private lateinit var viewModel: ScoreboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)

        viewModel = ViewModelProvider(this)[ScoreboardViewModel::class.java]

        val teamAScoreTextView = findViewById<TextView>(R.id.team_a_score_textview)
        val teamBScoreTextView = findViewById<TextView>(R.id.team_b_score_textview)
        val teamAIncreaseButton = findViewById<Button>(R.id.team_a_increase_button)
        val teamADecreaseButton = findViewById<Button>(R.id.team_a_decrease_button)
        val teamBIncreaseButton = findViewById<Button>(R.id.team_b_increase_button)
        val teamBDecreaseButton = findViewById<Button>(R.id.team_b_decrease_button)
        val teamAResetButton = findViewById<Button>(R.id.team_a_reset_button)
        val teamBResetButton = findViewById<Button>(R.id.team_b_reset_button)

        teamAScoreTextView.text = viewModel.teamAScore.toString()
        teamBScoreTextView.text = viewModel.teamBScore.toString()

        teamAIncreaseButton.setOnClickListener {
            viewModel.increaseTeamAScore()
            teamAScoreTextView.text = viewModel.teamAScore.toString()
        }

        teamBIncreaseButton.setOnClickListener {
            viewModel.increaseTeamBScore()
            teamBScoreTextView.text = viewModel.teamBScore.toString()
        }

        teamADecreaseButton.setOnClickListener {
            viewModel.decreaseTeamAScore()
            teamAScoreTextView.text = viewModel.teamAScore.toString()
        }

        teamBDecreaseButton.setOnClickListener {
            viewModel.decreaseTeamBScore()
            teamBScoreTextView.text = viewModel.teamBScore.toString()
        }

        teamAResetButton.setOnClickListener {
            viewModel.resetTeamAScore()
            teamAScoreTextView.text = viewModel.teamAScore.toString()
            teamBScoreTextView.text = viewModel.teamBScore.toString()
        }

        teamBResetButton.setOnClickListener {
            viewModel.resetTeamBScore()
            teamAScoreTextView.text = viewModel.teamAScore.toString()
            teamBScoreTextView.text = viewModel.teamBScore.toString()
        }
    }
}


class ScoreboardViewModel : ViewModel() {
    var teamAScore = 0
    var teamBScore = 0

    fun increaseTeamAScore() {
        teamAScore++
    }

    fun decreaseTeamAScore() {
        teamAScore--
    }

    fun decreaseTeamBScore() {
        teamBScore--
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