package examples.aaronhoskins.com.multithreading;

import android.util.Log;

public class RunnableExample implements Runnable {
    private String stringToEvaluate;
    ThreadCallback callback;

    public RunnableExample(String stringToEvaluate, ThreadCallback callback) {
        this.stringToEvaluate = stringToEvaluate;
        this.callback = callback;
    }

    @Override
    public void run() {
        Log.d("TAG", "run: String Length is " + stringToEvaluate.length());
        callback.returnCountOfString(stringToEvaluate.length());
    }

    interface ThreadCallback{
        void returnCountOfString(int count);
    }
}
