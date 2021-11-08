package com.example.dogpedia;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.Objects;

public class NavigationDrawer extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    public void initialize(){
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    public void navigate(MenuItem item, Context context){
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            if (item.getItemId() == R.id.nav_chat) {
                startActivity(new Intent(
                        context, Chat.class));
            } else if (item.getItemId() == R.id.nav_home) {
                startActivity(new Intent(
                        context, HomeScreen.class));
            } else if (item.getItemId() == R.id.nav_dogs) {
                startActivity(new Intent(
                        context, Pets.class));
            } else if (item.getItemId() == R.id.nav_myProfile) {
                startActivity(new Intent(
                        context, MyProfile.class));
            } else if (item.getItemId() == R.id.nav_petFood) {
                startActivity(new Intent(
                        context, PetFood.class));
            } else if (item.getItemId() == R.id.nav_settings) {
                startActivity(new Intent(
                        context, Settings.class));
            } else if (item.getItemId() == R.id.nav_statistics) {
                startActivity(new Intent(
                        context, Statistics.class));
            }
        }
    }
}
