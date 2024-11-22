package com.example.imageviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {

    String imagePath=null;

    public myPictureView(Context context, @Nullable AttributeSet attrs){ // 생성자
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(imagePath!=null){ // imgPath가 있다면 이미지 그림
            Bitmap bitmap= BitmapFactory.decodeFile(imagePath); // imgPath에 지정된 경로에서 이미지를 비트맵 객체로 읽음 (이미지 디코딩하여 비트맵 객체로 반환)
            canvas.drawBitmap(bitmap,0,0,null); // 비트맵 캔버스 객체에 그림, (0,0)=왼쪽상단에 이미지 그림
            bitmap.recycle(); // 메모리 해제
        }
    }
}
