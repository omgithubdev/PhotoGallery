package com.omagrahari.wiproassignment.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by omprakash on 13,January,2020
 */
public class Utils {
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
