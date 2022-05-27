package com.example.zeroforuss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zeroforuss.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener; //윤지현 추가 코드
    EditText email2; //아이디
    EditText passWord2;   //비밀번호
    Button JoinButton;// 회원가입 버튼
    Button LoginButton;// 로그인 버튼
    Button RePassword; //비밀번호 재설정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FirebaseApp.initalizesApp(this);
        firebaseAuth = FirebaseAuth.getInstance();//윤지현 추가,firebaseAuth의 인스턴스를 가져옴

        email2 = (EditText)findViewById(R.id.email2);
        passWord2=(EditText)findViewById(R.id.passWord2);
        JoinButton=(Button)findViewById(R.id.joinButton);
        LoginButton=(Button)findViewById(R.id.loginButton);
        RePassword=(Button) findViewById(R.id.repassWord);

        JoinButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //회원가입 화면으로 이동
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                //사장님 가입, 사용자 가입으로 나뉘는 Login Activity로 이동
                startActivity(intent);
            }
        });



        //화면전환 (회원가입(Main activity) -> login activity))
        JoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent); //액티비티 이해주는 구문
            }
        });

        //화면전환 (회원가입(Main activity) -> PasswordResetActivity))
        RePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , PasswordResetActivity.class);
                startActivity(intent); //액티비티 이해주는 구문
            }
        });

        //윤지현 추가 코드
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email2.getText().toString().trim();
                String pwd = passWord2.getText().toString().trim();
                //String형 변수 email.pwd(edittext에서 받오는 값)으로 로그인하는것
                firebaseAuth.signInWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {//성공했을때
                                    Toast.makeText(MainActivity.this, "제로포어스님 환영합니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, MainHomeActivity.class);
                                    startActivity(intent);
                                } else {//실패했을때
                                    Toast.makeText(MainActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }
}







