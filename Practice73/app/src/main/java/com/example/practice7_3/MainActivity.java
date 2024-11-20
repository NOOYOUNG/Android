package com.example.practice7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView tvName, tvEmail;
    EditText editName, editEmail;
    View dialogV, toastV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName=(TextView) findViewById(R.id.tvName);
        tvEmail=(TextView) findViewById(R.id.tvEmail);
        btn1=(Button) findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogV=(View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogV);

                editName=(EditText) dialogV.findViewById(R.id.dlgEdit1);
                editEmail=(EditText) dialogV.findViewById(R.id.dlgEdit2);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvName.setText(editName.getText().toString());
                        tvEmail.setText(editEmail.getText().toString());
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast=new Toast(MainActivity.this);

                        //화면 크기 가져오기
                        Display display=((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        Point size=new Point();
                        display.getSize(size);

                        //랜덤 위치 설정
                        int x=(int)(Math.random()*size.x);
                        int y=(int)(Math.random()*size.y);

                        toastV=(View) View.inflate(MainActivity.this, R.layout.toast1, null);

                        toast.setView(toastV);
                        toast.setGravity(Gravity.TOP|Gravity.LEFT, x, y);
                        toast.show();
                    }
                });

                dlg.show();
            }
        });
    }
}