package com.example.paginesgrogues;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ParkingsActivity extends AppCompatActivity {

    ImageView parking1, parking2, parking3;
    TextView placesparking1,placesparking2,placesparking3;
    LinearLayout parkingtelefon1,parkingtelefon2, parkingtelefon3;
    LinearLayout parkingpagina1,parkingpagina2,parkingpagina3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkings);

        //Donem valor als tres mapes del parking
        parking1 = findViewById(R.id.parking1);
        parking2 = findViewById(R.id.parking2);
        parking3 = findViewById(R.id.parking3);

        //Donem valor a les tres places de parking restants
        placesparking1 = findViewById(R.id.placesparking1);
        placesparking2 = findViewById(R.id.placesparking2);
        placesparking3 = findViewById(R.id.placesparking3);

        //Aqui donarem valor als tres links de les pagines web
        parkingpagina1 = findViewById(R.id.parkingpaginaweb1);
        parkingpagina2 = findViewById(R.id.parkingpaginaweb2);
        parkingpagina3 = findViewById(R.id.parkingpaginaweb3);

        //Aqui donarem valor als tres telefons dels parkings
        parkingtelefon1 = findViewById(R.id.parkingtelefon1);
        parkingtelefon2 = findViewById(R.id.parkingtelefon2);
        parkingtelefon3 = findViewById(R.id.parkingtelefon3);

        //Aqui afegim els events de les pagines web
        afegireventspaginesweb();

        //Aqui afegim els events dels telefons
        afegireventstelefons();

        //Aquest funcio es la que fem quan volem posar un numero random de places de parking per cada parking
        valorsrandomspplacesparking();

        //Aqui crearem les tres funcion per obrir el mapa
        afegireventsmapes();
    }

    private void afegireventsmapes() {
        parking1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:41.6079283,2.2904078?z=21");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
        parking2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:41.6046006,2.2895821?z=21");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
        parking3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:41.6142789,2.2871648?z=21");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }

    private void afegireventstelefons() {
        parkingtelefon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numtelefon = "987 987 432";
                Intent truca = new Intent(Intent.ACTION_VIEW);
                truca.setData(Uri.parse("tel:" + numtelefon));
                startActivity(truca);
            }
        });
        parkingtelefon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numtelefon = "937 416 223";
                Intent truca = new Intent(Intent.ACTION_VIEW);
                truca.setData(Uri.parse("tel:" + numtelefon));
                startActivity(truca);
            }
        });
        parkingtelefon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numtelefon = "938 704 272";
                Intent truca = new Intent(Intent.ACTION_VIEW);
                truca.setData(Uri.parse("tel:" + numtelefon));
                startActivity(truca);
            }
        });
    }

    private void afegireventspaginesweb() {
        parkingpagina1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String web = "https://www.granollers.cat/adreces/parquing-pagament/parquing-sot";
                Intent obreWeb = new Intent(Intent.ACTION_VIEW);
                obreWeb.setData(Uri.parse(web));
                startActivity(obreWeb);
            }
        });
        parkingpagina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String web = "https://www.pblaus.com/";
                Intent obreWeb = new Intent(Intent.ACTION_VIEW);
                obreWeb.setData(Uri.parse(web));
                startActivity(obreWeb);
            }
        });
        parkingpagina3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String web = "https://elparking.com/aparcar-en-granollers";
                Intent obreWeb = new Intent(Intent.ACTION_VIEW);
                obreWeb.setData(Uri.parse(web));
                startActivity(obreWeb);
            }
        });


    }

    private void valorsrandomspplacesparking() {
        //Aquesta es la funcio que farem servir per saber quantes places de parking tenim "DISPONIBLES" al parking
        int numero1,numero2,numero3;

        Random rand = new Random();

        numero1 = rand.nextInt(257);
        numero2 = rand.nextInt(330);
        numero3 = rand.nextInt(95);

        String parking1final = "Places disponibles: " + numero1;
        String parking2final = "Places disponibles: " + numero2;
        String parking3final = "Places disponibles: " + numero3;

        placesparking1.setText(parking1final);
        placesparking2.setText(parking2final);
        placesparking3.setText(parking3final);

    }
}