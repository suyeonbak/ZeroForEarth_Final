//회원가입 작성내용 (고객)

package com.example.zeroforuss.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class CustomerJoinActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth; //윤지현 추가 코드
    private TextInputEditText email2, passWord2, passwordCheck2, nickName2; //아이디, 비밀번호, 닉네임 입력필드
    private Button startButton,uploadPhoto2; // 회원가입 버튼,사진 업로드 버튼
    final int GET_GALLERY_IMAGE = 200; //윤지현 추가 코드
    ImageView imageView2;//윤지현 추가 코드

    //상단바 이전버튼 클릭시 이동할경로 설정
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{

                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_join);

        firebaseAuth = FirebaseAuth.getInstance(); //윤지현 추가 코드

        email2 = findViewById(R.id.email2);
        passWord2 = findViewById(R.id.passWord2);
        passwordCheck2 = findViewById(R.id.passwordCheck2);
        nickName2 = findViewById(R.id.nickName2);
        startButton =(Button)findViewById(R.id.startButton) ;
        uploadPhoto2= (Button)findViewById(R.id.uploadPhoto2);
        imageView2 = findViewById(R.id.imageView2);

        //툴바생성(상단바)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle(" "); // 툴바제목설정

        //윤지현 추가 코드 -> 회원가입 버튼 눌렀을 시
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email2.getText().toString().equals("") && !passWord2.getText().toString().equals("")) {
                    // 이메일과 비밀번호가 공백이 아닌 경우
                    createUser(email2.getText().toString(), passWord2.getText().toString());
                } else {
                    // 이메일과 비밀번호가 공백인 경우
                    Toast.makeText(CustomerJoinActivity.this, "계정과 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(CustomerJoinActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(CustomerJoinActivity.this, com.example.zeroforuss.activity.MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // 계정이 중복된 경우
                            Toast.makeText(CustomerJoinActivity.this, "이미 존재하는 계정입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    //윤지현 추가 코드 - 갤러리


        //화면전환 (고객가입창 -> 홈화면)

//        startButton.setOnClickListener(new View.OnClickListener() {
//        public void onClick(View view) {
//        Intent intent = new Intent(CustomerJoinActivity.this , MainHomeActivity.class);
//        startActivity(intent); //액티비티 이해주는 구문
//        }
//
//
//        });

        //윤지현 추가 - 프로필 사진
        uploadPhoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    imageView2.setImageURI(uri);
                }
                break;
        }
    }
}