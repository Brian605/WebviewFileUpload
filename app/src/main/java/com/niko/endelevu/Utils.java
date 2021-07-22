package com.niko.endelevu;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class Utils {
    private static Utils utils;
    public static Utils getInstance() {
        if (utils==null){
            utils=new Utils();
        }
        return utils ;
    }

    public void isNetworkAvailable(Context context){

        
    }

    public boolean isAppInstalled(Context context,String uri){
        PackageManager manager=context.getPackageManager();

        try {
            manager.getPackageInfo(uri,PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context,"No App installed to perform requested task",Toast.LENGTH_LONG).show();
        }
        return false;
    }
}
