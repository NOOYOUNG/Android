package com.example.datetimeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    Chronometer chrono;
    RadioGroup group;
    RadioButton dateBtn, timeBtn;
    CalendarView calendarView;
    TimePicker timePicker;
    int selectedY, selectedM, selectedD;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);
        chrono=(Chronometer) findViewById(R.id.chronometer);
        group=(RadioGroup) findViewById(R.id.rGroup);
        dateBtn=(RadioButton) findViewById(R.id.radioButton1);
        timeBtn=(RadioButton) findViewById(R.id.radioButton2);
        calendarView=(CalendarView) findViewById(R.id.dateView);
        timePicker=(TimePicker) findViewById(R.id.timePick);
        textView=(TextView) findViewById(R.id.textView);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(group.getCheckedRadioButtonId()==R.id.radioButton1){
                    calendarView.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.INVISIBLE);
                }
                else if(group.getCheckedRadioButtonId()==R.id.radioButton2){
                    timePicker.setVisibility(View.VISIBLE);
                    calendarView.setVisibility(View.INVISIBLE);
                }
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectedY=i;
                selectedM=i1+1;
                selectedD=i2;
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                textView.setText(Integer.toString(selectedY)+"년 "+Integer.toString(selectedM)+"월 "+Integer.toString(selectedD)+"일 "+Integer.toString(timePicker.getHour())+"시 "+Integer.toString(timePicker.getMinute())+"분");
            }
        });

    }
}