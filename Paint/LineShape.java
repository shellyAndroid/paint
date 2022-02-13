package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class LineShape extends Shape {

    private int xEnd;
    private int yEnd;
    private int bold;

    public LineShape(int x, int y, String color, int bold) {
        super(x, y, color, bold);
        xEnd = x;
        yEnd = y;
    }

    @Override
    public void updatePoint(int xe, int ye) {
        xEnd = xe;
        yEnd = ye;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(12);
        super.draw(canvas,paint);
        canvas.drawLine(x,y,xEnd,yEnd,paint);
    }
}
