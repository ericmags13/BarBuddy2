package com.example.snowc.barbuddy2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Switch;



public class MainActivity extends AppCompatActivity {
    public int weight = 140;

    private View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View v) {
            Button d = (Button) v;
            d.setBackgroundColor(Color.RED);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(listener);
    }
    public int count;
    public void onClick(View v) {
        Button button = (Button) v;
        count++;

        TextView msg = (TextView) findViewById(R.id.Stop);
        Switch gender = (Switch) findViewById(R.id.gender);
        if (count >= 5 && gender.isChecked() && weight > 135) {
            msg.setVisibility(View.VISIBLE);
        } else if (count >= 6 && !gender.isChecked()) {
            msg.setVisibility(View.VISIBLE);
        } else if (count >= 7 && !gender.isChecked() && weight > 135) {
            msg.setVisibility(View.VISIBLE);
        } else if (count >= 4 && gender.isChecked() && weight < 135) {
            msg.setVisibility(View.VISIBLE);
        }
        TextView drink = (TextView) findViewById(R.id.DrinkCount);
        drink.setText("Drink Count: " + count);
    }
    public void subtract(View v) {
        Button button = (Button) v;
        count--;
        TextView msg = (TextView) findViewById(R.id.Stop);
        Switch gender = (Switch) findViewById(R.id.gender);
        if (count <= 5 && gender.isChecked() && weight > 135) {
            msg.setVisibility(View.INVISIBLE);
        } else if (count <= 6 && !gender.isChecked()) {
            msg.setVisibility(View.INVISIBLE);
        } else if (count <= 4 && gender.isChecked() && weight < 135) {
            msg.setVisibility(View.INVISIBLE);
        } else if (count <= 7 && !gender.isChecked() && weight > 135) {
            msg.setVisibility(View.INVISIBLE);
        }
        TextView drink = (TextView) findViewById(R.id.DrinkCount);
        drink.setText("Drink Count: " + count);

    }

    public void weight(View v) {
        Button button = (Button) v;
        ((Button) v).setText("Clicked");
        EditText simpleEditText = (EditText) findViewById(R.id.editText);
        String editTextValue = simpleEditText.getText().toString();
        int value = Integer.getInteger(editTextValue.toString());
        weight = value;

    }
    public void time() {
        //System.Clock.elapsedRealtime();
    }
    /**public static double drinkScore(View v) {
     double drink;

     String gender;
     double genderNum;
     boolean hasEaten;
     if (gender.equals("male")) {
     genderNum = .1;
     } else if (gender.equals("female")) {
     genderNum = .2;
     }
     if (hasEaten) {
     double eaten = 0.0;
     } else {
     double eaten = .2;
     }
     double lvl = genderNum + (weight * .001) + .05*drink + eaten;
     return lvl;
     }**/
}
