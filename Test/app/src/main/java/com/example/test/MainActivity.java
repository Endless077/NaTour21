package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.Entity.Utente;
import com.example.test.Retrofit.Enumeration.API;
import com.example.test.Retrofit.Instance.UserRetrofit;
import com.example.test.Retrofit.RequestGenerator;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import es.dmoral.toasty.Toasty;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;
import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        UserRetrofit service = RequestGenerator.retrofitInstance(API.USER_API)
                                                .create(UserRetrofit.class);
        Utente user = new Utente();

        user.setUsername("Francesco11");
        user.setEmail("fra.ncesco11@gmail.com");
        user.setNome("Francesco");
        user.setCognome("Detto Cesco");
        user.setPhotolnk("https://photolnk.com");

        //Esempi
        service.listUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Utente>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "onSubscribe: Entrato nel subscribe.");
                    }

                    @Override
                    public void onSuccess(@NonNull List<Utente> utentes) {
                        Log.i(TAG, "onSuccess: " + utentes.size());

                        for(Utente u : utentes)
                            Log.i(TAG, "onSuccess: " + u.getUsername());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "onError: Entrato nel error generico");
                    }
                });

        service.getUser("Endless077")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Utente>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "onSubscribe: Entrato nel subscribe.");
                    }

                    @Override
                    public void onSuccess(@NonNull Utente utente) {
                        Log.i(TAG, "onSuccess: " + utente.getUsername());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if(e instanceof HttpException) {
                            if (((HttpException) e).code() == 404)
                                Log.i(TAG, "onError: Entrato nel error 404.");
                        }else {
                            Log.i(TAG, "onError: Entrato nel error generico.");
                        }
                    }
                });

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
}
