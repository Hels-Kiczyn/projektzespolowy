package com.helskiczyn.wisecookfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Map;

public class WybranaPizzaActivity extends AppCompatActivity {
    String odczytanaNazwa;
    TextView nazwaTextView;
    TextView opisTextView;
    ImageView zdjecieImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybrana_pizza);

        nazwaTextView = (TextView)findViewById(R.id.textView2);
        opisTextView = (TextView)findViewById(R.id.textView4);
        zdjecieImageView = (ImageView)findViewById(R.id.imageView);


        Intent intent = getIntent();
        odczytanaNazwa = intent.getStringExtra("nazwapizzy");

        funkcja(odczytanaNazwa);
    }

    protected void funkcja(String nazwapizzy){
        //super.onStart();

        Firebase ref2 = new Firebase("https://wisecook.firebaseio.com/Przepis");

        Firebase przepisRef = ref2.child(nazwapizzy);
        przepisRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);
                String nazwa = map.get("nazwa");
                nazwaTextView.setText(nazwa);
                String opis = map.get("opis");
                opisTextView.setText(opis);
                ustawZdjecie(map.get("zdjecie"));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void ustawZdjecie(String adres){
        if(adres==null){
            Picasso.with(this)
                    .load("http://wisecook.hol.es/image_unavailable_376x212.jpg")
                    .into(zdjecieImageView);
        }
        else {
            Picasso.with(this)
                    .load(adres)
                    .resize(500, 500)
                    .into(zdjecieImageView);
        }
    }
}
