package com.example.zeroforuss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.zeroforuss.R;

public class LoginActivity extends AppCompatActivity {

    Button BossButton;  //사장님으로 회원가입할래요 버튼
    Button CustomerButton; // 고객님으로 회원가입할래요 버튼

    //상단바 이전버튼 클릭시 이동할경로 설정
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{

                //로그인 메인화면으로 이동
                Intent intent = new Intent(getApplicationContext(), com.example.zeroforuss.activity.MainActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BossButton= (Button)findViewById(R.id.Bossbutton);
        CustomerButton=(Button)findViewById(R.id.Customerbutton);

        //툴바생성(상단바)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle(" "); // 툴바제목설정


        //화면전환 (로그인 -> 사장님 상점입력)
        BossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , com.example.zeroforuss.activity.BossJoinActivity.class);
                startActivity(intent); //액티비티 이해주는 구문
            }


        });
        //화면전환 (로그인 -> 고객 장보입력)
        CustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , com.example.zeroforuss.activity.CustomerJoinActivity.class);
                startActivity(intent); //액티비티 이해주는 구문
            }


        });
    }
}