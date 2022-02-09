package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.test.Entity.Utente;
import com.example.test.Retrofit.Enumeration.API;
import com.example.test.Retrofit.Instance.UserRetrofit;
import com.example.test.Retrofit.RequestGenerator;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            MotionToast.Companion.createToast(this,
                    "Hurray success 😍",
                    "Upload Completed successfully!",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular));
        */

        //Toasty.custom(yourContext, "I'm a custom Toast", yourIconDrawable, tintColor, duration, withIcon, shouldTint).show();
        //Toasty.success(MainActivity.this, "This is an success toast.", Toast.LENGTH_SHORT, true).show();

        UserRetrofit service1 = RequestGenerator.retrofitInstance(API.USER_API)
                                                .create(UserRetrofit.class);

        UserRetrofit service2 = RequestGenerator.retrofitInstance(API.USER_API)
                                                .create(UserRetrofit.class);

        Utente user = new Utente();

        user.setUsername("Francesco11");
        user.setEmail("fra.ncesco11@gmail.com");
        user.setNome("Francesco");
        user.setCognome("Detto Cesco");
        user.setPhotolnk("https://photolnk.com");

        /*
        //Call
        Call<Void> userAdd = service1.postUser(user);
        Call<List<Utente>> listUser = service2.listUser();

        userAdd.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    //Log.i(TAG, "onSuccessful: " + response.body());
                    Log.i(TAG, "onSuccessful: Add andato a buon fine.");
                }else{
                    //Log.i(TAG, "onSuccessful: " + response.code());
                    //Log.i(TAG, "onSuccessful: " + response.message());
                    //Log.i(TAG, "onSuccessful: " + response.errorBody());
                    Log.i(TAG, "onSuccessful: Add non andato a buon fine..");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.i(TAG, "onFailure: Fallimento Critico.");
            }
        });

        listUser.enqueue(new Callback<List<Utente>>() {
            @Override
            public void onResponse(Call<List<Utente>> call, Response<List<Utente>> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "onSuccessful: " + response.body());
                }else{
                    Log.i(TAG, "onSuccessful: " + response.code());
                    Log.i(TAG, "onSuccessful: " + response.message());
                    Log.i(TAG, "onSuccessful: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Utente>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
        */

    }
}
