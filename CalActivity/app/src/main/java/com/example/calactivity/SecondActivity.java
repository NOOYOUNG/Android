package com.example.calactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent intent = getIntent();
        int n1 = intent.getIntExtra("Num1", 0);
        int n2 = intent.getIntExtra("Num2", 0);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);

        // 더하기 버튼 클릭 시
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = n1 + n2;
                Toast.makeText(getApplicationContext(), "계산결과는 " + result, Toast.LENGTH_SHORT).show();
            }
        });

        // 빼기 버튼 클릭 시
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = n1 - n2;
                Toast.makeText(getApplicationContext(), "계산결과는 " + result, Toast.LENGTH_SHORT).show();
            }
        });

        // 곱하기 버튼 클릭 시
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = n1 * n2;
                Toast.makeText(getApplicationContext(), "계산결과는 " + result, Toast.LENGTH_SHORT).show();
            }
        });

        // 나누기 버튼 클릭 시
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (n2 != 0) {
                    result = n1 / n2;
                    Toast.makeText(getApplicationContext(), "계산결과는 " + result, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 돌아가기 버튼 클릭 시
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MainActivity로 돌아갈 때, 결과를 전달
                Intent outIntent = new Intent();
                outIntent.putExtra("calResult", result);
                setResult(RESULT_OK, outIntent);
                finish();  // SecondActivity 종료
            }
        });
    }
}
