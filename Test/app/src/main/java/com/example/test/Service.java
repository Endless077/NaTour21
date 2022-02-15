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
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.test.Retrofit.Enumeration.API;
import com.example.test.Retrofit.Instance.ServerUtils;
import com.example.test.Retrofit.RequestGenerator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.URL;

import es.dmoral.toasty.Toasty;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Service {

    private static final String TAG = "CHECK_SERVICE";

    //Constructor private
    private Service() {}

    //Check is permission is granted
    public static void checkCameraEnabled(Context context, int requestCode) {
        Log.i(TAG, "checkCameraEnabled: started.");
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Toasty.success(context,"You have already granted CAMERA permission!",
                    Toasty.LENGTH_SHORT, true).show();
        } else {
            requestCamera(context, requestCode);
        }
    }

    public static void checkStorageEnabled(Context context, int requestCode) {
        Log.i(TAG, "checkStorageEnabled: started.");
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Toasty.success(context,"You have already granted STORAGE permission!",
                    Toasty.LENGTH_SHORT, true).show();
        } else {
            requestStorage(context, requestCode);
        }
    }

    public static void checkGpsEnabled(Context context, int requestCode) {
        Log.i(TAG, "checkGpsEnabled: started.");
        if (checkFineLocation(context) && checkCoarseLocation(context)) {
            Toasty.success(context,"You have already granted GPS permission!",
                    Toasty.LENGTH_SHORT, true).show();
        } else {
            requestGPS(context, requestCode);
        }
    }

    private static boolean checkFineLocation(Context context) {
        Log.i(TAG, "checkFineLocation: started.");
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private static boolean checkCoarseLocation(Context context) {
        Log.i(TAG, "checkCoarseLocation: started.");
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    public static void checkNetworkEnabled(Context context, int requestCode) {
        Log.i(TAG, "checkNetworkEnabled: started.");
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
            Toasty.success(context,"You have already granted NETWORK permission!",
                    Toasty.LENGTH_SHORT, true).show();
        } else {
            requestNetwork(context, requestCode);
        }
    }

    private static boolean checkChangeNetworkLocation(Context context) {
        Log.i(TAG, "checkChangeNetworkLocation: started.");
        return ContextCompat.checkSelfPermission(context, Manifest.permission.CHANGE_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    private static boolean checkAccessNetworkLocation(Context context) {
        Log.i(TAG, "checkAccessNetworkLocation: started.");
        return ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    //Check if activated
    public static boolean isGpsOnline(Context context) {
        Log.i(TAG, "isGpsOnline: started.");
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return (locationManager != null) && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static void isServerOnline(Callback call) {
        ServerUtils serverUtils = RequestGenerator.retrofitInstance(API.SERVER_API)
                .create(ServerUtils.class);

        serverUtils.getServiceStatus()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}
                    @Override
                    public void onComplete() {
                        call.onSuccess(null);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        call.onFailure(e);
                    }
                });
    }

    public static boolean pingServer() {
        Log.i(TAG, "isServerOnline: started.");

        String hostName = "192.168.1.53";
        int port = 8080;
        int timeout = 3000;

        SocketAddress socketAddress = new InetSocketAddress(hostName, port);
        Socket socket = new Socket();

        try {
            socket.connect(socketAddress, timeout);
            socket.close();
            Log.i(TAG, "isServerOnline: online.");
            return true;
        } catch (SocketTimeoutException exception) {
            Log.e(TAG, "SocketTimeoutException " + hostName + ":" + port + ". " + exception.getMessage());
            return false;
        } catch (IOException exception) {
            Log.e(TAG, "IOException - Unable to connect to " + hostName + ":" + port + ". " + exception.getMessage());
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        Log.i(TAG, "isOnline: started.");
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return (ni != null && ni.isConnected());
    }

    //Request permissions
    private static void requestCamera(Context context, int requestCode) {
        Log.i(TAG, "requestCamera: started.");
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
        Log.i(TAG, "requestStorage: started.");
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
        Log.i(TAG, "requestGPS: started.");
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
        Log.i(TAG, "requestNetwork: started.");
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