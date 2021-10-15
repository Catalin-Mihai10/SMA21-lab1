package lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import activity.intents.R;

public class ActivityB extends AppCompatActivity {
    private static final String TAG = "ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        setTitle("B");
        Log.d(TAG, "onCreate B");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart B");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume B");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause B");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop B");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart B");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy B");
    }

    public void clickedB(View view){
        switch (view.getId()){
            case R.id.bbA:
                startActivity(new Intent(this, ActivityA.class));
                break;
            case R.id.bbB:
                startActivity(new Intent(this, ActivityB.class));
                break;
            case R.id.bbC:
                startActivity(new Intent(this, ActivityC.class));
                break;
        }
    }
}
