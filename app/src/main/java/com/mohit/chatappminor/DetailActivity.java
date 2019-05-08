package com.mohit.chatappminor;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class DetailActivity extends AppCompatActivity {

    ProgressBar progressBar;
    WebView webView;

    @SuppressLint("WrongConstant")
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detail);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.webView = (WebView) findViewById(R.id.detailView);

        this.webView.setVisibility(0);
        WebSettings settings = this.webView.getSettings();
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setRenderPriority(RenderPriority.HIGH);
        this.webView.getSettings().setCacheMode(1);
        this.webView.getSettings().setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
        settings.setEnableSmoothTransition(true);
        this.webView.setWebChromeClient(new WebChromeClient());
        this.webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                DetailActivity.this.progressBar.setVisibility(8);
                DetailActivity.this.webView.setVisibility(0);
                DetailActivity.this.webView.loadUrl("javascript:(function() { var a=document.getElementsByTagName('header');a[0].hidden='true';a=document.getElementsByClassName('page_body');a[0].style.padding='0px';var footer=document.getElementsByTagName('footer');footer[0].hidden='true'; })()");
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                DetailActivity.this.webView.loadUrl("file:///android_asset/error.html");
            }
        });
        this.webView.loadUrl(getIntent().getStringExtra(URL));
    }

    public void onBackPressed() {

        DetailActivity.this.finish();
        super.onBackPressed();
    }
}
