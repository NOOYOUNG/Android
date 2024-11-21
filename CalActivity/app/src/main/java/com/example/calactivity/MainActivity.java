package com.example.calactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button) findViewById(R.id.button);
        editText1=(EditText) findViewById(R.id.editText1);
        editText2=(EditText) findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String N1=editText1.getText().toString();
                String N2=editText2.getText().toString();
                int num1=0, num2=0;
                if(!N1.isEmpty()&&!N2.isEmpty()){
                    num1=Integer.parseInt(N1);
                    num2=Integer.parseInt(N2);
                }

                Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", num1);
                intent.putExtra("Num2", num2);
                startActivity(intent);
            }
        });
    }
}