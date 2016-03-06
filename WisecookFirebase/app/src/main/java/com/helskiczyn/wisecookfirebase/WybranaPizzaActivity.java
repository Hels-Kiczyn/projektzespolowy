package com.helskiczyn.wisecookfirebase;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class WybranaPizzaActivity extends AppCompatActivity {
    Firebase ref;
    String odczytanaNazwa;
    TextView nazwaTextView;
    TextView opisTextView;
    ImageView zdjecieImageView;
    ArrayList<String> listaSkladnikow;
    ArrayList<String> listaIlosci;
    TableLayout tabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybrana_pizza);

        tabela=(TableLayout)findViewById(R.id.country_table);
        nazwaTextView = (TextView)findViewById(R.id.textView2);
        opisTextView  = (TextView)findViewById(R.id.textView4);
        zdjecieImageView  = (ImageView)findViewById(R.id.imageView);

        Intent intent = getIntent();
        odczytanaNazwa = intent.getStringExtra("nazwapizzy");

        funkcja(odczytanaNazwa);

        listaSkladnikow = new ArrayList<>();
        listaIlosci = new ArrayList<>();
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://wisecook.firebaseio.com/PrzepisMaSkladnik/");
        Firebase przepisRef = ref.child(odczytanaNazwa);
        przepisRef.addChildEventListener(childEventListener);
    }

    void uzupelnij(String skladnik, String ilosc) {

        TableRow row;
        TextView t1, t2;
        //Converting to dip unit
        int dip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                (float) 1, getResources().getDisplayMetrics());


            row = new TableRow(this);

            t1 = new TextView(this);
            t2 = new TextView(this);

            t1.setText(skladnik+": ");
            t2.setText(ilosc);

            t1.setTypeface(null, 1);
            t2.setTypeface(null, 1);

            t1.setGravity(Gravity.RIGHT);
            t2.setGravity(Gravity.LEFT);

            t1.setTextColor(Color.WHITE);

            t1.setTextSize(17);
            t2.setTextSize(17);
            //t2.setTextSize();

            t1.setPadding(16 * dip, 0, 0, 0);

            row.addView(t1);
            row.addView(t2);

            tabela.addView(row, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));


    }



        ChildEventListener childEventListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String skladnik = dataSnapshot.getKey().toString();
                String ilosc = dataSnapshot.getValue().toString();
                listaSkladnikow.add(skladnik);
                listaIlosci.add(ilosc);
                Log.v("Odczyt", listaSkladnikow.get(listaSkladnikow.size() - 1) + " - " + listaIlosci.get(listaIlosci.size() - 1));

                uzupelnij(skladnik,ilosc);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        };

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
                    .into(zdjecieImageView);
        }
    }
}
