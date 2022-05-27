package com.example.zeroforuss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zeroforuss.R;


public class SearchActivity1 extends AppCompatActivity {

    private EditText mEtAddress;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search1);

        mEtAddress = findViewById(R.id.et_address);
        // block touch
        mEtAddress.setFocusable(false);
        mEtAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //주소 검색 웹뷰 화면 이동
                Intent intent = new Intent(SearchActivity1.this, SearchActivity2.class);
                getSearchResult.launch(intent);
            }
        });

    }

    private  final ActivityResultLauncher<Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // SearcActivity2 로부터의 결과값이 이곳으로 전달됨.. (setResult에 의해)
                if(result.getResultCode() == RESULT_OK){
                    if (result.getData() != null){
                        String data = result.getData().getStringExtra("data");
                        mEtAddress.setText(data);
                    }
                }
            }
    );

}