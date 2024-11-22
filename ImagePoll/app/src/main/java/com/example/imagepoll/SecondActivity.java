package com.example.imagepoll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Integer imageFileId[] = {
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
        };

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCnt");
        String[] imgName = intent.getStringArrayExtra("ImgName");

        TextView mostTxt = findViewById(R.id.mostTxt);
        ImageView mostImg = findViewById(R.id.mostImg);

        // 가장 많이 투표 받은 이미지 찾기
        int maxVote = 0;
        for (int i = 1; i < voteResult.length; i++) {
            if (voteResult[i] > voteResult[maxVote]) {
                maxVote = i;
            }
        }
        mostTxt.setText(imgName[maxVote]);
        mostImg.setImageResource(imageFileId[maxVote]);

        // 각 이미지의 투표 결과를 RatingBar로 표시
        TextView tv[] = new TextView[imgName.length];
        RatingBar rbar[] = new RatingBar[imgName.length];

        Integer tvId[] = {
                R.id.PicTxt1, R.id.PicTxt2, R.id.PicTxt3, R.id.PicTxt4,
                R.id.PicTxt5, R.id.PicTxt6, R.id.PicTxt7, R.id.PicTxt8,
                R.id.PicTxt9
        };
        Integer rbarId[] = {
                R.id.ratingBar1, R.id.ratingBar2, R.id.ratingBar3, R.id.ratingBar4,
                R.id.ratingBar5, R.id.ratingBar6, R.id.ratingBar7, R.id.ratingBar8,
                R.id.ratingBar9
        };

        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = findViewById(tvId[i]);
            rbar[i] = findViewById(rbarId[i]);
            tv[i].setText(imgName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 결과 화면을 닫고 돌아가기
            }
        });
    }
}
