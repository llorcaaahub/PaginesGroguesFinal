package com.example.paginesgrogues;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BussinesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussines);


        //Spinner spinner = (Spinner) findViewById(R.id.spinner_tipus_bussines);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipus_de_bussines, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        //spinner.setAdapter(adapter);
        //String paraula = loadJSONFromAsset();



    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("bussines.json")));
            String paraula = "exemple";

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                mLine = mLine + ".";
            }

        } catch (IOException e) {
            //log the exception
        }

        String paraula = "Exemple";
        return paraula;
    }

}

