package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class RectShape extends AreaShape {

    private int xEnd;
    private int yEnd;
    private int bold;
    private boolean full;

    public RectShape(int x, int y, String color,int bold, boolean full) {
        super(x, y, color,bold);
        xEnd = x;
        yEnd = y;
        this.full=full;
    }

    @Override
    public void updatePoint(int xe, int ye) {
        xEnd = xe;
        yEnd = ye;
    }
    @Override
    public int areaa(){
        this.area=(xEnd-x)*(yEnd-y);
        return this.area;
    }


    @Override
    public void draw(Canvas canvas, Paint paint) {
        if(full==true)
            paint.setStyle(Paint.Style.FILL);
        else
            paint.setStyle(Paint.Style.STROKE);
        super.draw(canvas,paint);
        canvas.drawRect(x,y,xEnd,yEnd,paint);
    }
}
