package com.example.practice6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    ViewFlipper vflip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);
        vflip=(ViewFlipper) findViewById(R.id.vFlip);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vflip.startFlipping();
                vflip.setFlipInterval(1000);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vflip.stopFlipping();
            }
        });
    }
}