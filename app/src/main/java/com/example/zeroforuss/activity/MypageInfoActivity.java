package com.example.zeroforuss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.zeroforuss.R;

public class MypageInfoActivity extends AppCompatActivity {

    TextView nickname,nicknameInfo,emailText, emailInfo; // 닉네임, 닉네임정보, 전화번호,전화번호정보,생년월일,생년월일정보, 성별, 성별정보

    //상단바 이전버튼 클릭시 이동할경로 설정
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{

                Intent intent = new Intent(getApplicationContext(),MainHomeActivity.class); // 마이페이지 리스트목록으로/ 옮기기
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_info);

        //textview,Button에 해당하는 선언
        emailText=(TextView)findViewById(R.id.emailText); //전화번호
        emailInfo=(TextView)findViewById(R.id.emailInfo); //전화번호정보

        //툴바생성(상단바)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle(" "); // 툴바제목설정

    }
}