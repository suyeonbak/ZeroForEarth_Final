package com.example.zeroforuss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.zeroforuss.R;

public class BossJoinActivity extends AppCompatActivity {

    TextView shopname,shopaddress,shopnumber,time,shopcategory,wave;    //상점명, 상점주소,상점번호,운영시간,상점정보,~ 선언
    EditText marketnameEditText,addressEditText,phoneNumberEditText,openTime,closeTime; // 상점명,상점주소,상점번호, 오픈시간,종료시간 입력 선언
    Spinner spinner;    //스피너 선언
    Button nextbutton;  //다음버튼 선언

    //상단바 이전버튼 클릭시 이동할경로 설정
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{

                //이전버튼 클릭 시 사장님으로 가입할래요 고객님으로 가입할래요 창 나오도록 설정
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
        setContentView(R.layout.activity_boss_join);

        shopname=(TextView)findViewById(R.id.shopname);
        shopaddress=(TextView)findViewById(R.id.shopaddress);
        shopnumber=(TextView)findViewById(R.id.shopnumber);
        time=(TextView)findViewById(R.id.time);
        shopcategory=(TextView)findViewById(R.id.shopcategory);
        wave=(TextView)findViewById(R.id.wave);
        marketnameEditText=(EditText)findViewById(R.id.marketnameEditText);
        addressEditText=(EditText)findViewById(R.id.addressEditText);
        phoneNumberEditText=(EditText)findViewById(R.id.phoneNumberEditText);
        openTime=(EditText)findViewById(R.id.openTime);
        closeTime=(EditText)findViewById(R.id.closeTime);
        spinner=(Spinner)findViewById(R.id.spinner);
        nextbutton=(Button)findViewById(R.id.nextbutton);

        //툴바생성(상단바)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle(" "); // 툴바제목설정

        //화면전환 (사장정보입력1 -> 사장정보입력2)

        nextbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(BossJoinActivity.this , BossJoin2Activity.class);
                startActivity(intent); //액티비티 이해주는 구문
            }


        });


    }
}