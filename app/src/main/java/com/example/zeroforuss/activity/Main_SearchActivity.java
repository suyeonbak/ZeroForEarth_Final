package com.example.zeroforuss.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Main_SearchActivity extends AppCompatActivity {
    // 검색시 같은 이름이 있는 아이템이 담길 리스트
    ArrayList<SingleItem> search_list = new ArrayList<>();
    // recyclerView에 추가할 아이템 리스트
    ArrayList<SingleItem> original_list = new ArrayList<>();
    // 어댑터
    SimpleTextAdapter adapter;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리스트에 아이템 추가
        original_list.add(new SingleItem("논산 딸기 " ,"2022-05-26   " ,R.drawable.ddal2));
        original_list.add(new SingleItem("후라이드 치킨 " ,"2022-05-26   " ,R.drawable.chick));
        original_list.add(new SingleItem("야채 김밥 " ,"2022-05-26   " ,R.drawable.gimbab));
        original_list.add(new SingleItem("고소한 치즈빵 " ,"2022-05-26   " ,R.drawable.bread));


        editText = findViewById(R.id.editText);

        // editText 리스터 작성
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = editText.getText().toString();
                search_list.clear();

                if(searchText.equals("")){
                    adapter.setItems(original_list);
                }
                else {
                    // 검색 단어를 포함하는지 확인
                    for (int a = 0; a < original_list.size(); a++) {
                        if (original_list.get(a).name.toLowerCase().contains(searchText.toLowerCase())) {
                            search_list.add(original_list.get(a));
                        }
                        adapter.setItems(search_list);
                    }
                }
            }
        });

        // 리사이클러뷰, 어댑터 연결
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SimpleTextAdapter(original_list);
        recyclerView.setAdapter(adapter);
    }
}