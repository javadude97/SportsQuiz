package com.example.android.sportsquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreCounter = 0;

    String toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**This method is called when Question 1 selection is made. All of the above are correct answer*/
    private int computeQuestion1Score() {
        CheckBox bearsCheckbox = (CheckBox) findViewById(R.id.chicago_bears_checkbox);
        boolean countsBears = bearsCheckbox.isChecked();
        CheckBox packersCheckbox = (CheckBox) findViewById(R.id.greenbay_packers_checkbox);
        boolean countsPackers = packersCheckbox.isChecked();
        CheckBox giantsCheckbox = (CheckBox) findViewById(R.id.newyork_giants_checkbox);
        boolean countsGiants = giantsCheckbox.isChecked();
        CheckBox redskinsCheckbox = (CheckBox) findViewById(R.id.washington_redskins_checkbox);
        boolean countsRedskins = redskinsCheckbox.isChecked();
        CheckBox allaboveCheckbox = (CheckBox) findViewById(R.id.all_above_checkbox);
        boolean countsAllabove = allaboveCheckbox.isChecked();


        /**If all four choices are NOT chosen then no points are assigned*/
        if ((countsBears && countsPackers && countsGiants && countsRedskins) || (countsAllabove))
        { scoreCounter +=1;

        } else {
            CheckBox.setChecked(false);   // check false case here
            toastMessage = " Incorrect! Please try again. ";
            getToast();
        }
        return scoreCounter;
    }


    /**This method is called when Question 3 selection is made. Answer is Pittsburgh Steelers*/

    private int computeQuestion3Score()
    {
        RadioButton questionThreeAnswer = findViewById(R.id.pittsburgh_steelers);
        boolean steelersIsChecked = questionThreeAnswer.isChecked();

        if(steelersIsChecked){
            scoreCounter += 1;
        }
        else
        {
            CheckBox.setChecked(false);  // check false answers here
            toastMessage = " Incorrect! Please try again. ";
            getToast();
        }
        return scoreCounter;
    }

    /**This method is called when Question 4 selection is made. Answer is 6 teams*/

    private int computeQuestion4Score() {

        RadioButton questionFourAnswer = findViewById(R.id.six_teams);
        boolean sixteamsIsChecked = questionFourAnswer.isChecked();

        if(sixteamsIsChecked){
            scoreCounter += 1;
        }
        else
        {
            CheckBox.setChecked(false);   // check false answers here
            toastMessage = " Incorrect! Please try again. ";
            getToast();
        }
        return scoreCounter;
    }

    /**This method is called when Question 2 selection is made. Answer is niners*/

    private int computeQuestion2Score() {
        EditText editText = (EditText) findViewById(R.id.user_input);

        String typedInAnswer = editText.getText().toString();

        if (getString(R.string.answer).equalsIgnoreCase(typedInAnswer)) {
            scoreCounter += 1;
        }
        else {
            toastMessage = "Incorrect! Please type again. ";
            getToast();
            scoreCounter =0;
        }
        return  scoreCounter;
    }

    /**This method is calls the toast message*/

    public void getToast()
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        //toast.setGravity(Gravity.BOTTOM|Gravity.RIGHT, 0, 0);
        toast.setGravity(Gravity.END, 0, 0);
        // toast.show();
    }
    /**This toast message is shown as a total score when the SUBMIT button is clicked*/

    public void calculateTotalScore(View view)
    {

        // Process total score
        int totalScore = 0;
        totalScore += computeQuestion1Score();
        totalScore += computeQuestion2Score();
        totalScore += computeQuestion3Score();
        totalScore += computeQuestion4Score();

        getToast();
        toastMessage = " Total Score: " + scoreCounter + " points out of a possible 4 points! ";
        getToast();
    }

}
