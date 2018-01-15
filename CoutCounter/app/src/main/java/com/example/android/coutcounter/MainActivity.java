package com.example.android.coutcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView scoreView;
    TextView scoreViewB;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    private void displayForTeamA(int score){
        scoreView.setText(String.valueOf(score));
    }

    private void displayForTeamB(int score){
        scoreViewB.setText(String.valueOf(score));
    }

    public void addFree(View view){
        scoreTeamA ++;
        displayForTeamA(scoreTeamA);
    }

    public void addTwo(View view){
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    public void addThree(View view){
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    public void addFreeB(View view){
        scoreTeamB ++;
        displayForTeamB(scoreTeamA);
    }

    public void addTwoB(View view){
        scoreTeamB += 2;
        displayForTeamB(scoreTeamA);
    }

    public void addThreeB(View view){
        scoreTeamB += 3;
        displayForTeamB(scoreTeamA);
    }

    public void resetScores(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
