package com.example.natour21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    enum AppFragment {
        SingleAccount,
        MultipleAccount,
        B2C
    }

    private ConstraintLayout mContentMain;
    private AppFragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set default fragment
        mContentMain = findViewById(R.id.content_main);
        setCurrentFragment(AppFragment.B2C);

    }

    private void setCurrentFragment(final AppFragment newFragment){
        if (newFragment == mCurrentFragment) {
            return;
        }

        mCurrentFragment = newFragment;
        displayFragment();
    }

    private void displayFragment() {
        attachFragment(new B2CModeFragment());
        return;
    }

    private void attachFragment(final Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(mContentMain.getId(),fragment)
                .commit();
    }

}