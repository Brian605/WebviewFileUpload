package com.niko.endelevu;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isInternetOn()){
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    AlertDialog alertDialog= new AlertDialog.Builder(SplashActivity.this).create();
                    alertDialog.setTitle("Network error");
                    alertDialog.setMessage("Please Check your connection and try again !!");
                    alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                    alertDialog.show();

                }

            }
        },3000);
    }
    public boolean isInternetOn(){
        boolean connected=false;
        try{
            ConnectivityManager conn= (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
            NetworkInfo info=conn.getActiveNetworkInfo();
            connected=info!=null && info.isAvailable() && info.isConnected();
            return connected;
        } catch (Exception e){
            Log.e("Connectivity Exception", e.getMessage());
        }

        return  connected;
    }

}