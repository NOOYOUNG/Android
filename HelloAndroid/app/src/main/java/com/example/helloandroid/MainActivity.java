package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 부모 클래스 객체 먼저 생성되고 :: super=AppCompatActivity(부모클래스객체)
        setContentView(R.layout.activity_main); // 이후에 내가 set

        //앱아이콘 설정
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher); //이미지를 drawable에 넣어서 ic_launcher로 설정
    }
}