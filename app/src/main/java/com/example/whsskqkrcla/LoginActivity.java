package com.example.whsskqkrcla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mFireAuth;
    private DatabaseReference mDBRef;
    private EditText mEtEmail, mEtPwd;
    private Button mBtLogin, mBtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFireAuth = FirebaseAuth.getInstance();
        mDBRef = FirebaseDatabase.getInstance().getReference("whsskQKrcla");
        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);
        mBtRegister = findViewById(R.id.bt_register);
        mBtLogin = findViewById(R.id.bt_login);

        mBtRegister.setOnClickListener(new View.OnClickListener() {
            //회원가입 버튼 눌렀을 때
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mBtLogin.setOnClickListener(new View.OnClickListener() {
            //로그인 버튼 눌렀을 때
            @Override
            public void onClick(View view) {
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtPwd.getText().toString();

                mFireAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //로그인 성공
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else{
                            Toast.makeText(LoginActivity.this, "로그인 실패 ㅋ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}