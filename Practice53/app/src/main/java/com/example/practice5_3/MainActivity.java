package com.example.practice5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView tv;
    EditText editTxt;
    WebView web;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button=(Button) findViewById(R.id.button);
        tv=(TextView) findViewById(R.id.textView);
        editTxt=(EditText) findViewById(R.id.editText);
        web=(WebView) findViewById(R.id.webView);

        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=editTxt.getText().toString();
                tv.setText(url);
                web.loadUrl(url);
            }
        });



    }
}