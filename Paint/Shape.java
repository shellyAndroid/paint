package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public abstract class Shape {
    protected int x;
    protected int y;
    protected String color;
    //protected boolean full;
    protected int bold;

    public Shape(int x, int y, String color, int bold) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.bold=bold;
        //this.full=full;
    }

    public abstract void updatePoint(int xe,int ye);

    public void draw(Canvas canvas, Paint paint)
    {

        paint.setColor(Color.parseColor(color));
        paint.setStrokeWidth(bold);

    }
}