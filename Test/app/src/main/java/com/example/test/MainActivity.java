package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import io.reactivex.rxjava3.annotations.NonNull;

public class MainActivity extends AppCompatActivity {

    private final int CAMERA_PERMISSION_CODE = 111;
    private final int STORAGE_PERMISSION_CODE = 222;
    private final int GPS_PERMISSION_CODE = 333;
    private final int NETWORK_PERMISSION_CODE = 444;

    private final String TAG = "MyTest";

    FrameLayout frameLayout;
    FragmentTest fragmentTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);

        fragmentTest = new FragmentTest();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragmentTest);
        fragmentTransaction.commit();

//        //Check Service
//        checkPermission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Service.isOnline(MainActivity.this))
//                    Log.i(TAG,"Sei online!");
//                else
//                    Log.i(TAG,"Non sei online!");
//
//                if(Service.isGpsOnline(MainActivity.this))
//                    Log.i(TAG,"Sei tracciato!");
//                else
//                    Log.i(TAG,"Non sei tracciato!");
//
//                Service.isServerOnline(new Callback() {
//                    @Override
//                    public void onSuccess(Object o) {
//                        Log.i(TAG,"Server online!");
//                    }
//                    @Override
//                    public void onFailure(Throwable e) {
//                        Log.i(TAG,"Server offline!");
//                        Log.i(TAG,e.getLocalizedMessage());
//                    }
//                });
//            }
//        });

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

//        }
//    }

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
