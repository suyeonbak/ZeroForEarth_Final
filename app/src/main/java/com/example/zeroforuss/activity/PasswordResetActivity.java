package com.example.zeroforuss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.zeroforuss.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordResetActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;//윤지현 추가
    TextView ResetTextView; //비밀번호재설정 타이틀 글씨
    EditText emailEditText; // 이메일 입력
    Button sendButton;  //보내기 버튼

    //상단바 이전버튼 클릭시 이동할경로 설정
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{

                //비밀번호 재설정 뒤로가기 버튼 클릭 시 메인(로그인)홈으로 이동
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
        setContentView(R.layout.activity_password_reset);

        ResetTextView=(TextView)findViewById(R.id.ResetTextView);
        emailEditText=(EditText)findViewById(R.id.emailEditText);
        sendButton=(Button)findViewById(R.id.sendButton);

        //툴바생성(상단바)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle(" "); // 툴바제목설정

        //윤지현 추가 코드
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.sendButton).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sendButton:
                    send();
                    break;
            }
        }
    };

    private void send() {
        String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();
        if (email.length() > 0) {
            //final RelativeLayout loaderLayout = findViewById(R.id.loaderLyaout);
            //loaderLayout.setVisibility(View.VISIBLE);
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            // loaderLayout.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                Toast.makeText(PasswordResetActivity.this, "비밀번호 재설정 메일을 전송하였습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(PasswordResetActivity.this, "메일을 전송에 실패하였습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}

