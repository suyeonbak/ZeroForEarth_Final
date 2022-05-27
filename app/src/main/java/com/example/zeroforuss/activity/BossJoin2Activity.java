//회원가입 작성내용 (사장 ver.2)
package com.example.zeroforuss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.zeroforuss.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class BossJoin2Activity extends AppCompatActivity {
    private TextInputEditText email, passWord, passwordCheck, nickName; //아이디, 비밀번호, 닉네임 입력필드
    private Button startButton, uploadPhoto; // 회원가입 버튼
    private FirebaseAuth firebaseAuth; //윤지현 추가 코드

    //상단바 이전버튼 클릭시 이동할경로 설정
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{

                Intent intent = new Intent(getApplicationContext(), com.example.zeroforuss.activity.BossJoinActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_join2);

        firebaseAuth = FirebaseAuth.getInstance(); //윤지현 추가 코드

        email = findViewById(R.id.email);
        passWord = findViewById(R.id.passWord);
        passwordCheck = findViewById(R.id.passwordCheck);
        nickName = findViewById(R.id.nickName);
        startButton =(Button)findViewById(R.id.startButton) ;
        uploadPhoto =(Button)findViewById(R.id.uploadPhoto) ;


        //툴바생성(상단바)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle(" "); // 툴바제목설정


        //윤지현 추가 코드 -> 회원가입 버튼 눌렀을 시
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().equals("") && !passWord.getText().toString().equals("")) {
                    // 이메일과 비밀번호가 공백이 아닌 경우
                    createUser(email.getText().toString(), passWord.getText().toString());
                } else {
                    // 이메일과 비밀번호가 공백인 경우
                    Toast.makeText(BossJoin2Activity.this, "계정과 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void createUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공시
                            Toast.makeText(BossJoin2Activity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(BossJoin2Activity.this, com.example.zeroforuss.activity.MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // 계정이 중복된 경우
                            Toast.makeText(BossJoin2Activity.this, "이미 존재하는 계정입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //화면전환 (사진등록-> GalleryActivity)

        uploadPhoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BossJoin2Activity.this , GalleryActivity.class);
                startActivity(intent); //액티비티 이해주는 구문
            }


        });


        //화면전환 (사장정보입력2-> 홈화면)

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BossJoin2Activity.this , MainHomeActivity.class);
                startActivity(intent); //액티비티 이해주는 구문
            }


        });


    }
}