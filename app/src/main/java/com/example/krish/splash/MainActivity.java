package com.example.krish.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Timer t = new Timer();
        boolean checkConnection = new ApplicationUtility().checkConnection(this);
        if (checkConnection) {
            t.schedule(new splash(), 3000);
        } else {
            Toast.makeText(MainActivity.this,
                    "connection not found...plz check connection", Toast.LENGTH_LONG).show();
        }
    }

    class splash extends TimerTask {

        @Override
        public void run() {
            Intent i = new Intent(MainActivity.this, Second.class);
            finish();
            startActivity(i);
        }

    }


}