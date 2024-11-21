package com.example.a241121ex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent); // 액티비티 간의 단순 이동
                /*
                만약 액티비티 간 이동할 때 데이터를 갖고 이동하고 싶다면 아래의 순서와 같은 흐름 
                putExtra(); // 데이터를 가져감
                startActivity(); // 액티비티 이동
                getExtra(); // 가져온 데이터를 받음
                 */
            }
        });
    }

}