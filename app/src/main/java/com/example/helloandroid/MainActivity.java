package com.example.helloandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        EditText eName = (EditText) findViewById(R.id.eName);
        Button bClick = (Button) findViewById(R.id.bClick);
        TextView tName = (TextView) findViewById(R.id.tName);
        Button bShare = (Button) findViewById(R.id.bShare);
        Button bSearch = (Button) findViewById(R.id.bSearch);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        bClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                tName.setText("Hello " + eName.getText());
                onCreateDialog();
                onCreateDialog().show();
            }
        });

        bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, eName.getText());
                intent.setType("text/plain");

                if(intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String url = "https://www.google.com/search?q=" + eName.getText();
                intent.setData(Uri.parse(url));

                if(intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });
    }


    public Dialog onCreateDialog(){
        EditText eName = (EditText) findViewById(R.id.eName);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Hello " + eName.getText()).setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Context context = getApplicationContext();
                CharSequence text = "Positive!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        })
        .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onCreateDialog().dismiss();
                Context context = getApplicationContext();
                CharSequence text = "Negative!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        return builder.create();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        Button bClick = (Button) findViewById(R.id.bClick);

        HashMap<String, Integer> colorMap = new HashMap<>();
        colorMap.put("red", Color.RED);
        colorMap.put("green", Color.GREEN);
        colorMap.put("blue", Color.BLUE);

        bClick.setTextColor(colorMap.get(parent.getItemAtPosition(pos).toString()));
    }

    public void onNothingSelected(AdapterView<?> parent){
        parent.getItemAtPosition(0);
    }
//    public void clicked(View view){
//        EditText eName = (EditText) findViewById(R.id.eName);
//        Button bClick = (Button) findViewById(R.id.bClick);
//        TextView tName = (TextView) findViewById(R.id.tName);
//
//        switch(view.getId()){
//            case R.id.bClick:
//                tName.setText("Hello " + eName.getText());
//                break;
//            default: break;
//        }
//    }

}