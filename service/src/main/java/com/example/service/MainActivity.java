package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.text);
    }

    public void startService(View view) {
        String inputText = input.getText().toString();

        Intent intentService = new Intent(this, ExampleService.class);
        intentService.putExtra("inputText", inputText);

        startService(intentService);
    }

    public void stopService(View view) {

        Intent intentService = new Intent(this, ExampleService.class);
        stopService(intentService);
    }
}
