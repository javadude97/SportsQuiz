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

    /**This method is called when Question 1 selection is made. All of the above are correct answers*/
    {
        final CheckBox bearsCheckbox = (CheckBox) findViewById(R.id.chicago_bears_checkbox);
        boolean countsBears = bearsCheckbox.isChecked();
        final CheckBox packersCheckbox = (CheckBox) findViewById(R.id.greenbay_packers_checkbox);
        boolean countsPackers = packersCheckbox.isChecked();
        final CheckBox giantsCheckbox = (CheckBox) findViewById(R.id.newyork_giants_checkbox);
        boolean countsGiants = giantsCheckbox.isChecked();
        final CheckBox redskinsCheckbox = (CheckBox) findViewById(R.id.washington_redskins_checkbox);
        boolean countsRedskins = redskinsCheckbox.isChecked();


        /**If all four choices are NOT chosen then no points are assigned*/
        if (countsBears && countsPackers && countsGiants && countsRedskins)
        { scoreCounter +=1;

        } else {
            toastMessage = " Incorrect! Please try again. ";
            getToast();
        }
    }

    /**This method is called when Question 3 selection is made. Answer is Pittsburgh Steelers*/
    {
        RadioButton questionThreeAnswer = findViewById(R.id.pittsburgh_steelers);
        boolean steelersIsChecked = questionThreeAnswer.isChecked();

        if(steelersIsChecked){
            scoreCounter += 1;
        }
        else
        {
            toastMessage = " Incorrect! Please try again. ";
            getToast();
        }
    }

    /**This method is called when Question 4 selection is made. Answer is 6 teams*/
    {
        RadioButton questionFourAnswer = findViewById(R.id.six_teams);
        boolean sixteamsIsChecked = questionFourAnswer.isChecked();

        if(sixteamsIsChecked){
            scoreCounter += 1;
        }
        else
        {
            toastMessage = " Incorrect! Please try again. ";
            getToast();
        }
    }

    /**This method is called when Question 2 selection is made. Answer is Niners*/

    public void showText(View view)
    {
        EditText questionTwoAnswer = findViewById(R.id.user_input);
        String questionTwo = questionTwoAnswer.getText().toString();

        if (questionTwo.toLowerCase().contains("Niners"))
        {
            scoreCounter +=1;
        }
        else
        {
            toastMessage = " Incorrect! Please type again. ";
        }
    }

    /**This method is calls the toast message*/

    public void getToast()
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastMessage, duration);
        //toast.setGravity(Gravity.BOTTOM|Gravity.RIGHT, 0, 0);
        toast.setGravity(Gravity.END, 0, 0);
        toast.show();
    }
    /**This toast message is shown as a total score when the SUBMIT button is clicked*/

    public void calculateTotalScore(View view)
    {
        getToast();
        toastMessage = " Total Score: " + scoreCounter + " points out of a possible 4 points! ";
        getToast();
    }

}
