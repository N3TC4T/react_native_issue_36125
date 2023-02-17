package com.mycustomlib;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

public class MyCustomView extends ViewGroup {
    private MyCustomListener listener;

    public MyCustomView(Context context) {
        super(context);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sendEvents();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }


    private void sendEvents() throws InterruptedException {

        float value = 0;

        while (value < 1000){

            Thread.sleep(800);

            // just wait for listener
            if(null == listener){
                continue;
            }

            value += 1;

            // just send the events for both onAnimatedEventIssue and onAnimatedEventWorks
            listener.onAnimatedEventIssue(value);
            listener.onAnimatedEventWorks(value);

        }
    }

    public void setEventListener(MyCustomListener listener) {
        this.listener = listener;
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    public interface MyCustomListener {
        void onAnimatedEventIssue( float value);
        void onAnimatedEventWorks( float value);
    }
}
