package examples.aaronhoskins.com.multithreading;

import android.os.AsyncTask;
import android.util.Log;

public class ExampleAsyncTask extends AsyncTask<String, String, String> {
    private String stringToEvaluate;

    public ExampleAsyncTask(String stringToEvaluate) {
        this.stringToEvaluate = stringToEvaluate;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        stringToEvaluate = stringToEvaluate + "EVAL";
    }

    @Override
    protected String doInBackground(String... strings) {
        String returnString = "";
        for(int i = stringToEvaluate.length()-1 ; i >= 0 ; i--) {
            char currentChar = stringToEvaluate.charAt(i);
            publishProgress("Currently Evaluating " + currentChar);
            returnString = returnString + currentChar;
        }
        return returnString;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.d("TAG", values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("TAG", s);
    }
}
