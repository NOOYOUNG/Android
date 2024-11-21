package com.example.calactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity{

    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent intent=getIntent();
        int n1=intent.getIntExtra("Num1", 0);
        int n2=intent.getIntExtra("Num2", 0);

        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);
        btn3=(Button) findViewById(R.id.button3);
        btn4=(Button) findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=n1+n2;
                Toast.makeText(getApplicationContext(), "계산결과는 "+result, Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=n1-n2;
                Toast.makeText(getApplicationContext(), "계산결과는 "+result, Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=n1*n2;
                Toast.makeText(getApplicationContext(), "계산결과는 "+result, Toast.LENGTH_SHORT).show();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=n1/n2;
                Toast.makeText(getApplicationContext(), "계산결과는 "+result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
