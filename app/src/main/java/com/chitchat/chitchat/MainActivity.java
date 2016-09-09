package com.chitchat.chitchat;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
    }
    private void setupToolbar(){
        Toolbar tool =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tool);

        /*To show menu icon*/
        final ActionBar one=getSupportActionBar();
        one.setHomeAsUpIndicator(R.drawable.menu);
        one.setDisplayHomeAsUpEnabled(true);




    }
}
