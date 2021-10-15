package com.example.helloandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import activity.intents.R;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    private View popupWindowView;
    private TextView t1Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText eName = (EditText) findViewById(R.id.eName);
        Button bClick = (Button) findViewById(R.id.bClick);
        TextView tName = (TextView) findViewById(R.id.tName);

        bClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                tName.setText("Hello " + eName.getText());
//                createNewDialogWindow();
//                t1Name.setText("Hello " + eName.getText());
            }
        });
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