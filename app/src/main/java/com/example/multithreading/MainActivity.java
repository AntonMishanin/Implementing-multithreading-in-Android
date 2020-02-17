package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.example.multithreading.MainActivity.TAG;

public class MainActivity extends AppCompatActivity {


    public static String TAG = "MainActivity";
    volatile boolean stopThread = false;


    Handler handler = new Handler();

    Button buttonStartThread;
    volatile int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartThread = findViewById(R.id.buttonStartThread);
    }

    public void onStartThread(View view) {
        stopThread = false;

        ExampleRunnable exampleRunnable = new ExampleRunnable(10);
        Thread thread = new Thread(exampleRunnable);
        thread.start();


    }

    public void onStopThread(View view) {
        stopThread = true;
    }

    class NewThread extends Thread {

        int seconds;

        NewThread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                Log.d(TAG, "seconds: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ExampleRunnable implements Runnable {

        int seconds;

        ExampleRunnable(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                if (stopThread) {
                    return;
                }
                Log.d(TAG, "seconds: " + i + "; Count: " + count);
                if (i == 5) {
                    count = 4;

                    /*
                    Handler handlerThread = new Handler(Looper.getMainLooper());
                    handlerThread.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("5");
                        }
                    });
                    */
                    /*
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("5");
                        }
                    });
                    */
                   /*
                    buttonStartThread.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("5");
                        }
                    });
                    */
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("5");
                        }
                    });
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

