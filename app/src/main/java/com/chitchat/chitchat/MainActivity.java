package com.chitchat.chitchat;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity  {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupNavbar();
    }
    private void setupToolbar(){
        Toolbar tool =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tool);

        /*To show menu icon*/
        final ActionBar one=getSupportActionBar();
        one.setHomeAsUpIndicator(R.drawable.menu);
        one.setDisplayHomeAsUpEnabled(true);




    }
    private void setupNavbar(){
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}











