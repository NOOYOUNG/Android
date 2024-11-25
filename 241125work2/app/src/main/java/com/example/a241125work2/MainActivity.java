package com.example.a241125work2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    RadioGroup rGp;
    RadioButton rbtn1, rbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.button1);
        rGp=(RadioGroup) findViewById(R.id.rGroup);
        rbtn1=(RadioButton) findViewById(R.id.radioButton1);
        rbtn2=(RadioButton) findViewById(R.id.radioButton2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rGp.getCheckedRadioButtonId()==R.id.radioButton1){
                    Intent intent1=new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent1);
                }
                else if(rGp.getCheckedRadioButtonId()==R.id.radioButton2){
                    Intent intent2=new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent2);
                }
            }
        });
    }
}