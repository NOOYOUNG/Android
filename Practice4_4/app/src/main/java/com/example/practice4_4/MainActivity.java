package com.example.practice4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch switch1;
    RadioGroup group;
    RadioButton btnlolli, btnougat, btnpie;
    ImageView imgView;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(TextView) findViewById(R.id.text1);
        text2=(TextView) findViewById(R.id.text2);
        switch1=(Switch) findViewById(R.id.switch1);
        group=(RadioGroup) findViewById(R.id.group);
        btnlolli=(RadioButton) findViewById(R.id.rlollipop);
        btnougat=(RadioButton) findViewById(R.id.rnougat);
        btnpie=(RadioButton) findViewById(R.id.rpie);
        imgView=(ImageView) findViewById(R.id.imageView);
        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switch1.isChecked()==true){
                    text2.setVisibility(View.VISIBLE);
                    group.setVisibility(View.VISIBLE);
                    imgView.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    group.setVisibility(View.INVISIBLE);
                    imgView.setVisibility(View.INVISIBLE);
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                }
            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                updateImg();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    private void updateImg(){
        if(group.getCheckedRadioButtonId()==R.id.rlollipop){
            imgView.setImageResource(R.drawable.lollipop);
            imgView.showContextMenu();
        }
        else if(group.getCheckedRadioButtonId()==R.id.rnougat){
            imgView.setImageResource(R.drawable.nougat);
        }
        else if(group.getCheckedRadioButtonId()==R.id.rpie){
            imgView.setImageResource(R.drawable.pie);
        }
    }
}