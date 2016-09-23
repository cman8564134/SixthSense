package com.example.user.sixthsense;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class Nearby extends AppCompatActivity {
    String res;
    String pana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);




        Intent i = getIntent();
        res = i.getStringExtra("result");


        DatabaseReference mFirebaseDatabaseReference2 = FirebaseDatabase.getInstance().getReference();
        System.out.println(res);
        mFirebaseDatabaseReference2.child(res).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap s = (HashMap) dataSnapshot.getValue();
                pana=s.get("360").toString();
                TextView NearMe = (TextView) findViewById(R.id.textView);
                NearMe.setText(pana);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

 /*   private void aFunction() {
        Picasso.with(this)
                .load(pana)
                .placeholder(R.drawable.park)
                .centerCrop()
                .fit()
                .error(R.drawable.park)
                .into((ImageView) findViewById(R.id.MyImageView));

        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse(pana));

        System.out.println("TESTINTESTINTEAREAD");
        System.out.println(pana);
        ImageView imageView = (ImageView) findViewById(R.id.MyImageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(pana));

// Starts Implicit Activity
                startActivity(i);
            }
        });


    }
*/}
