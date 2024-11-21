package com.example.paintit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final static int LINE=1, CIRCLE=2, RECTANGLE=3;
    static int curShape=LINE;
    static int curColor= Color.DKGRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("Paint It!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"선");
        menu.add(0,2,0,"원");
        menu.add(0,3,0,"사각형");

        SubMenu sMenu=menu.addSubMenu("색상변경");
        sMenu.add(0,4,0,"검정");
        sMenu.add(0,5,0,"빨강");
        sMenu.add(0,6,0,"파랑");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==1){
            curShape=LINE;
            return true;
        }
        else if(item.getItemId()==2){
            curShape=CIRCLE;
            return true;
        }
        else if(item.getItemId()==3){
            curShape=RECTANGLE;
            return true;
        }
        else if(item.getItemId()==4){
            curColor=Color.BLACK;
            return true;
        }
        else if(item.getItemId()==5){
            curColor=Color.RED;
            return true;
        }
        else if(item.getItemId()==6){
            curColor=Color.BLUE;
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View{
        int startX=-1, startY=-1, stopX=-1, stopY=-1;
        private List<Shape> shapes = new ArrayList<>();
        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                startX=(int) event.getX();
                startY=(int) event.getY();
            }
            else if(event.getAction()==MotionEvent.ACTION_UP){
                stopX=(int) event.getX();
                stopY=(int) event.getY();
                this.invalidate();
            }
            else if(event.getAction()==MotionEvent.ACTION_DOWN){
                stopX=(int) event.getX();
                stopY=(int) event.getY();
                this.invalidate();
            }
            return true;
        }

        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint=new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(curColor);

            if(curShape==LINE){
                canvas.drawLine(startX,startY,stopX,stopY,paint);
            }
            else if(curShape==CIRCLE){
                int radius=(int)Math.sqrt(Math.pow(stopX-startX,2)+ Math.pow(stopY-startY,2));
                canvas.drawCircle(startX,startY,radius,paint);
            }
            else if(curShape==RECTANGLE){
                Rect rect=new Rect(startX,startY,stopX,stopY);
                canvas.drawRect(rect,paint);
            }
        }
    }
}