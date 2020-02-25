package com.example.handlerthread;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.renderscript.RenderScript;
import android.util.Log;

public class ExampleHandlerThread extends HandlerThread {

    private static final String TAG = "ExampleHandlerThread";

    Handler handler;
    public static final int EXAMPLE_TASK = 1;

    public ExampleHandlerThread() {
        super("ExampleHandlerThread", Process.THREAD_PRIORITY_BACKGROUND);
    }

    @SuppressLint("HandlerLeak")
    @Override
    protected void onLooperPrepared() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case EXAMPLE_TASK:
                        Log.d(TAG, "handleMessage: Example Task, arg 1: " + msg.arg1 + ", obj: " + msg.obj);
                        for (int i = 0; i < 5; i++) {
                            Log.d(TAG, "handleMessage: " + i);
                            SystemClock.sleep(1000);
                        }
                        break;
                }
            }
        };
    }

    public Handler getHandler() {
        return handler;
    }
}
