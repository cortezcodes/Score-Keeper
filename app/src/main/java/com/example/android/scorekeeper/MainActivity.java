package com.example.android.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int teamOneScore = 0;
    int teamTwoScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fieldGoalOne(View view){
        addPointsTeamOne(3);
    }

    public void touchdownTeamOne(View view){

    }

    public void extraPointTeamOne(View view){

    }

    public void wentForTwoTeamOne(View view){

    }

    public void fieldGoalTeamTwo(View view){

    }

    public void touchdownTeamTwo(View view){

    }

    public void extraPointTeamtwo(View view){

    }

    public void wentForTwoTeamTwo(View view){

    }

    public void reset(View view){

    }

    private void addPointsTeamOne(int points){

    }

    private void addPointsTeanTwo(int points){

    }

    private void updateScorboardOne(String score){

    }

    private void updateScoreboardTwo(String score){

    }

    private void updateAll(){

    }
}
