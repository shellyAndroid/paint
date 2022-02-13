package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CircleShape extends AreaShape {

    private int xEnd;
    private int yEnd;
    private int r;
    private int bold;
    private boolean full;

    public CircleShape(int x, int y, String color, int bold, boolean full) {
        super(x, y, color,bold);
        xEnd = x;
        yEnd = y;
        this.full=full;
    }

    @Override
    public void updatePoint(int xe, int ye) {
        int h;
        h=(x-xEnd)*(x-xEnd)+(y-yEnd)*(y-yEnd);
        r= ((int) Math.sqrt(h))/2;
        xEnd = xe;
        yEnd = ye;
    }

    @Override
    public int areaa(){

        this.area= (int) (this.r*this.r*Math.PI);
        return this.area;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        super.draw(canvas,paint);
        if(full==true)
            paint.setStyle(Paint.Style.FILL);
        else
            paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(xEnd,yEnd,r,paint);
    }
}
