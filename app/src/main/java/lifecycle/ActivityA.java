package lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import activity.intents.R;

public class ActivityA extends AppCompatActivity {
    private static final String TAG = "ActivityA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        setTitle("A");
        Log.d(TAG, "onCreate A");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart A");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume A");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause A");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop A");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart A");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy A");
    }

    public void clickedA(View view){
        switch (view.getId()){
            case R.id.baA:
                startActivity(new Intent(this, ActivityA.class));
                break;
            case R.id.baB:
                startActivity(new Intent(this, ActivityB.class));
                break;
            case R.id.baC:
                startActivity(new Intent(this, ActivityC.class));
                break;
        }
    }
}
