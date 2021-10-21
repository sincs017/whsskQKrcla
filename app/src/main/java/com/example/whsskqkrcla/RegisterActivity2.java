package com.example.whsskqkrcla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class RegisterActivity2 extends AppCompatActivity {

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
                Intent intent = new Intent(RegisterActivity2.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mBtNext.setOnClickListener(new View.OnClickListener() {
            //NEXT 버튼
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity2.this, RegisterActivity3.class);
                startActivity(intent);
            }
        });

    }
}