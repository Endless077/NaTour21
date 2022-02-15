package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.test.Entity.Utente;
import com.example.test.Retrofit.Enumeration.API;
import com.example.test.Retrofit.Instance.UserRetrofit;
import com.example.test.Retrofit.RequestGenerator;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private final int CAMERA_PERMISSION_CODE = 111;
    private final int STORAGE_PERMISSION_CODE = 222;
    private final int GPS_PERMISSION_CODE = 333;
    private final int NETWORK_PERMISSION_CODE = 444;

    private final String TAG = "MyTest";

    Button checkPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission = findViewById(R.id.checkPermission);

        checkPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Service.isOnline(MainActivity.this))
                    Log.i(TAG,"Sei online!");
                else
                    Log.i(TAG,"Non sei online!");

                if(Service.isGpsOnline(MainActivity.this))
                    Log.i(TAG,"Sei tracciato!");
                else
                    Log.i(TAG,"Non sei tracciato!");

//                if(Service.isServerOnline())
//                    Log.i(TAG,"Server Online!");
//                else
//                    Log.i(TAG,"Server non online!");
            }
        });

//        MotionToast.Companion.createToast(this,
//                "Hurray success 😍",
//                "Upload Completed successfully!",
//                MotionToastStyle.SUCCESS,
//                MotionToast.GRAVITY_BOTTOM,
//                MotionToast.LONG_DURATION,
//                ResourcesCompat.getFont(this,R.font.helvetica_regular));

//        Snackbar snackBar = Snackbar .make(view, "Information Text", Snackbar.LENGTH_LONG).
//                setAction("SnackBar Text", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) { ... }
//        });
//        snackBar.setActionTextColor(Color.WHITE);
//        View snackBarView = snackBar.getView();
//        TextView textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
//        textView.setTextColor(Color.RED);
//        snackBar.show();

//        Toasty.custom(yourContext, "I'm a custom Toast", yourIconDrawable, tintColor, duration, withIcon, shouldTint).show();
//        Toasty.success(MainActivity.this, "This is an success toast.", Toast.LENGTH_SHORT, true).show();

//        UserRetrofit service = RequestGenerator.retrofitInstance(API.USER_API)
//                                                .create(UserRetrofit.class);
//        Utente user = new Utente();
//
//        user.setUsername("Francesco11");
//        user.setEmail("fra.ncesco11@gmail.com");
//        user.setNome("Francesco");
//        user.setCognome("Detto Cesco");
//        user.setPhotolnk("https://photolnk.com");
//
//        //Esempi
//        service.listUser()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<List<Utente>>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.i(TAG, "onSubscribe: Entrato nel subscribe.");
//                    }
//
//                    @Override
//                    public void onSuccess(@NonNull List<Utente> utentes) {
//                        Log.i(TAG, "onSuccess: " + utentes.size());
//
//                        for(Utente u : utentes)
//                            Log.i(TAG, "onSuccess: " + u.getUsername());
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.i(TAG, "onError: Entrato nel error generico");
//                    }
//                });
//
//        service.getUser("Endless077")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<Utente>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.i(TAG, "onSubscribe: Entrato nel subscribe.");
//                    }
//
//                    @Override
//                    public void onSuccess(@NonNull Utente utente) {
//                        Log.i(TAG, "onSuccess: " + utente.getUsername());
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        if(e instanceof HttpException) {
//                            if (((HttpException) e).code() == 404)
//                                Log.i(TAG, "onError: Entrato nel error 404.");
//                        }else {
//                            Log.i(TAG, "onError: Entrato nel error generico.");
//                        }
//                    }
//                });

        //Esempio with Call
//        Call<Void> userAdd = service.postUser(user);
//        Call<List<Utente>> listUser = service.listUser();
//
//        userAdd.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    //Log.i(TAG, "onSuccessful: " + response.body());
//                    Log.i(TAG, "onSuccessful: Add andato a buon fine.");
//                }else{
//                    //Log.i(TAG, "onSuccessful: " + response.code());
//                    //Log.i(TAG, "onSuccessful: " + response.message());
//                    //Log.i(TAG, "onSuccessful: " + response.errorBody());
//                    Log.i(TAG, "onSuccessful: Add non andato a buon fine..");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Log.i(TAG, "onFailure: Fallimento Critico.");
//            }
//        });
//
//        listUser.enqueue(new Callback<List<Utente>>() {
//            @Override
//            public void onResponse(Call<List<Utente>> call, Response<List<Utente>> response) {
//                if (response.isSuccessful()) {
//                    Log.i(TAG, "onSuccessful: " + response.body());
//                }else{
//                    Log.i(TAG, "onSuccessful: " + response.code());
//                    Log.i(TAG, "onSuccessful: " + response.message());
//                    Log.i(TAG, "onSuccessful: " + response.errorBody());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Utente>> call, Throwable t) {
//                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
//            }
//        });

    }

//    private void requestStoragePermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                Manifest.permission.CAMERA)) {
//
//            new AlertDialog.Builder(this)
//                    .setTitle("Permission needed")
//                    .setMessage("This permission is needed because of this and that")
//                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            ActivityCompat.requestPermissions(MainActivity.this,
//                                    new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
//                        }
//                    })
//                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    })
//                    .create().show();
//
//        } else {
//            ActivityCompat.requestPermissions(this,
//                    new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
//        }
//    }

    public void asyncReturn(String username, Callback call)  {
        Utente user = new Utente();

        UserRetrofit servizio = RequestGenerator.retrofitInstance(API.USER_API).create(UserRetrofit.class);

//        Single<Utente> u = servizio.getUser(username)
//                .observeOn(Schedulers.newThread())
//                .subscribeOn(AndroidSchedulers.mainThread());

        servizio.getUser(username)
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Utente>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}
                    @Override
                    public void onSuccess(@NonNull Utente utente) {
                        user.setUsername(utente.getUsername());
                        user.setEmail(utente.getEmail());
                        user.setNome(utente.getNome());
                        user.setCognome(utente.getCognome());
                        user.setPhotolnk(utente.getPhotolnk());

                        call.onSuccess(user);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: FetchAuthSession started.");
                        Log.e(TAG, e.toString());
                        call.onFailure(e);
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission CAMERA GRANTED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission CAMERA DENIED", Toast.LENGTH_SHORT).show();
                }
                return;
            case STORAGE_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission STORAGE GRANTED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission STORAGE DENIED", Toast.LENGTH_SHORT).show();
                }
            case GPS_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission GPS GRANTED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission GPS DENIED", Toast.LENGTH_SHORT).show();
                }
            case NETWORK_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission NETWORK GRANTED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission NETWORK DENIED", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
