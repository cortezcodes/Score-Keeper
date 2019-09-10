package com.example.android.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int teamRedScore = 0;
    int teamBlueScore = 0;
    Button redFieldGoalBtn;
    Button redTouchdownBtn;
    Button redExtraPointBtn;
    Button redWentForTwoBtn;
    Button redTouchBackBtn;
    Button blueFieldGoalBtn;
    Button blueTouchDownBtn;
    Button bluExtraPointBtn;
    Button blueWentForTwoBtn;
    Button blueTouchBackBtn;
    Button missedExtraBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redFieldGoalBtn = findViewById(R.id.team_red_field_goal_button);
        redTouchdownBtn = findViewById(R.id.team_red_touchdown_button);
        redExtraPointBtn = findViewById(R.id.team_red_extra_point_button);
        redWentForTwoBtn = findViewById(R.id.team_red_went_for_two_button);
        redTouchBackBtn = findViewById(R.id.team_red_touch_back_button);
        blueFieldGoalBtn = findViewById(R.id.team_blue_field_goal_button);
        blueTouchDownBtn = findViewById(R.id.team_blue_touchdown_button);
        bluExtraPointBtn = findViewById(R.id.team_blue_extra_point_button);
        blueWentForTwoBtn = findViewById(R.id.team_blue_went_for_two_button);
        blueTouchBackBtn = findViewById(R.id.team_blue_touch_back_button);
        missedExtraBtn = findViewById(R.id.missed_extra_point);
        beforeTouchdown();
    }

    /**
     * Resets all variables, displays, and button logic.
     */
    public void updateAll(View view){
        teamRedScore = 0;
        teamBlueScore = 0;
        updateTeamRedScore(0);
        updateTeamBlueScore(0);
        beforeTouchdown();
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
        afterTouchdown(true);
    }

    /**
     * onClick method for Team Blue's touchdown button. passes 6 points to the updateTeamBlueScore
     * @param view
     */
    public void touchdownBlue(View view){
        scoreToast(1, "Blue team");
        updateTeamBlueScore(6);
        afterTouchdown(false);
    }

    /**
     * onClick method for Team Red's extra point button. passes 1 points to the updateTeamRedScore
     * @param view
     */
    public void extraPointRed(View view){
        scoreToast(2, "Red team");
        updateTeamRedScore(1);
        beforeTouchdown();
    }

    /**
     * onClick method for Team Blue's extra point button. passes 1 points to the updateTeamBlueScore
     * @param view
     */
    public void exraPointBlue(View view){
        scoreToast(2, "Blue team");
        updateTeamBlueScore(1);
        beforeTouchdown();
    }

    /**
     * onClick method for Team Red's went for two button. passes 2 points to the updateTeamBlueScore
     * @param view
     */
    public void wentForTwoRed(View view){
        scoreToast(3, "Red team");
        updateTeamRedScore(2);
        beforeTouchdown();
    }

    /**
     * onClick method for Team Blue's went for two button. passes 2 points to the updateTeamBlueScore
     * @param view
     */
    public void wentForTwoBlue(View view){
        scoreToast(3, "Blue team");
        updateTeamBlueScore(2);
        beforeTouchdown();
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

    public void missedExtraPoint(View view){
        scoreToast(5, "");
        beforeTouchdown();
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
            case 5:
                announcement = "The kick goes wide.";
        }

        Toast toast = Toast.makeText(this, announcement, Toast.LENGTH_SHORT);
        toast.show();
    }



    /**
     * Takes in an int, adds its value to the global variable teamRedScore, and sets the display of Team Red to the new global variable value.
     * @param points - int variable to be added to original teamRedScore value.
     */
    private void updateTeamRedScore(int points){
        String score;
        teamRedScore = teamRedScore + points;
        TextView teamRedScoreboard = findViewById(R.id.team_red_score_textview);
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
        String score;
        teamBlueScore = teamBlueScore + points;
        TextView teamBlueScoreboard = findViewById(R.id.team_blue_score_textview);
        if (teamBlueScore < 10){
            score = "0" + teamBlueScore;
        }
        else {
            score = Integer.toString(teamBlueScore);
        }
        teamBlueScoreboard.setText(score);
    }

    /**
     * Sets state of all buttons displayed before a touchdown is scored. Disables the extra point,
     * the went for two, and the missed extra point buttons. Also changes the buttons background to gray.
     */
    private void beforeTouchdown(){
        missedExtraBtn.setEnabled(false);
        redExtraPointBtn.setEnabled(false);
        redWentForTwoBtn.setEnabled(false);
        redFieldGoalBtn.setEnabled(true);
        redTouchdownBtn.setEnabled(true);
        redTouchBackBtn.setEnabled(true);
        blueFieldGoalBtn.setEnabled(true);
        blueTouchDownBtn.setEnabled(true);
        bluExtraPointBtn.setEnabled(false);
        blueWentForTwoBtn.setEnabled(false);
        blueTouchBackBtn.setEnabled(true);
    }

    /**
     * Button logic after a touchdown is scored. All buttons disabled except for the scoring teams
     * extra point, went for two, and missed extra buttons.
     */
    private void afterTouchdown(boolean isRedTouchdown){

        if (isRedTouchdown){
            missedExtraBtn.setEnabled(true);
            redExtraPointBtn.setEnabled(true);
            redWentForTwoBtn.setEnabled(true);
            redFieldGoalBtn.setEnabled(false);
            redTouchdownBtn.setEnabled(false);
            redTouchBackBtn.setEnabled(false);
            blueFieldGoalBtn.setEnabled(false);
            blueTouchDownBtn.setEnabled(false);
            bluExtraPointBtn.setEnabled(false);
            blueWentForTwoBtn.setEnabled(false);
            blueTouchBackBtn.setEnabled(false);
        }
        else{
            missedExtraBtn.setEnabled(true);
            redExtraPointBtn.setEnabled(false);
            redWentForTwoBtn.setEnabled(false);
            redFieldGoalBtn.setEnabled(false);
            redTouchdownBtn.setEnabled(false);
            redTouchBackBtn.setEnabled(false);
            blueFieldGoalBtn.setEnabled(false);
            blueTouchDownBtn.setEnabled(false);
            bluExtraPointBtn.setEnabled(true);
            blueWentForTwoBtn.setEnabled(true);
            blueTouchBackBtn.setEnabled(false);
        }
    }

}
