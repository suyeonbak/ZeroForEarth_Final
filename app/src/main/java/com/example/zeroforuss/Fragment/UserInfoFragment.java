package com.example.zeroforuss.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zeroforuss.activity.MainActivity;
import com.example.zeroforuss.activity.ManagementActivity;
import com.example.zeroforuss.activity.MypageInfoActivity;
import com.example.zeroforuss.activity.WritePostActivity;
import com.example.zeroforuss.activity.WishlistActivity;
import com.example.zeroforuss.R;

public class UserInfoFragment extends Fragment {
    private View v;
    private ImageView picture; // 개인사진 등록
    private TextView text; // '님'
    private TextView name; // 고객 혹은 보스 이름
    private Button myInfo; // 내정보 버튼
    private Button wishList; // 찜 목록 버튼
    private Button upLoad; // BOSS 상품등록
    private Button upLoadCheck; // BOSS 내가 올린 매물
    private Button logout; // 예원추가 - 로그아웃
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_userinfo,container, false);

        /*//툴바생성(상단바)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" "); // 툴바제목설정*/

        //변수 선언
        picture = (ImageView)v.findViewById(R.id.picture);
        text = (TextView) v.findViewById(R.id.text);
        name = (TextView) v.findViewById(R.id.name);
        myInfo=(Button) v.findViewById(R.id.myInfo);
        wishList=(Button) v.findViewById(R.id.wishList);
        upLoad = (Button) v.findViewById(R.id.upLoad);
        upLoadCheck=(Button) v.findViewById(R.id.upLoadCheck);


        //화면전환 (내 정보 -> MypageInfo)
        myInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MypageInfoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);//액티비티 이해주는 구문

            }


        });

        //에원 추가 - 유저인포프래그먼트(로그아웃)
        logout=(Button) v.findViewById(R.id.logout);
        //화면전환 (BOSS 내가 올린 매물 -> Management)
        logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "로그아웃 되었습니다." , Toast.LENGTH_LONG).show();//fragment토스트
        Intent intent = new Intent(getActivity(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);//액티비티 이해주는 구문
            }
        });

        //화면전환 (찜 목록 -> Wishlist Activity)
        wishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WishlistActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);//액티비티 이해주는 구문

            }


        });

        //화면전환 (Boss 상품등록버튼 -> ProductUpload)
        upLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WritePostActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);//액티비티 이해주는 구문

            }


        });


        //화면전환 (BOSS 내가 올린 매물 -> ManagementActivity)
        upLoadCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ManagementActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);//액티비티 이해주는 구문

            }


        });

        return v;




    }
}
