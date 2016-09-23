package com.example.user.sixthsense;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class Information extends AppCompatActivity {
    private NFCKeys n;
    String res;
    String pana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent i = getIntent();
        res = i.getStringExtra("result");

        DatabaseReference mFirebaseDatabaseReference2 = FirebaseDatabase.getInstance().getReference();
        System.out.println(res);
        mFirebaseDatabaseReference2.child(res).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap s = (HashMap) dataSnapshot.getValue();

                n = new NFCKeys(
                        s.get("Information").toString(),
                        s.get("Image").toString(),
                        s.get("Name").toString(),
                        s.get("Category").toString());


                pana=s.get("360").toString();
                aFunction();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void aFunction() {
        Picasso.with(this)
                .load(n.getImage())
                .placeholder(R.drawable.park)
                .centerCrop()
                .fit()
                .error(R.drawable.park)
                .into((ImageView) findViewById(R.id.ImageView));

        TextView t = (TextView) findViewById(R.id.editText3);
        t.setText(n.getName());
        TextView t2 = (TextView) findViewById(R.id.editText4);
        t2.setText(n.getInformation());

        Button NearMe = (Button) findViewById(R.id.button4);
        Button Contribute = (Button) findViewById(R.id.button3);
        Button SmartControl = (Button) findViewById(R.id.button5);


        Contribute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Report.class);
                if (res != null)
                    i.putExtra("result", res);
                System.out.println(res);

                startActivity(i);
            }

        });
        NearMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(pana));
                startActivity(i);
            }

        });
        SmartControl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Toggles.class);

                System.out.println(res);

                startActivity(i);
            }

        });
    }
}
