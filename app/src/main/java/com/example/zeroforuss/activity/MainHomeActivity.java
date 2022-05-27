//하단바
package com.example.zeroforuss.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.zeroforuss.Fragment.HomeFragment;
import com.example.zeroforuss.Fragment.MapFragment;
import com.example.zeroforuss.Fragment.UserInfoFragment;
import com.example.zeroforuss.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainHomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰(하단바)
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MapFragment Map;
    private HomeFragment Home;
    private UserInfoFragment UserInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_location:
                        setFrag(0);
                        break;
                    case R.id.action_home:
                        setFrag(1);
                        break;
                    case R.id.action_person:
                        setFrag(2);
                        break;

                }
                return true;
            }
        });
        Map = new MapFragment();
        Home = new HomeFragment();
        UserInfo = new UserInfoFragment();
        setFrag(1); //첫 프래그먼트 화면을 무엇으로 지정해 줄것인지 선택(홈화면)

    }
    //프레그먼트 교체가 일어나는 실행문.
    private void setFrag(int n) {

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, Map);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, Home);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, UserInfo);
                ft.commit();
                break;

        }
    }
}