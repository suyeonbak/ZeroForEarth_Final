package com.example.zeroforuss.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zeroforuss.R;

public class SearchActivity2 extends AppCompatActivity {
//    private RelativeLayout loaderLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);
//        loaderLayout = findViewById(R.id.loaderLyaout);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new BridgeInterface(), "Android");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                // Android -> Javascript 함수 호출
                webView.loadUrl("javascript:sample2_execDaumPostcode();");
            }
        });

        //최초 웹뷰 로드
        webView.loadUrl("https://searchadderess.web.app");

    }

    //웹뷰에서 불러옴
    private class BridgeInterface {
        @JavascriptInterface
        public void processDATA(String data){
            //카카오 주소 검색 결과 API의 결과값이 브릿지 통로를 통해 전달받는다.(from JavaScript)
            Intent intent = new Intent();
            intent.putExtra("data", data);
            setResult(RESULT_OK, intent);
//            loaderLayout.setVisibility(View.VISIBLE);
            finish();
        }
    }


}