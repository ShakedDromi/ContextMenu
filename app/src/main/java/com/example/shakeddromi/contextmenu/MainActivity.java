package com.example.shakeddromi.contextmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

/**
 * @author Shaked Dromi
 * @version alpha
 * @since 16.11.19
 * in this activity the user chooses the type of the series, the first number in the series and the multiplier or the difference between the numbers.
 * then he goes to the next activity.
 */

public class MainActivity extends AppCompatActivity {

    double m,n;
    boolean b=false;
    Switch swch;
    EditText eivar1,diffmult;
    String st1,st2;

    /**
     * m- the first number of the series
     * n- the difference or multiplier
     * swch- the java object of switch
     * eivar1- the java object of EditText
     * diffnult- the java object of EditText
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swch=(Switch) findViewById(R.id.swch);
        eivar1=(EditText) findViewById(R.id.eivar1);
        diffmult=(EditText) findViewById(R.id.diffmult);
    }

    public void swch(View view) {
        if(swch.isChecked())
            b=true;
        else
            b=false;
    }

    /**
     * this method starts when the next button is clicked.
     * this method checks if the user entered numbers. then it takes the user to the next activity with the information.
     * if the user didn't put numbers, a toast that says- "enter numbers" pops.
     */

    public void nxt(View view) {
        st1=eivar1.getText().toString();
        st2=diffmult.getText().toString();
        if(st1.length()!=0&&st2.length()!=0) {
            m=Double.parseDouble(st1);
            n=Double.parseDouble(st2);
            Intent si=new Intent(this,Main2Activity.class);
            si.putExtra("hukiut",n);
            si.putExtra("first",m);
            si.putExtra("sug",b);
            startActivity(si);
        }
        else {
            Toast.makeText(this, "enter numbers.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * this method takes the user to the credits activity.
     */

    public void creds(View view) {
        Intent si=new Intent(this,credits.class);
        startActivity(si);
    }
}