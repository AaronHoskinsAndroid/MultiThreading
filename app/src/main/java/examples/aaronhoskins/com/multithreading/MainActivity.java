package examples.aaronhoskins.com.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements RunnableExample.ThreadCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RunnableExample runnableExample = new RunnableExample("Aaron Hoskins", this);
        //Thread/Runnable
        Thread thread = new Thread(runnableExample);
        thread.start();
        ExampleAsyncTask exampleAsyncTask = new ExampleAsyncTask("HelloWorld");
        exampleAsyncTask.execute();
    }

    @Override
    public void returnCountOfString(int count) {
        Log.d("TAG_MAIN", "returnCountOfString: return count is" + count);
    }
}
