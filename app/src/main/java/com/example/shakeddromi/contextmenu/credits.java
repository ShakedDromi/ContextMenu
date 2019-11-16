package com.example.shakeddromi.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * this is the credits activities.
 */

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * this method takes the user back- to the previous activity.
     * @param view
     */

    public void bck(View view) {
        finish();
    }
}