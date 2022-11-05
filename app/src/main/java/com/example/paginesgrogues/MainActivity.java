package com.example.paginesgrogues;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    //Variables globals
    ImageView botoBusiness, botoRestaurant, botoMovies, botoParking, botoHotels, botoKnowledge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoBusiness = findViewById(R.id.a1);
        botoRestaurant = findViewById(R.id.a2);
        botoMovies = findViewById(R.id.b2);
        botoParking= findViewById(R.id.b1);
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

    public void goToEventsParkings(View view) {
        Intent intent = new Intent(this, ParkingsActivity.class);
        startActivity(intent);
        //Aqui declarem la funcio que inciara els events de cada clic i li posara un nom als imageViews/Botons

    }
}