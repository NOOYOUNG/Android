package com.example.imagepoll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.button);

        final String imgName[]={"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서"};
        Integer imgId[]={ R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9 };

        final int voteCnt[]=new int[9];
        for(int i=0; i<9; i++){
            voteCnt[i]=0;
        }

        ImageView img[]=new ImageView[9];
        for(int i=0; i<imgId.length; i++){
            final int idx;
            idx=i;
            img[i]=(ImageView) findViewById(imgId[i]);
            img[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCnt[idx]++;
                    Toast.makeText(getApplicationContext(), imgName[idx]+": 총 "+voteCnt[idx]+"표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("VoteCnt", voteCnt);
                intent.putExtra("ImgName", imgName);
                startActivity(intent);
            }
        });

    }
}