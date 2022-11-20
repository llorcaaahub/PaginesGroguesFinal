package com.example.paginesgrogues;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    //Aqui estem declarant el spinner
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

        //Aqui li diem que el spinner que hem creat abans es el spinner que esta al xml
        spinnerRestaurants = (Spinner) findViewById(R.id.spinner_tipus_restaurants);
        //Aqui li posem valor al spinner, a aixi tindrem la llista de desplegables de restaurants
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipus_de_restaurant, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRestaurants.setAdapter(adapter);

        //Aqui estem declarant el event per detectar quan hi ha canvi en el index triat del spinner
        spinnerRestaurants.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Cada cop que el index de spinner canvia, entrara aqui dins


                //Aqui es a on JO faig el actualitzar les dades
                loadJSONFromAsset();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Aqui de moment no posarem res
                //UPDATE: SI NO POSEM RES EL ADAPTERVIEW ES QUEIXA
            }
        });
    }

    public void loadJSONFromAsset() {
        JSONArray exemple;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("restaurants.json")));

            StringBuilder sb = new StringBuilder();
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                sb.append(mLine);
            }

            exemple = new JSONArray(sb.toString());
            String tipusrestaurantatriar;
            tipusrestaurantatriar = spinnerRestaurants.getSelectedItem().toString();
            if(!tipusrestaurantatriar.equals("--Tria tipus Restaurants--")){
                omplirvalors(exemple,tipusrestaurantatriar);
            }else{
                //Aqui podriem fer que si no te cap restaurant triat no es mostri res
                //contentView.setVisibility(View.GONE) //MAYBE ES AIXO
            }
        } catch (IOException | JSONException e) {
            //log the exception
        }
    }

    private void omplirvalors(JSONArray exemple, String tipusrestaurantatriar) throws JSONException {
        int contador = 1;
        for (int i = 0; i < exemple.length(); i++) {
            //if(exemple.getJSONObject(i).get("tipurestaurant").equals(tipusrestaurantatriar)){
            if(exemple.getJSONObject(i).get("tipurestaurant").toString().equals(tipusrestaurantatriar)){ //Aqui es a on haurem de posar el if de comparar el tipus de restaurant actual amb el tipus de restaurant triat
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
        String nomrestaurant = exemple.getJSONObject(posicio).get("nomRestaurant").toString();
        r1nomrestaurant.setText(nomrestaurant);
        String descripciorestaurant = exemple.getJSONObject(posicio).get("descripcio").toString();
        r1descripcio.setText(descripciorestaurant);
        String linkpaginawebrestaurant = exemple.getJSONObject(posicio).get("linkpaginaweb").toString();
        r1linkpaginaweb.setText(linkpaginawebrestaurant);
        String telefonRestaurant = exemple.getJSONObject(posicio).get("telefon").toString();
        r1telefon.setText(telefonRestaurant);
        String imatgerestaurant = exemple.getJSONObject(posicio).get("imatge").toString(); //atarasii
        int resID = getResources().getIdentifier(imatgerestaurant , "drawable", getPackageName());
        r1imatge.setImageResource(resID);
    }

    private void afegirsegonrestaurant(JSONArray exemple, int posicio) throws JSONException {
        String nomrestaurant = exemple.getJSONObject(posicio).get("nomRestaurant").toString();
        r2nomrestaurant.setText(nomrestaurant);
        String descripciorestaurant = exemple.getJSONObject(posicio).get("descripcio").toString();
        r2descripcio.setText(descripciorestaurant);
        String linkpaginawebrestaurant = exemple.getJSONObject(posicio).get("linkpaginaweb").toString();
        r2linkpaginaweb.setText(linkpaginawebrestaurant);
        String telefonRestaurant = exemple.getJSONObject(posicio).get("telefon").toString();
        r2telefon.setText(telefonRestaurant);
        String imatgerestaurant = exemple.getJSONObject(posicio).get("imatge").toString();
        int resID = getResources().getIdentifier(imatgerestaurant , "drawable", getPackageName());
        r2imatge.setImageResource(resID);
    }

    private void afegirtercerrestaurant(JSONArray exemple, int posicio) throws JSONException {
        String nomrestaurant = exemple.getJSONObject(posicio).get("nomRestaurant").toString();
        r3nomrestaurant.setText(nomrestaurant);
        String descripciorestaurant = exemple.getJSONObject(posicio).get("descripcio").toString();
        r3descripcio.setText(descripciorestaurant);
        String linkpaginawebrestaurant = exemple.getJSONObject(posicio).get("linkpaginaweb").toString();
        r3linkpaginaweb.setText(linkpaginawebrestaurant);
        String telefonRestaurant = exemple.getJSONObject(posicio).get("telefon").toString();
        r3telefon.setText(telefonRestaurant);
        String imatgerestaurant = exemple.getJSONObject(posicio).get("imatge").toString();
        int resID = getResources().getIdentifier(imatgerestaurant , "drawable", getPackageName());
        r3imatge.setImageResource(resID);
    }

}
