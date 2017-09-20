package com.bytelogs.antarikshdemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final int SPLASHTIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MockSighUpActivity.class);//intent are used for jumping from one activity to other activity
                startActivity(intent);          //startActivity method with parameter of object of intent
                MainActivity.this.finish();
            }
        },SPLASHTIME);

    }
}
