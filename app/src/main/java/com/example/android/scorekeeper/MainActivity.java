package com.example.android.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamRedScore = 0;
    int teamBlueScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fieldGoalRed(View view){
        updateTeamRedScore(3);
    }

    public void updateAll(){

    }

    /**
     * Takes in an int and updates teamRedScore, before passing the new score to displayTeamRedScore
     * @param score - score to be added to original teamRedScore.
     */
    private void updateTeamRedScore(int score){
        teamRedScore = teamRedScore + score;
        displayTeamRedScore(teamRedScore);
    }

    private void displayTeamRedScore(int score){
        TextView teamRedScoreboard = (TextView) findViewById(R.id.team_red_score_textview);
        teamRedScoreboard.setText(score);
    }
}
