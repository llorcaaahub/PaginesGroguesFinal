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

public class BussinesActivity extends AppCompatActivity {

    //Aqui estem declarant els tres noms de restaurants
    TextView e1nomempresa, e2nomempresa, e3nomempresa;
    //Aqui estem declarant les tres desciprcions dels restaurants
    TextView e1descripcio, e2descripcio, e3descripcio;
    //Aqui estem declarant les tres pagines webs dels restaurants
    TextView e1linkpaginaweb, e2linkpaginaweb, e3linkpaginaweb;
    //Aqui estem declarant els tres telefons dels restaurants
    TextView e1telefon, e2telefon, e3telefon;
    //Aqui estem declarant les tres imatges dels restaurants
    ImageView r1imatge, r2imatge, r3imatge;
    Spinner sp;

    Spinner spinnerBussines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bussines);


        sp= findViewById(R.id.spinner_tipus_bussines);


        spinnerBussines= (Spinner) findViewById(R.id.spinner_tipus_bussines);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipus_de_bussines, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerBussines.setAdapter(adapter);
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
            String nomimatge;
            if(spinnerBussines.getSelectedItem().toString().equals("--Tria tipus Empressa--")){
                int contador = 1;
                for(int i=0;i<exemple.length();i++){

                    if(exemple.getJSONObject(i).get("tipurestaurant").equals("MenjarRapid")){
                        switch(contador){
                            case 1:
                                e1nomempresa.setText((CharSequence) exemple.getJSONObject(i).get("nomRestaurant").toString());
                                e1descripcio.setText((CharSequence) exemple.getJSONObject(i).get("descripcio").toString());
                                e1linkpaginaweb.setText((CharSequence) exemple.getJSONObject(i).get("linkpaginaweb").toString());
                                e1telefon.setText((CharSequence) exemple.getJSONObject(i).get("telefon").toString());

                                switch (exemple.getJSONObject(i).get("imatge").toString()){
                                    case "./kfc":r1imatge.setImageResource(R.drawable.kfc);break;
                                    case "./viena":r1imatge.setImageResource(R.drawable.viena);break;
                                    case "./mcdonalds":r1imatge.setImageResource(R.drawable.mcdonalds);break;
                                    default: break;
                                }
                                contador++;
                                break;
                            case 2:
                                e2nomempresa.setText((CharSequence) exemple.getJSONObject(i).get("nomRestaurant").toString());
                                e2descripcio.setText((CharSequence) exemple.getJSONObject(i).get("descripcio").toString());
                                e2linkpaginaweb.setText((CharSequence) exemple.getJSONObject(i).get("linkpaginaweb").toString());
                                e2telefon.setText((CharSequence) exemple.getJSONObject(i).get("telefon").toString());
                                switch (exemple.getJSONObject(i).get("imatge").toString()){
                                    case "./kfc":r2imatge.setImageResource(R.drawable.kfc);break;
                                    case "./viena":r2imatge.setImageResource(R.drawable.viena);break;
                                    case "./mcdonalds":r2imatge.setImageResource(R.drawable.mcdonalds);break;
                                    default: break;
                                }

                                contador++;
                                break;
                            case 3:
                                e3nomempresa.setText((CharSequence) exemple.getJSONObject(i).get("nomRestaurant").toString());
                                e3descripcio.setText((CharSequence) exemple.getJSONObject(i).get("descripcio").toString());
                                e3linkpaginaweb.setText((CharSequence) exemple.getJSONObject(i).get("linkpaginaweb").toString());
                                e3telefon.setText((CharSequence) exemple.getJSONObject(i).get("telefon").toString());
                                nomimatge = exemple.getJSONObject(i).get("imatge").toString();
                                switch (nomimatge){
                                    case "./kfc":r3imatge.setImageResource(R.drawable.kfc);break;
                                    case "./viena":r3imatge.setImageResource(R.drawable.viena);break;
                                    case "./mcdonalds":r3imatge.setImageResource(R.drawable.mcdonalds);break;
                                    default: break;
                                }
                                contador++;
                                break;
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

