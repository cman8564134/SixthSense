package com.example.user.sixthsense;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class Toggles extends AppCompatActivity {

    String res;
    String pana;

    boolean FanNumber = true;

    boolean LightNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggles);

        Button Fan = (Button) findViewById(R.id.fans_button);
        Button Lights = (Button) findViewById(R.id.lights_button);
        Button FanOff = (Button) findViewById(R.id.fanoff_button);

        Button LightsOff = (Button) findViewById(R.id.lightsoff_button);
        Fan.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
                    mFirebaseDatabaseReference.child("003").child("Light").setValue(0);



                }
    }
    );
        FanOff.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
                                       mFirebaseDatabaseReference.child("003").child("Light").setValue(1);



                                   }
                               }
        );

        Lights.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
                                       mFirebaseDatabaseReference.child("003").child("Name").setValue(1);



                                   }
                               }
        );

        LightsOff.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
                                       mFirebaseDatabaseReference.child("003").child("Name").setValue(0);



                                   }
                               }
        );





    }
}
