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

public class BussinesActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bussines);

        t1 = findViewById(R.id.titol1);
        t2 = findViewById(R.id.titol2);
        t3 = findViewById(R.id.titol3);
        sp= findViewById(R.id.spinner_tipus_bussines);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_tipus_bussines);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipus_de_bussines, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        String paraula = loadJSONFromAsset();



    }

    public String loadJSONFromAsset() {
        String json = null;


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("bussines.json")));
            String paraula = "exemple";

            // do reading, usually loop until end of file reading
            StringBuilder sb = new StringBuilder();
            String mLine;
            while ((mLine= reader.readLine()) != null) {
                //process line
                sb.append(mLine);


            }
            JSONArray exemple = new JSONArray(sb.toString());
            String  numero = "ii";



            t1.setText((CharSequence) exemple.getJSONObject(0).get("nomEmpresa"));
            t2.setText((CharSequence) exemple.getJSONObject(1).get("nomEmpresa"));
            t3.setText((CharSequence) exemple.getJSONObject(2).get("nomEmpresa"));

        } catch (IOException | JSONException e) {
            //log the exception

        }


        String paraula = "Exemple";
        return paraula;
    }

}

