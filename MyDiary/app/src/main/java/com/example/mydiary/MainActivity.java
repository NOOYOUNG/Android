package com.example.mydiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText editDiary;
    Button btn;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=(DatePicker) findViewById(R.id.datePick);
        editDiary=(EditText) findViewById(R.id.editText);
        btn=(Button) findViewById(R.id.button);

        Calendar cal=Calendar.getInstance();
        int cYear=cal.get(Calendar.YEAR);
        int cMonth=cal.get(Calendar.MONTH);
        int cDay=cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                fileName=Integer.toString(i)+"_"
                        +Integer.toString(i1)+"_"
                        +Integer.toString(i2)+"_";

                String str=readDiary(fileName);
                editDiary.setText(str);
                btn.setEnabled(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs=openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str=editDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),fileName+"이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e){
                }
            }
        });

    }

    String readDiary(String fName){
        String diaryStr=null;
        FileInputStream inFs;

        try{
            inFs=openFileInput(fName);
            byte[] txt=new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr=(new String(txt).trim());
            btn.setText("수정하기");
        } catch (IOException e) {
            editDiary.setHint("저장된 일기 없음");
            btn.setText("새로 쓰기");
        }
        return diaryStr;
    }

}