package com.mk.knowledgebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.*;

public class RegisterPage extends AppCompatActivity {

    EditText edtName, edtPassword2, edtEmail2;
    Button btnRegister, btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        edtName = (EditText)findViewById(R.id.edtName);
        edtEmail2 = (EditText)findViewById(R.id.edtEmail2);
        edtPassword2 = (EditText)findViewById(R.id.edtPassword2);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
