package com.example.android.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int teamRedScore = 0;
    int teamBlueScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Resets all variables and displays back to zero
     */
    public void updateAll(View view){
        teamRedScore = 0;
        teamBlueScore = 0;
        updateTeamRedScore(0);
        updateTeamBlueScore(0);
    }

    /**
     * onClick method for Team Red's field goal button. passes 3 points to the updateTeamRedScore
     * @param view
     */
    public void fieldGoalRed(View view){
        scoreToast(0, "Red team");
        updateTeamRedScore(3);
    }

    /**
     * onClick method for Team Blue's field goal button. passes 3 points to the updateTeamBlueScore
     * @param view
     */
    public void fieldGoalBlue(View view){
        scoreToast(0, "Blue team");
        updateTeamBlueScore(3);
    }

    /**
     * onClick method for Team Red's touchdown button. passes 6 points to the updateTeamBlueScore
     * @param view
     */
    public void touchdownRed(View view){
        scoreToast(1, "Red team");
        updateTeamRedScore(6);
    }

    /**
     * onClick method for Team Blue's touchdown button. passes 6 points to the updateTeamBlueScore
     * @param view
     */
    public void touchdownBlue(View view){
        scoreToast(1, "Blue team");
        updateTeamBlueScore(6);
    }

    /**
     * onClick method for Team Red's extra point button. passes 1 points to the updateTeamRedScore
     * @param view
     */
    public void extraPointRed(View view){
        scoreToast(2, "Red team");
        updateTeamRedScore(1);
    }

    /**
     * onClick method for Team Blue's extra point button. passes 1 points to the updateTeamBlueScore
     * @param view
     */
    public void exraPointBlue(View view){
        scoreToast(2, "Blue team");
        updateTeamBlueScore(1);
    }

    /**
     * onClick method for Team Red's went for two button. passes 2 points to the updateTeamBlueScore
     * @param view
     */
    public void wentForTwoRed(View view){
        scoreToast(3, "Red team");
        updateTeamRedScore(2);
    }

    /**
     * onClick method for Team Blue's went for two button. passes 2 points to the updateTeamBlueScore
     * @param view
     */
    public void wentForTwoBlue(View view){
        scoreToast(3, "Blue team");
        updateTeamBlueScore(2);
    }

    /**
     * onClick method for Team Red's touch back button. passes 2 points to the updateTeamBlueScore
     * @param view
     */
    public void touchBackRed(View view){
        scoreToast(4, "Red team");
        updateTeamRedScore(2);
    }

    /**
     * onClick method for Team Blue's touch back button. passes 2 points to the updateTeamBlueScore
     * @param view
     */
    public void touchBackBlue(View view){
        scoreToast(4, "Blue team");
        updateTeamBlueScore(2);
    }


    /**
     * Displays a toast based on the type of points scored and the team that scored them.
     * @param caseCall used to decide what statement to toast.
     * @param teamName used to identify the team in the toast.
     */
    private void scoreToast(int caseCall, String teamName){
        String announcement = "";
        switch(caseCall){
            case 0:
                announcement = teamName + " kicks one straight through the uprights!";
                break;
            case 1:
                announcement = teamName + " passes it for a touchdown!";
                break;
            case 2:
                announcement = teamName + ", the extra point is good.";
                break;
            case 3:
                announcement = teamName + " succeeds on the trick play!";
                break;
            case 4:
                announcement = teamName + " sacks the QB in the endzone!";
                break;
        }

        Toast toast = Toast.makeText(this, announcement, Toast.LENGTH_SHORT);
        toast.show();
    }



    /**
     * Takes in an int, adds its value to the global variable teamRedScore, and sets the display of Team Red to the new global variable value.
     * @param points - int variable to be added to original teamRedScore value.
     */
    private void updateTeamRedScore(int points){
        String score = "";
        teamRedScore = teamRedScore + points;
        TextView teamRedScoreboard = (TextView) findViewById(R.id.team_red_score_textview);
        if (teamRedScore < 10){
            score = "0" + teamRedScore;
        }
        else {
            score = Integer.toString(teamRedScore);
        }
        teamRedScoreboard.setText(score);
    }

    /**
     * Takes in an int, adds its value to the global variable teamBlueScore, and sets the display of Team Blue to the new global variable value
     * @param points - int variable to be added to original teamRedScore value.
     */
    private void updateTeamBlueScore(int points){
        String score = "";
        teamBlueScore = teamBlueScore + points;
        TextView teamBlueScoreboard = (TextView) findViewById(R.id.team_blue_score_textview);
        if (teamBlueScore < 10){
            score = "0" + teamBlueScore;
        }
        else {
            score = Integer.toString(teamBlueScore);
        }
        teamBlueScoreboard.setText(score);
    }

}
