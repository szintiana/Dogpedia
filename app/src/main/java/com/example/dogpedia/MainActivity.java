package com.example.dogpedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userId, password, name;
    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        if (register == null){
            Log.d("ionut", "register e null!");
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
             // Creating User Entity
             UserEntity userEntity = new UserEntity();
             userEntity.setUserId(userId.getText().toString());
             userEntity.setPassword(password.getText().toString());
             userEntity.setName(name.getText().toString());
             if(validateInput(userEntity)){
                 // Do insert operation
                 UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                 final UserDao userDao = userDatabase.userDao();
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         // Register User
                         userDao.registerUser(userEntity);
                         runOnUiThread(new Runnable() {
                             @Override
                             public void run() {
                                 Toast.makeText(getApplicationContext(), "User Registered!", Toast.LENGTH_SHORT).show();
                             }
                         });
                     }
                 }).start();
             }
             else {
                 Toast.makeText(getApplicationContext(), "Please fill all fields!", Toast.LENGTH_SHORT).show();
             }
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
    }

    private Boolean validateInput(UserEntity userEntity){
        return !userEntity.getName().isEmpty() &&
                !userEntity.getPassword().isEmpty();
    }

}
