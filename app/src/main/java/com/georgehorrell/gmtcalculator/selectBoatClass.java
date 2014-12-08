package com.georgehorrell.gmtcalculator;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class selectBoatClass extends Activity implements TextWatcher {

    //declare boats

    //senior mens
    Boat M1x   = new Boat("M1x",   391);
    Boat M2x   = new Boat("M2x",   361);
    Boat M4x   = new Boat("M4x",   331);
    Boat M2    = new Boat("M2-",   373);
    Boat M4    = new Boat("M4-",   341);
    Boat M2c   = new Boat("M2+",   397);
    Boat M4c   = new Boat("M4+",   353);
    Boat M8c   = new Boat("M8+",   319);

    //lightweight mens
    Boat LM1x  = new Boat("LM1x",  397);
    Boat LM2x  = new Boat("LM2x",  366);
    Boat LM4x  = new Boat("LM4x",  338);
    Boat LM2   = new Boat("LM2-",  379);
    Boat LM4   = new Boat("LM4-",  345);
    Boat LM8c  = new Boat("LM8+",  324);

    //junior mens
    Boat JM1x  = new Boat("JM1x",  404);
    Boat JM2x  = new Boat("JM2x",  373);
    Boat JM4x  = new Boat("JM4x",  346);
    Boat JM2   = new Boat("JM2-",  386);
    Boat JM4   = new Boat("JM4-",  353);
    Boat JM2c  = new Boat("JM2+",  411);
    Boat JM4c  = new Boat("JM4+",  366);
    Boat JM8c  = new Boat("JM8+",  330);

    //senior womens
    Boat W1x   = new Boat("W1x",   428);
    Boat W2x   = new Boat("W2x",   397);
    Boat W4x   = new Boat("W4x",   365);
    Boat W2    = new Boat("W2-",   411);
    Boat W4    = new Boat("W4-",   376);
    Boat W8c   = new Boat("W8+",   353);

    //seniors lightweight womens
    Boat LW1x = new Boat("LW1x",   434);
    Boat LW2x = new Boat("LW2x",   403);
    Boat LW4x = new Boat("LW4x",   371);
    Boat LW2  = new Boat("LW2-",   417);

    //junior womens
    Boat JW1x = new Boat("JW1x",   444);
    Boat JW2x = new Boat("JW2x",   410);
    Boat JW4x = new Boat("JW4x",   377);
    Boat JW2  = new Boat("JW2-",   425);
    Boat JW4  = new Boat("JW4-",   362);
    Boat JW8c = new Boat("JW8+",   305);


    int gmtRaw;

    List<Boat> boats = new ArrayList<Boat>();

    String[] boatTypes = {"M1x", "M2x", "M4x", "M2-", "M4-", "M2+", "M4+", "M8+", "LM1x", "LM2x", "LM4x", "LM2-", "LM4-", "LM8+", "JM1x", "JM2x", "JM4x", "JM2-", "JM4-", "JM2+", "JM4+", "JM8+", "W1x", "W2x", "W4x", "W2-", "W4-", "W8+", "LW1x", "LW2x", "LW4x", "LW2-", "JW1x", "JW2x", "JW4x", "JW2-", "JW4-", "JW8+"};
    int[] boatTimes = {391, 361, 331, 373, 341, 397, 353};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // setup actionbar

        //add boats declared above to boats arrayList;

        //mens crews
        boats.add(M1x);
        boats.add(M2x);
        boats.add(M4x);
        boats.add(M2);
        boats.add(M4);
        boats.add(M2c);
        boats.add(M4c);
        boats.add(M8c);

        boats.add(LM1x);
        boats.add(LM2x);
        boats.add(LM4x);
        boats.add(LM2);
        boats.add(LM4);
        boats.add(LM8c);

        boats.add(JM1x);
        boats.add(JM2x);
        boats.add(JM4x);
        boats.add(JM2);
        boats.add(JM4);
        boats.add(JM2c);
        boats.add(JM4c);
        boats.add(JM8c);

        //womens crews
        boats.add(W1x);
        boats.add(W2x);
        boats.add(W4x);
        boats.add(W2);
        boats.add(W4);
        boats.add(W8c);

        boats.add(LW1x);
        boats.add(LW2x);
        boats.add(LW4x);
        boats.add(LW2);

        boats.add(JW1x);
        boats.add(JW2x);
        boats.add(JW4x);
        boats.add(JW2);
        boats.add(JW4);
        boats.add(JW8c);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_boat_class);

        //display boats arrayList in spinner at top of app

        final ArrayAdapter<Boat> adapter = new ArrayAdapter<Boat>(this, R.layout.spinner_item, boats);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter); //output to spinner

        //Listen for changes to spinner selected value

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int spinValue = spinner.getSelectedItemPosition();
                Boat selectedBoat = adapter.getItem(spinValue);
                gmtRaw = selectedBoat.giveTime();
                setGMTview(view, selectedBoat.giveTime());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_boat_class, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setGMTview(View view, int time) {
        // Function converts raw seconds into timeString
        // and displays timeString in gmtTextView

        int minutes;
        int seconds;
        String timeString;
        TextView gmtTextView = (TextView)findViewById(R.id.gmtTextView);
        minutes = time / 60;
        seconds = time % 60;
        timeString = String.format("%02d:%02d.%02d", minutes, seconds, 00);
        gmtTextView.setText(timeString);
    }

    public void setPercentageView(View view) {
        // Function tied to calculate button
        // finds input time and calculates percentage using getPercentage function
        // outputs percentage to field
        // closes keyboard if open


        //close keyboard
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        double percentage= 0;
        double recRaw = getRecordedRaw(view);
        String outString;
        percentage = getPercentage(recRaw, gmtRaw);


        TextView percentageTextView = (TextView)findViewById(R.id.percTextView);
        outString = String.format("%.3f%%", percentage);
        percentageTextView.setText(outString);
    }

    public double getPercentage(double recordedTime, int gmtTime) {
        // Function calculates percentage of two inputs as a rounded double

        double frac = recordedTime / (double)gmtTime;
        double percRaw =  frac*100;
        return (double)Math.round(percRaw * 1000) / 1000; //rounding logic
    }

    public double getRecordedRaw(View view){
        // Function pulls input time from 3 editText fields, minutes, seconds, milliseconds
        // Converts editText input to string to integer then to float
        // Combines floats into total seconds as recTimeRaw
        // Returns recTimeRaw


        // Declare all variables to be used
        String inputTimeStr;
        int minInt;
        int secInt;
        int milliInt;
        double recTimeRaw;

        // Pull initial values from EditText field as EditText objects
        EditText inputTime = (EditText)findViewById(R.id.inputTimeField);

        // Convert all values to strings
        inputTimeStr = inputTime.getText().toString();

        // Split inputTimeStr to component strings
        String[] inputParts = inputTimeStr.split("(:)|(\\.)");

        // Convert all strings to integers
        minInt = Integer.parseInt(inputParts[0]);
        secInt = Integer.parseInt(inputParts[1]);
        milliInt = Integer.parseInt(inputParts[2]);

        // combination logic
        recTimeRaw = (double)(minInt*60) + (double)secInt + (((double)(milliInt))/100);
        return recTimeRaw;

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

