package com.example.practice7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText edtAngle;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 여행기");

        edtAngle=(EditText) findViewById(R.id.editAngle);
        imgView=(ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.itemRotate){
            int angle=Integer.parseInt(edtAngle.getText().toString());
            imgView.setRotation(angle);
            return true;
        } else if (item.getItemId()==R.id.halla) {
            imgView.setImageResource(R.drawable.jeju2);
            return true;
        } else if (item.getItemId()==R.id.chuja) {
            imgView.setImageResource(R.drawable.jeju6);
            return true;
        } else if (item.getItemId()==R.id.bumsum) {
            imgView.setImageResource(R.drawable.jeju14);
            return true;
        }
        return false;
    }
}