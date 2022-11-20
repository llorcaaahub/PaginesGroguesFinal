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
    ImageView e1imatge, e2imatge, e3imatge;
    Spinner sp;

    Spinner spinnerBussines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bussines);


        sp= findViewById(R.id.spinner_tipus_bussines);


        //Aqui li diem que el spinner que hem creat abans es el spinner que esta al xml
        spinnerBussines = (Spinner) findViewById(R.id.spinner_tipus_bussines);
        //Aqui li posem valor al spinner, a aixi tindrem la llista de desplegables de restaurants
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipus_de_bussines, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBussines.setAdapter(adapter);

        spinnerBussines.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Cada cop que el index de spinner canvia, entrara aqui dins
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("bussines.json")));

            StringBuilder sb = new StringBuilder();
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                sb.append(mLine);
            }

            exemple = new JSONArray(sb.toString());
            String tipusbussinesatriar;
            tipusbussinesatriar = spinnerBussines.getSelectedItem().toString();
            if(!tipusbussinesatriar.equals("triar_tipus_sectors")){
                omplirvalors(exemple,tipusbussinesatriar);
            }else{
                //Aqui podriem fer que si no te cap restaurant triat no es mostri res
                //contentView.setVisibility(View.GONE) //MAYBE ES AIXO
            }
        } catch (IOException | JSONException e) {
            //log the exception
        }
    }
    private void omplirvalors(JSONArray exemple, String tipusbussinesatriar) throws JSONException {
        int contador = 1;
        for (int i = 0; i < exemple.length(); i++) {
            //if(exemple.getJSONObject(i).get("tipusbussines").equals(tipusbussinesatriar)){
            if(exemple.getJSONObject(i).get("tipusbussines").toString().equals(tipusbussinesatriar)){ //Aqui es a on haurem de posar el if de comparar
                //Aqui tindrem el codi de afegir tots els valors al seu lloc corresponent directament
                switch (contador){
                    case 1: afegirprimerbussines(exemple,i);break;//Aqui afegirem al primer negoci
                    case 2: afegirsegonbussines(exemple,i);break;//Aqui afegirem al segon negoci
                    case 3: afegirtercerbussines(exemple,i);break;//Aqui afegirem al tercer negoci
                    default: break;
                }
                contador++;
            }
        }
    }

    private void afegirprimerbussines(JSONArray exemple, int posicio) throws JSONException {
        String nomEmpresa = exemple.getJSONObject(posicio).get("nomEmpresa").toString();
        e1nomempresa.setText(nomEmpresa);
        String descripcioEmpresa = exemple.getJSONObject(posicio).get("descripcio").toString();
        e1descripcio.setText(descripcioEmpresa);
        String linkpaginawebempresa = exemple.getJSONObject(posicio).get("linkpaginaweb").toString();
        e1linkpaginaweb.setText(linkpaginawebempresa);
        String telefonEmpresa = exemple.getJSONObject(posicio).get("telefon").toString();
        e1telefon.setText(telefonEmpresa);
        String imatgeEmpresa = exemple.getJSONObject(posicio).get("imatge").toString();
        int resID = getResources().getIdentifier(imatgeEmpresa , "drawable", getPackageName());
        e1imatge.setImageResource(resID);
    }

    private void afegirsegonbussines(JSONArray exemple, int posicio) throws JSONException {
        String nomEmpresa = exemple.getJSONObject(posicio).get("nomEmpresa").toString();
        e2nomempresa.setText(nomEmpresa);
        String descripcioEmpresa = exemple.getJSONObject(posicio).get("descripcio").toString();
        e2descripcio.setText(descripcioEmpresa);
        String linkpaginawebempresa= exemple.getJSONObject(posicio).get("linkpaginaweb").toString();
        e2linkpaginaweb.setText(linkpaginawebempresa);
        String telefonEmpresa = exemple.getJSONObject(posicio).get("telefon").toString();
        e2telefon.setText(telefonEmpresa);
        String imatgeEmpresa = exemple.getJSONObject(posicio).get("imatge").toString();
        int resID = getResources().getIdentifier(imatgeEmpresa , "drawable", getPackageName());
        e2imatge.setImageResource(resID);
    }

    private void afegirtercerbussines(JSONArray exemple, int posicio) throws JSONException {
        String nomEmpresa = exemple.getJSONObject(posicio).get("nomEmpresa").toString();
        e3nomempresa.setText(nomEmpresa);
        String descripcioEmpresa = exemple.getJSONObject(posicio).get("descripcio").toString();
        e3descripcio.setText(descripcioEmpresa);
        String linkpaginawebempresa = exemple.getJSONObject(posicio).get("linkpaginaweb").toString();
        e3linkpaginaweb.setText(linkpaginawebempresa);
        String telefonEmpresa = exemple.getJSONObject(posicio).get("telefon").toString();
        e3telefon.setText(telefonEmpresa);
        String imatgeEmpresa = exemple.getJSONObject(posicio).get("imatge").toString();
        int resID = getResources().getIdentifier(imatgeEmpresa , "drawable", getPackageName());
        e3imatge.setImageResource(resID);
    }

}

