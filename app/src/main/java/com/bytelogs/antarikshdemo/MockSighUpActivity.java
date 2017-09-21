package com.bytelogs.antarikshdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MockSighUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_sigh_up);
        Button bt = (Button)findViewById(R.id.sighUp);
    }
    public void gotoWelcome(View view){
        Intent intent = new Intent(MockSighUpActivity.this,NewsActivity.class);
        startActivity(intent);
    }

}
