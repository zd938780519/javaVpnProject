package com.mchsdk.paysdk.pengproject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.help_web)
    WebView helpWeb;
    private String adUrl = "http://eqs.6717ps.cn/game/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }


    private void initView(){
        helpWeb.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        WebSettings settings = helpWeb.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true); // 是否可访问Content Provider的资源，默认值 true
        settings.setAllowFileAccess(true);    // 是否可访问本地文件，默认值 true
        settings.setSupportZoom(true);
//        settings.setDomStorageEnabled(true);
        //辅助WebView处理图片上传操作
//        nativeWeb.setWebChromeClient(new MyChromeWebClient());
        helpWeb.loadUrl(adUrl);


        helpWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("getid+++===" , url);
                if (!url.contains("protocol://android")) {
//                    Uri uri = Uri.parse(url);
//                    String scheme = uri.getScheme();
//                    String host = uri.getHost();
////                  MCLog.e("telhost++===" , host);
//                    Log.e("scheme+++===" , scheme);


                    return false;
                }


                //                nativeWeb.loadUrl("javascript:getid()");
                Log.e("getid+++===" , url);
//                Map<String, String> map = getParamsMap(url, "protocol://android");
//                String code = map.get("code");
//                String data = map.get("data");
//                Log.e("data+++===" , data);
//                parseCode(code, data);
//                Toast.makeText(instance, "请到个人页面进行登录！", Toast.LENGTH_SHORT).show();
//
//                return true;
                return super.shouldOverrideUrlLoading(view, url);
            }


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
//                mProgressDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                mProgressDialog.hide();
            }

        });

    }


}
