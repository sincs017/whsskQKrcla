package com.example.whsskqkrcla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mFireAuth;
    private DatabaseReference mDBRef;
    private EditText mEtEmail, mEtPwd;
    private ImageView mIvProfile;
    private Button mBtNext, mBtBefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFireAuth = FirebaseAuth.getInstance();
        mDBRef = FirebaseDatabase.getInstance().getReference("whsskQKrcla");
        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);
        mIvProfile = findViewById(R.id.iv_profile);
        mBtNext = findViewById(R.id.bt_next);
        mBtBefore = findViewById(R.id.bt_before);

        mBtBefore.setOnClickListener(new View.OnClickListener() {
            //뒤로가기 버튼
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        mBtNext.setOnClickListener(new View.OnClickListener() {
            //NEXT 버튼
            @Override
            public void onClick(View view) {
                //Toast.makeText(RegisterActivity.this, "여기까지 잘 왔군 성공이다", Toast.LENGTH_SHORT).show();
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtPwd.getText().toString();
                mFireAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //회원가입이 성공일 때
                            FirebaseUser firebaseUser = mFireAuth.getCurrentUser();
                            UserInfo userInfo = new UserInfo();
                            userInfo.setEmail(firebaseUser.getEmail());
                            userInfo.setPwd(strPwd);


                            mDBRef.child("UserInfo").child(firebaseUser.getUid()).setValue(userInfo);
                            //mDBRef.child("UserInfo").child(firebaseUser.getUid()).setValue(userInfo.getPwd());

                            Toast.makeText(RegisterActivity.this, "일단 여기까지는 성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, RegisterActivity2.class);
                            startActivity(intent);

                        }


                    }
                });



            }
        });
    }
}