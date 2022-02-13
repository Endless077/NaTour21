package com.example.test;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import es.dmoral.toasty.Toasty;

public class CheckService {

    //Constructor private
    private CheckService() {}

    //Check is permission is granted
    public static void checkCameraEnabled(Context context, int requestCode) {
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Toasty.success(context,"You have already granted CAMERA permission!",
                    Toasty.LENGTH_SHORT, true).show();
        } else {
            requestCamera(context, requestCode);
        }
    }

    public static void checkStorageEnabled(Context context, int requestCode) {
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Toasty.success(context,"You have already granted STORAGE permission!",
                    Toasty.LENGTH_SHORT, true).show();
        } else {
            requestStorage(context, requestCode);
        }
    }

    public static void checkGpsEnabled(Context context, int requestCode) {
        if (checkFineLocation(context) && checkCoarseLocation(context)) {
            Toasty.success(context,"You have already granted GPS permission!",
                    Toasty.LENGTH_SHORT, true).show();
        } else {
            requestGPS(context, requestCode);
        }
    }

    private static boolean checkFineLocation(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private static boolean checkCoarseLocation(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    public static void isNetworkEnabled(Context context, int requestCode) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            Toasty.success(context,"You have already granted NETWORK permission!",
                    Toasty.LENGTH_SHORT, true).show();
        } else {
            requestNetwork(context, requestCode);
        }

    }

    private static boolean checkChangeNetworkLocation(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.CHANGE_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    private static boolean checkAccessNetworkLocation(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    //Check if activated
    public static boolean isGpsOnline(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return (locationManager != null) && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return (ni != null && ni.isConnected());
    }

    //Request permissions
    private static void requestCamera(Context context, int requestCode) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.CAMERA)) {

            new AlertDialog.Builder(context)
                    .setTitle("Utilizzo CAMERA Necessario.")
                    .setMessage("Questo permesso è necessario per utilizzare l'applicazione.")
                    .setPositiveButton("Va bene", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context,
                                    new String[] {Manifest.permission.CAMERA}, requestCode);
                        }
                    })
                    .setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[] {Manifest.permission.CAMERA}, requestCode);
        }
    }


    private static void requestStorage(Context context, int requestCode) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(context)
                    .setTitle("Utilizzo STORAGE Necessario.")
                    .setMessage("Questo permesso è necessario per utilizzare l'applicazione.")
                    .setPositiveButton("Va bene", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context,
                                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, requestCode);
                        }
                    })
                    .setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, requestCode);
        }
    }

    private static void requestGPS(Context context, int requestCode) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(context)
                    .setTitle("Utilizzo GPS Necessario.")
                    .setMessage("Questo permesso è necessario per utilizzare l'applicazione.")
                    .setPositiveButton("Va bene", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context,
                                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
//                            ActivityCompat.requestPermissions((Activity) context,
//                                    new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, requestCode);
                        }
                    })
                    .setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
//            ActivityCompat.requestPermissions((Activity) context,
//                    new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, requestCode);
        }
    }

    private static void requestNetwork(Context context, int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(context)
                    .setTitle("Utilizzo NETWORK Necessario.")
                    .setMessage("Questo permesso è necessario per utilizzare l'applicazione.")
                    .setPositiveButton("Va bene", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            ActivityCompat.requestPermissions((Activity) context,
//                                    new String[] {Manifest.permission.CHANGE_NETWORK_STATE}, requestCode);
//                            ActivityCompat.requestPermissions((Activity) context,
//                                    new String[] {Manifest.permission.ACCESS_NETWORK_STATE}, requestCode);
                            ActivityCompat.requestPermissions((Activity) context,
                                    new String[] {Manifest.permission.INTERNET}, requestCode);
                        }
                    })
                    .setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
//            ActivityCompat.requestPermissions((Activity) context,
//                    new String[] {Manifest.permission.CHANGE_NETWORK_STATE}, requestCode);
//            ActivityCompat.requestPermissions((Activity) context,
//                    new String[] {Manifest.permission.ACCESS_NETWORK_STATE}, requestCode);
            ActivityCompat.requestPermissions((Activity) context,
                    new String[] {Manifest.permission.INTERNET}, requestCode);
        }
    }

}
