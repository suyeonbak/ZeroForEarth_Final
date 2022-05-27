package com.example.zeroforuss.Fragment;

import android.Manifest;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.zeroforuss.activity.SearchActivity2;
import com.example.zeroforuss.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class MapFragment extends Fragment {

    Button currentlocation;
    Button search_button;
    private RelativeLayout loaderLayout;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private static final int PERMISSIONS_REQUEST_ACCESS_CALL_PHONE = 2;

    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    private static int REQUEST_ACCESS_FINE_LOCATION = 1000;
    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION};

    //현재 위치
    public LocationManager lm;

    // 위치 정보
    TextView txtCurrentPositionInfo;
    // 위치 버튼
    TextView btnCurrentPositionInfo;

    public double longitude; //경도
    public double latitude; //위도
    public double altitude; //고도
    public float accuracy; //정확도
    public String provider; //위치제공자
    public String currentLocation; // 최종 위치

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);   //setContentView대신에


        //오류 해결 완료
        MapView mapView = new MapView(getContext());
        ViewGroup mapViewContainer = view.findViewById(R.id.mapView);
        mapViewContainer.addView(mapView);
        currentlocation = view.findViewById(R.id.currentlocation);
        search_button = view.findViewById(R.id.search_button);
        loaderLayout = view.findViewById(R.id.loaderLyaout);


        //중심점 변경 - 한림대 정문
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.884464, 127.716582), true);

        //확대 레벨 설정
        mapView.setZoomLevel(1, true);

        /*마커 추가*/
        //마커 찍기
        MapPoint marker_point1 = MapPoint.mapPointWithGeoCoord(37.882640, 127.739126); //예스마트
        MapPoint marker_point2 = MapPoint.mapPointWithGeoCoord(37.881236, 127.736047); //상린
        MapPoint marker_point3 = MapPoint.mapPointWithGeoCoord(37.883238, 127.737931); //우영야식
        MapPoint marker_point4 = MapPoint.mapPointWithGeoCoord(37.882554, 127.737226); //꼴두바우
        MapPoint marker_point5 = MapPoint.mapPointWithGeoCoord(37.881200, 127.739152); //룡의부활
        MapPoint marker_point6 = MapPoint.mapPointWithGeoCoord(37.883561, 127.738679); //피자스쿨
        MapPoint marker_point7 = MapPoint.mapPointWithGeoCoord(37.884952, 127.716893); //스태프핫도그
        MapPoint marker_point8 = MapPoint.mapPointWithGeoCoord(37.885781, 127.716482); //장미공원화로숯불구이
        MapPoint marker_point9 = MapPoint.mapPointWithGeoCoord(37.885769, 127.717973); //춘천원조1호닭갈비막국수
        MapPoint marker_point10 = MapPoint.mapPointWithGeoCoord(37.883817, 127.714362); //엄지척계란빵토스트


        // 마커 아이콘 추가하는 함수
        MapPOIItem marker1 = new MapPOIItem();
        MapPOIItem marker2 = new MapPOIItem();
        MapPOIItem marker3 = new MapPOIItem();
        MapPOIItem marker4 = new MapPOIItem();
        MapPOIItem marker5 = new MapPOIItem();
        MapPOIItem marker6 = new MapPOIItem();
        MapPOIItem marker7 = new MapPOIItem();
        MapPOIItem marker8 = new MapPOIItem();
        MapPOIItem marker9 = new MapPOIItem();
        MapPOIItem marker10 = new MapPOIItem();


        // 클릭 했을 때 나오는 호출 값
        marker1.setItemName("예스마트");
        marker2.setItemName("상린");
        marker3.setItemName("우영야식");
        marker4.setItemName("꼴두바우");
        marker5.setItemName("룡의부활");
        marker6.setItemName("피자스쿨");
        marker7.setItemName("스태프핫도그");
        marker8.setItemName("장미공원화로숯불구이");
        marker9.setItemName("춘천원조1호닭갈비막국수");
        marker10.setItemName("엄지척계란빵토스트");

        // 왜 있는지 잘 모르겠음
        marker1.setTag(0);
        marker2.setTag(0);
        marker3.setTag(0);
        marker4.setTag(0);
        marker5.setTag(0);
        marker6.setTag(0);
        marker7.setTag(0);
        marker8.setTag(0);
        marker9.setTag(0);
        marker10.setTag(0);

        // 좌표를 입력받아 현 위치로 출력
        marker1.setMapPoint(marker_point1);
        marker2.setMapPoint(marker_point2);
        marker3.setMapPoint(marker_point3);
        marker4.setMapPoint(marker_point4);
        marker5.setMapPoint(marker_point5);
        marker6.setMapPoint(marker_point6);
        marker7.setMapPoint(marker_point1);
        marker8.setMapPoint(marker_point2);
        marker9.setMapPoint(marker_point3);
        marker10.setMapPoint(marker_point4);

        //  (클릭 전)기본으로 제공하는 BluePin 마커 모양의 색.
        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker2.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker3.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker4.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker5.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker6.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker7.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker8.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker9.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker10.setMarkerType(MapPOIItem.MarkerType.BluePin);

        // (클릭 후) 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker2.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker3.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker4.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker5.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker6.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker7.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker8.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker9.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        marker10.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);

        mapView.addPOIItem(marker1);
        mapView.addPOIItem(marker2);
        mapView.addPOIItem(marker3);
        mapView.addPOIItem(marker4);
        mapView.addPOIItem(marker5);
        mapView.addPOIItem(marker6);
        mapView.addPOIItem(marker7);
        mapView.addPOIItem(marker8);
        mapView.addPOIItem(marker9);
        mapView.addPOIItem(marker10);


//        if(!checkLocationServicesStatus()){
//            showDialogForLocationServiceSetting();
//        }else {
//            checkRunTimePermission();
//        }


        //현재 위치 버튼 눌렀을 때
        currentlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            loaderLayout.setVisibility(View.VISIBLE);
//                mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
            }
       });


//        화면전환 (주소 검색버튼 누르면 주소검색 화면)
        search_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                loaderLayout.setVisibility(View.VISIBLE);
                Intent intent = new Intent(getActivity(), SearchActivity2.class);
                startActivity(intent);
            }
        });
        return view;
    }


}