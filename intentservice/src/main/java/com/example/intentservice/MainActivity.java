package com.example.intentservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.edit_text);
    }

    public void startIntentService(View view) {
        String input = inputText.getText().toString();

        Intent intentService = new Intent(this, ExampleIntentService.class);
        intentService.putExtra("inputExtra", input);

        ContextCompat.startForegroundService(this, intentService);
    }
}
