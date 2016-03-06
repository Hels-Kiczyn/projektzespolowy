package com.helskiczyn.wisecookfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void przegladaj(View view) {
        startActivity(new Intent(getApplicationContext(), PrzegladajActivity.class));
    }
    public void dodaj(View view) {
        startActivity(new Intent(getApplicationContext(), DodajActivity.class));
    }

    public void ustal(View view) {
        startActivity(new Intent(getApplicationContext(), UstalActivity.class));
    }
}
