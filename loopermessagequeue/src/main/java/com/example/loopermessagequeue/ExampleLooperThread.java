package com.example.loopermessagequeue;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class ExampleLooperThread extends Thread {
    public static final String TAG = "ExampleLooperThread";
    public Handler handler;
    Looper looper;

    @Override
    public void run() {

        Looper.prepare();
        looper = Looper.myLooper();
        handler = new ExampleHandler();

        Looper.loop();
    }
}
