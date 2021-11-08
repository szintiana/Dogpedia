package com.example.dogpedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class Pets extends AppCompatActivity {
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationDrawer navigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        navigationDrawer = new NavigationDrawer();
        navigationDrawer.initialize();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            navigationDrawer.navigate(item, this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}