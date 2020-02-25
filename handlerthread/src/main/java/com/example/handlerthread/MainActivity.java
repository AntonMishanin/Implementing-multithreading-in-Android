package com.example.handlerthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    ExampleHandlerThread handlerThread = new ExampleHandlerThread();
Runnable runnable1 = new ExampleRunnable1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handlerThread.start();

    }

    public void doWork(View view) {

        Message msg = Message.obtain();
        msg.what = 1;
        msg.arg1 = 2;
        msg.obj = "String obj";
        handlerThread.getHandler().sendMessage(msg);

        handlerThread.getHandler().postDelayed(runnable1, 2000);
        handlerThread.getHandler().post(new ExampleRunnable2());
    }

    public void removeMessage(View view) {

        handlerThread.getHandler().removeCallbacks(runnable1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }

    class ExampleRunnable1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                Log.d(TAG, "Runnable 1: " + i);
                SystemClock.sleep(1000);
            }
        }
    }

    class ExampleRunnable2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                Log.d(TAG, "Runnable 2: " + i);
                SystemClock.sleep(1000);
            }
        }
    }
}
