package com.example.paginesgrogues;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestaurantsActivity extends AppCompatActivity {

    //Aqui estem declarant els tres noms de restaurants
    TextView r1nomrestaurant, r2nomrestaurant, r3nomrestaurant;
    //Aqui estem declarant les tres desciprcions dels restaurants
    TextView r1descripcio, r2descripcio, r3descripcio;
    //Aqui estem declarant les tres pagines webs dels restaurants
    TextView r1linkpaginaweb, r2linkpaginaweb, r3linkpaginaweb;
    //Aqui estem declarant els tres telefons dels restaurants
    TextView r1telefon, r2telefon, r3telefon;
    //Aqui estem declarant les tres imatges dels restaurants
    ImageView r1imatge, r2imatge, r3imatge;




    Spinner spinnerRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        //Aqui farem la assignacio de valors als texteView dels noms del restaurant
        r1nomrestaurant = findViewById(R.id.r1nomrestaurant);
        r2nomrestaurant = findViewById(R.id.r2nomrestaurant);
        r3nomrestaurant = findViewById(R.id.r3nomrestaurant);
        //Aqui farem la assignacio de valors als textsViews de les descripcions
        r1descripcio = findViewById(R.id.r1descripcio);
        r2descripcio = findViewById(R.id.r2descripcio);
        r3descripcio = findViewById(R.id.r3descripcio);
        //Aqui fare la assignacio de valors als textsViews dels links de la pagina dels restaurants
        r1linkpaginaweb = findViewById(R.id.r1linkpaginaweb);
        r2linkpaginaweb = findViewById(R.id.r2linkpaginaweb);
        r3linkpaginaweb = findViewById(R.id.r3linkpaginaweb);
        //Aqui fare la assignacio de valors als textsViews als telefons dels restaurants
        r1telefon = findViewById(R.id.r1telefon);
        r2telefon = findViewById(R.id.r2telefon);
        r3telefon = findViewById(R.id.r3telefon);
        //Aqui fare la assignacio de valors als ViewsImage per les imatges dels restaurants
        r1imatge = findViewById(R.id.r1imatge);
        r2imatge = findViewById(R.id.r2imatge);
        r3imatge = findViewById(R.id.r3imatge);


        spinnerRestaurants = (Spinner) findViewById(R.id.spinner_tipus_restaurants);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipus_de_restaurant, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerRestaurants.setAdapter(adapter);
        loadJSONFromAsset();


    }

    public void loadJSONFromAsset() {

        JSONArray exemple = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("restaurants.json")));


            // do reading, usually loop until end of file reading
            StringBuilder sb = new StringBuilder();
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                sb.append(mLine);


            }
            exemple = new JSONArray(sb.toString());
            String tipusrestaurantatriar;
            tipusrestaurantatriar = spinnerRestaurants.getSelectedItem().toString();
            if(tipusrestaurantatriar.equals("--Tria tipus Restaurants--")){
                omplirimatges(exemple,tipusrestaurantatriar);
            }



        } catch (IOException | JSONException e) {
            //log the exception

        }

    }

    private void omplirimatges(JSONArray exemple, String tipusrestaurantatriar) throws JSONException {
        int contador = 1;
        for (int i = 0; i < exemple.length(); i++) {
            //if(exemple.getJSONObject(i).get("tipurestaurant").equals(tipusrestaurantatriar)){
            if(true){ //Aqui es a on haurem de posar el if de comparar el tipus de restaurant actual amb el tipus de restaurant triat
                //Aqui tindrem el codi de afegir tots els valors al seu lloc corresponent directament
                switch (contador){
                    case 1: afegirprimerrestaurant(exemple,i);break;//Aqui afegirem al primer resturant
                    case 2: afegirsegonrestaurant(exemple,i);break;//Aqui afegirem al segon restaurant
                    case 3: afegirtercerrestaurant(exemple,i);break;//Aqui afegirem al tercer restaurant
                    default: break;
                }
                contador++;

            }
        }

    }

    private void afegirprimerrestaurant(JSONArray exemple, int posicio) throws JSONException {
        r1nomrestaurant.setText(exemple.getJSONObject(posicio).get("nomRestaurant").toString());
        r1descripcio.setText(exemple.getJSONObject(posicio).get("descripcio").toString());
        r1linkpaginaweb.setText(exemple.getJSONObject(posicio).get("linkpaginaweb").toString());
        r1telefon.setText(exemple.getJSONObject(posicio).get("telefon").toString());
        r1imatge.setImageResource(Integer.parseInt(exemple.getJSONObject(posicio).get("imatge").toString()));
    }

    private void afegirsegonrestaurant(JSONArray exemple, int posicio) throws JSONException {
        r2nomrestaurant.setText(exemple.getJSONObject(posicio).get("nomRestaurant").toString());
        r2descripcio.setText(exemple.getJSONObject(posicio).get("descripcio").toString());
        r2linkpaginaweb.setText(exemple.getJSONObject(posicio).get("linkpaginaweb").toString());
        r2telefon.setText(exemple.getJSONObject(posicio).get("telefon").toString());
        r2imatge.setImageResource(Integer.parseInt(exemple.getJSONObject(posicio).get("imatge").toString()));
    }

    private void afegirtercerrestaurant(JSONArray exemple, int posicio) throws JSONException {
        r3nomrestaurant.setText(exemple.getJSONObject(posicio).get("nomRestaurant").toString());
        r3descripcio.setText(exemple.getJSONObject(posicio).get("descripcio").toString());
        r3linkpaginaweb.setText(exemple.getJSONObject(posicio).get("linkpaginaweb").toString());
        r3telefon.setText(exemple.getJSONObject(posicio).get("telefon").toString());
        r3imatge.setImageResource(Integer.parseInt(exemple.getJSONObject(posicio).get("imatge").toString()));
    }

}
