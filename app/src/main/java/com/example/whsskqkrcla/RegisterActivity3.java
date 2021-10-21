package com.example.whsskqkrcla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class RegisterActivity3 extends AppCompatActivity {

    private FirebaseAuth mFireAuth;
    private DatabaseReference mDBRef;
    private Button mBtNext, mBtBefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        mFireAuth = FirebaseAuth.getInstance();
        mBtBefore = findViewById(R.id.bt_before);
        mBtNext = findViewById(R.id.bt_next);

        mBtBefore.setOnClickListener(new View.OnClickListener() {
            //뒤로가기 버튼
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity3.this, RegisterActivity2.class);
                startActivity(intent);
            }
        });

        mBtNext.setOnClickListener(new View.OnClickListener() {
            //NEXT 버튼
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity3.this, RegisterActivity4.class);
                startActivity(intent);
            }
        });

    }
}