package com.covid19.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import com.covid19.view.activities.MainActivity;
import com.trycatch.mysnackbar.Prompt;
import com.trycatch.mysnackbar.TSnackbar;

import java.util.Objects;

public class Utils {

    public static void showLoadingSnack() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                MainActivity.bSnack.addIconProgressLoading(0, true, false)
                        .setText("")
                        .setDuration(TSnackbar.LENGTH_INDEFINITE)
                        .show();
            }
        });
    }

    public static void showBSnack(Prompt prompt, String text) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.bSnack.setPromptThemBackground(prompt).setText(text).setDuration(TSnackbar.LENGTH_LONG).show();
            }
        }, 600);
    }

    public static void hideBSnack() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.bSnack.dismiss();
            }
        }, 600);
    }

    public static boolean isNetworkAvailable(Activity activity) {
        ConnectivityManager manager = (ConnectivityManager)
                Objects.requireNonNull(activity).getSystemService(Context.CONNECTIVITY_SERVICE);
        assert manager != null;
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    public static String editDate(String date) {

        String d = date.substring(5, 10);
        String month = d.substring(0, 2);
        String day = d.substring(3);
        day.substring(1);

        switch (month) {
            case "01":
                month = "January";
                break;
            case "02":
                month = "February";
                break;
            case "03":
                month = "March";
                break;
            case "04":
                month = "April";
                break;
            case "05":
                month = "May";
                break;
            case "06":
                month = "June";
                break;
            case "07":
                month = "July";
                break;
            case "08":
                month = "August";
                break;
            case "09":
                month = "September";
                break;
            case "10":
                month = "October";
                break;
            case "11":
                month = "November";
                break;
            case "12":
                month = "December";
                break;
        }

        return day+" of "+month;
    }
}
