package com.example.dogpedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class HomeScreen extends AppCompatActivity {

    TextView tName;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            if (item.getItemId() == R.id.nav_chat) {
                startActivity(new Intent(
                        this, Chat.class));
            } else if (item.getItemId() == R.id.nav_home) {
                startActivity(new Intent(
                        this, HomeScreen.class));
            } else if (item.getItemId() == R.id.nav_dogs) {
                startActivity(new Intent(
                        this, Pets.class));
            } else if (item.getItemId() == R.id.nav_myProfile) {
                startActivity(new Intent(
                        this, MyProfile.class));
            } else if (item.getItemId() == R.id.nav_petFood) {
                startActivity(new Intent(
                        this, PetFood.class));
            } else if (item.getItemId() == R.id.nav_settings) {
                startActivity(new Intent(
                        this, Settings.class));
            } else if (item.getItemId() == R.id.nav_statistics) {
                startActivity(new Intent(
                        this, Statistics.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}