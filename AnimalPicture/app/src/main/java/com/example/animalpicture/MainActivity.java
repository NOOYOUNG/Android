package com.example.animalpicture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    CheckBox chk;
    TextView textView1, textView2;
    RadioGroup group;
    RadioButton btnDog, btnCat, btnRabbit;
    ImageView imgView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button) findViewById(R.id.button);
        chk=(CheckBox) findViewById(R.id.checkBox);
        textView1=(TextView) findViewById(R.id.text1);
        textView2=(TextView) findViewById(R.id.text2);
        group=(RadioGroup) findViewById(R.id.Group1);
        btnDog=(RadioButton) findViewById(R.id.rdog);
        btnCat=(RadioButton) findViewById(R.id.rcat);
        btnRabbit=(RadioButton) findViewById(R.id.rrabbit);
        imgView=(ImageView) findViewById(R.id.imageView);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk.isChecked()==true){
                    textView2.setVisibility(View.VISIBLE);
                    group.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    imgView.setVisibility(View.VISIBLE);
                }
                else{
                    textView2.setVisibility(View.INVISIBLE);
                    group.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    imgView.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(group.getCheckedRadioButtonId()==R.id.rdog){
                    imgView.setImageResource(R.drawable.dog);
                }
                else if(group.getCheckedRadioButtonId()==R.id.rcat){
                    imgView.setImageResource(R.drawable.cat);
                }
                else if(group.getCheckedRadioButtonId()==R.id.rrabbit){
                    imgView.setImageResource(R.drawable.rabbit);
                }
                else{
                    Toast.makeText(getApplicationContext(), "동물을 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }R
        });

    }
}