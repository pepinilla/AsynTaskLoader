package com.example.carolina.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 23/06/17.
 */

public class More_Info extends AppCompatActivity {

    @Bind(R.id.about_me)
    WebView aboutMe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);
        ButterKnife.bind(this);

        aboutMe.setWebViewClient(new WebViewClient());
        aboutMe.loadUrl("http://www.gooogle.com");
    }
}
