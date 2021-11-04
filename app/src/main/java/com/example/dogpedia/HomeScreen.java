package com.example.dogpedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class HomeScreen extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    MenuItem navMyProfile;
    MenuItem navSettings;
    MenuItem navHome;
    MenuItem navDogs;
    MenuItem navStatistics;
    MenuItem navPetFood;
    MenuItem navChat;
    Bundle extras;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navMyProfile = findViewById(R.id.nav_myProfile);
        navSettings = findViewById(R.id.nav_settings);
        navHome = findViewById(R.id.nav_home);
        navDogs = findViewById(R.id.nav_dogs);
        navChat = findViewById(R.id.nav_chat);
        navPetFood = findViewById(R.id.nav_petFood);
        navStatistics = findViewById(R.id.nav_statistics);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            if (item == navChat){
                //redirect to chat
                System.out.println("Chat");
            }
            else if (item == navHome){
                //redirect to home
                Log.d("szntiana", "Home");
            }
            else if (item == navDogs){
                //redirect to dogs
                System.out.println("Dogs");
            }
            else if (item == navMyProfile){
                //redirect to myProfile
                System.out.println("My Profile");
            }
            else if (item == navSettings){
                //redirect to settings
                System.out.println("Settings");
            }
            else if (item == navPetFood){
                //redirect to PetFood
                System.out.println("Pet Food");
            }
            else if (item == navStatistics){
                //redirect to statistics
                System.out.println("Statistics");
            }
        }
        return super.onOptionsItemSelected(item);
    }
}