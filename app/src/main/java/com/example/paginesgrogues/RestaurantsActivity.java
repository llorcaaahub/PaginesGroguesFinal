package com.example.paginesgrogues;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestaurantsActivity extends AppCompatActivity {


    TextView t1,t2,t3,d1,d2,d3;
    Spinner spinnerRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        //Aqui farem la assignacio de valors als texteView dels noms del restaurant
        t1 = findViewById(R.id.titol1);
        t2 = findViewById(R.id.titol2);
        t3 = findViewById(R.id.titol3);
        //Aqui farem la assignacio de valors als textsViews de les descripcions
        d1 = findViewById(R.id.descripcio1);
        d2 = findViewById(R.id.descripcio2);
        d3 = findViewById(R.id.descripcio3);

        spinnerRestaurants = (Spinner) findViewById(R.id.spinner_tipus_restaurants);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipus_de_restaurant, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerRestaurants.setAdapter(adapter);
        loadJSONFromAsset();



    }

    public String loadJSONFromAsset() {
        String json = null;
        JSONArray exemple = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("restaurants.json")));


            // do reading, usually loop until end of file reading
            StringBuilder sb = new StringBuilder();
            String mLine;
            while ((mLine= reader.readLine()) != null) {
                //process line
                sb.append(mLine);


            }
            exemple = new JSONArray(sb.toString());
            String  numero = "ii";
            String restauranttrobat;
            if(spinnerRestaurants.getSelectedItem().toString().equals("--Tria tipus Restaurants--")){
                int contador = 1;
                for(int i=0;i<exemple.length();i++){
                    restauranttrobat = exemple.getJSONObject(i).get("tipurestaurant").toString();
                    if(exemple.getJSONObject(i).get("tipurestaurant").equals("MenjarRapid")){
                        switch(contador){
                            case 1:  t1.setText((CharSequence) exemple.getJSONObject(i).get("nomRestaurant").toString());contador++;break;
                            case 2:  t2.setText((CharSequence) exemple.getJSONObject(i).get("nomRestaurant").toString());contador++;break;
                            case 3:  t3.setText((CharSequence) exemple.getJSONObject(i).get("nomRestaurant").toString());contador++;break;
                            default: break;
                        }
                    }
                    //Aqui posarem el codi que fem servir
                }

            }



        } catch (IOException | JSONException e) {
            //log the exception

        }


        String paraula = "Exemple";
        return paraula;
    }
}