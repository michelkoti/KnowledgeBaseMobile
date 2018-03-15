package com.mk.knowledgebase;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import DBKnowlegdebaseConn.ManageData;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class LoginPage extends AppCompatActivity {

    EditText edtUserName1, edtPassword1;
    Button btnLogon;
    TextView txtRegister;
    String TAG = "0";
    FirebaseDatabase database;
    DatabaseReference myRef, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        edtUserName1 = (EditText)findViewById(R.id.edtUserName1);
        edtPassword1 = (EditText)findViewById(R.id.edtPassword1);
        btnLogon = (Button)findViewById(R.id.btnLogon);
        txtRegister = (TextView)findViewById(R.id.txtRegister);


/* Insert data method
        // Calling field from database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("tbl_login").child("User1").child("username");
        //Write a data to the database
        myRef.setValue("Username 1");

        myRef = database.getReference("tbl_login").child("User1").child("email");
        myRef.setValue("email@hotmail.com");
*/



        btnLogon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Calling field from database
                database = FirebaseDatabase.getInstance();
//                myRef = database.getReference("tbl_login").child("User1").child("username");
                myRef = database.getReference("tbl_login").child("User1");

                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
//                        String value = dataSnapshot.getValue(String.class);
                        ManageData manageData = dataSnapshot.getValue(ManageData.class);

                        System.out.println(manageData);

                        //Getting fields from screen;
                        String edtusername = edtUserName1.getText().toString();
                        String edtpassword = edtPassword1.getText().toString();

//                        String uuserkey = manageData.getUserkey().toString();
                        String uname = manageData.getUsername().toString();
                        String upassword = manageData.getPassword().toString();

                        if (uname.equals(edtusername) && upassword.equals(edtpassword)) {
                            TAG = "1";
                            Log.d(TAG, " OK If " + edtusername);
                            //Run Initial Page
                            Intent openRegister = new Intent(LoginPage.this, InitialPage.class);
                            startActivity(openRegister);

                        } else {
                            TAG = "2";
                            Log.d(TAG, " OK else " + edtusername);

                        }

                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });



            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openRegister = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(openRegister);
            }
        });

    }
}
