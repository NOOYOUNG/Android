package com.example.calactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String N1 = editText1.getText().toString();
                String N2 = editText2.getText().toString();
                int num1 = 0, num2 = 0;

                if (!N1.isEmpty() && !N2.isEmpty()) {
                    num1 = Integer.parseInt(N1);
                    num2 = Integer.parseInt(N2);
                }

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", num1);
                intent.putExtra("Num2", num2);

                // startActivityForResult 호출 (requestCode는 1로 설정)
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            // SecondActivity에서 전달한 결과 받기
            int calResult = data.getIntExtra("calResult", 0);
            // 계산 결과를 Toast로 표시
            Toast.makeText(getApplicationContext(), "계산 결과는 " + calResult, Toast.LENGTH_SHORT).show();
        }
    }
}
