package com.example.androidexercise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.androidexercise.R;
import com.example.androidexercise.fragments.Fragment1;
import com.example.androidexercise.fragments.Fragment2;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (findViewById(R.id.fragment_layout) != null) {

            if (savedInstanceState != null) {
                return;
            }

            Fragment1 fragment1 = new Fragment1();


            fragment1.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_layout, fragment1).commit();

        }
    }

    public void loadFragment1() {

        Fragment1 fragment1 = new Fragment1();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_layout, fragment1);
        transaction.addToBackStack(null);

        transaction.commit();
    }


    public void loadFragment2() {

        Fragment2 fragment2 = new Fragment2();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_layout, fragment2);
        transaction.addToBackStack(null);

        transaction.commit();
    }

}
