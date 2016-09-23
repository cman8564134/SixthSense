package com.example.user.sixthsense;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Report extends AppCompatActivity {
    String res;
    public RadioGroup radioGroup;

    public RadioGroup radioGroup2;

    public RadioGroup radioGroup3;

    public RadioGroup radioGroup4;
     Contribution c=new Contribution();
    String [] ans=new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Intent i = getIntent();
        res = i.getStringExtra("result");

        radioGroup=(RadioGroup)findViewById(R.id.group1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=(RadioButton)findViewById(checkedId);
                ans[0]=rb.getText().toString();


            }
        });
        radioGroup2=(RadioGroup)findViewById(R.id.group2);

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=(RadioButton)findViewById(checkedId);
                ans[1]=rb.getText().toString();

            }
        });


        radioGroup4=(RadioGroup)findViewById(R.id.group4);

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                RadioButton rb=(RadioButton)findViewById(checkedId);
                ans[2]=rb.getText().toString();

            }
        });



        Button b = (Button) findViewById(R.id.contribute_button) ;
        b.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {

                 c.setBark(ans[0]);
                 c.setLegs(ans[1]);
                 c.setMeow(ans[2]);
                 DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
                 mFirebaseDatabaseReference.child(res).child("record").push().setValue(c);
                 finish();



                                   }
                               }
        );
    }




}
