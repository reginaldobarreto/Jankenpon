package br.com.barrsoft.jankenpon;

import android.os.AsyncTask;
import android.util.Log;

public class BackGround extends AsyncTask<Void,Void,Void> {

    public static final String TAG = BackGround.class.getName();
    
    @Override
    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute: ");
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.i(TAG, "doInBackground: ");
        return null;
    }
    
    @Override
    protected void onPostExecute(Void aVoid) {
        Log.i(TAG, "onPostExecute: ");
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.i(TAG, "onProgressUpdate: ");
        super.onProgressUpdate(values);
    }
    
}