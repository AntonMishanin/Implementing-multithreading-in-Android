package com.example.loopermessagequeue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import static com.example.loopermessagequeue.ExampleHandler.TASK_A;
import static com.example.loopermessagequeue.ExampleHandler.TASK_B;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    ExampleLooperThread exampleLooperThread = new ExampleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startThread(final View view) {
        exampleLooperThread.start();
    }

    public void stopThread(View view) {
        exampleLooperThread.looper.quit();
    }

    public void taskA(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_A;
        exampleLooperThread.handler.sendMessage(msg);
/*
        Handler threadHandler = new Handler(exampleLooperThread.looper);

        threadHandler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, i + "");
                    SystemClock.sleep(1000);
                }
                Log.d(TAG, "end of run()");
            }
        });
*/

    }

    public void taskB(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_B;
        exampleLooperThread.handler.sendMessage(msg);
    }
}
