package com.helskiczyn.wisecookfirebase;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class PrzegladajActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayAdapter<String> valuesAdapter;
    ArrayList<String> displayArray;
    ArrayList<String> keysArray;
    ListView listView;
    Firebase przepisRef;
    String clickedKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przegladaj);

        listView = (ListView)findViewById(R.id.listView);

        displayArray  = new ArrayList<>();
        keysArray = new ArrayList<>();
        valuesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,displayArray);
        listView.setAdapter(valuesAdapter);

        listView.setOnItemClickListener(itemClickListener);

        Firebase.setAndroidContext(this);
        przepisRef = new Firebase("https://wisecook.firebaseio.com/Przepis");
        przepisRef.addChildEventListener(childEventListener);
    }

    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            String keyAndValue = dataSnapshot.getKey().toString();
            displayArray.add(keyAndValue);
            keysArray.add(dataSnapshot.getKey().toString());
            updateListView();
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

    private void updateListView(){
        valuesAdapter.notifyDataSetChanged();
        listView.invalidate();
        Log.d("COSTAM", "Length: " + displayArray.size());
    }

    @Override
    public void onClick(View v) {
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            clickedKey = keysArray.get(position);

            Intent intent = new Intent(getApplicationContext(),WybranaPizzaActivity.class);
            intent.putExtra("nazwapizzy", clickedKey);
            startActivity(intent);

            Log.d("KLIKNITY",clickedKey);
        }
    };
}
