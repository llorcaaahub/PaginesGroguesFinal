package com.example.paginesgrogues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    //Variables globals
    ImageView botoBusiness, botoRestaurant, botoMovies, botoWeather, botoHotels, botoKnowledge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoBusiness = findViewById(R.id.a1);
        botoRestaurant = findViewById(R.id.a2);
        botoMovies = findViewById(R.id.b2);
        botoWeather = findViewById(R.id.b1);
        botoHotels = findViewById(R.id.c1);
        botoKnowledge = findViewById(R.id.c2);


        botoRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            //Aquest es el boto de restaurants
            public void onClick(View view) {

                goToEventsRestaurants(view);
            }
        });


        botoBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            //Aquest es el boto de business
            public void onClick(View view) {
                goToEventsBussines(view);
            }
        });

        botoMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            //Aquest es el boto de movies
            public void onClick(View view) {
                goToEventsMovies(view);
            }
        });

    }

    public void goToEventsRestaurants(View view) {
        Intent intent = new Intent(this, RestaurantsActivity.class);
        startActivity(intent);
        //Aqui declarem la funcio que inciara els events de cada clic i li posara un nom als imageViews/Botons

    }

    public void goToEventsBussines(View view) {
        Intent intent = new Intent(this, BussinesActivity.class);
        startActivity(intent);
        //Aqui declarem la funcio que inciara els events de cada clic i li posara un nom als imageViews/Botons

    }

    public void goToEventsMovies(View view) {
        Intent intent = new Intent(this, MoviesActivity.class);
        startActivity(intent);
        //Aqui declarem la funcio que inciara els events de cada clic i li posara un nom als imageViews/Botons

    }
}