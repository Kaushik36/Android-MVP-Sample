package com.kaushik.mvp.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kaushik on 28-02-2018.
 */

public class AppData {

    public static final String LOG = "MVP_APP_LOG_MSG";

    public static void changeFonts(TextView textViewpre_font,
                                   Context mContext, String font) {

        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/" + font);

        try {
            textViewpre_font.setTypeface(tf);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

   /*This method is used to Show Toast to user
    * @param ctx Context is used to define current state of the application
    * @param msg Message is user defined message
    * @type true is for long length toast and false is for short length toast
    **/

    public static void showToast(Context ctx, String msg, boolean type) {

        if (type == true) {
            Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        }

    }

     /*This method is used to check internet connectivity
      * @param ctx Context is used to define current state of the application
      **/

    public static boolean isNetworkConnected(Context c) {

        boolean status = false;

        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                status = true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                status = true;
            }
        } else {
            // not connected to the internet
            status = false;
        }

        return status;
    }

    /**
     * print log message
     * @param msg
     */
    public static void showLogMessage(String msg) {

        //if (BuildConfig.DEBUG) {
        Log.e(LOG, msg);
        // }

    }

}
