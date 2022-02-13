package com.example.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Stack;

public class PaintView extends View {

    private Paint paint;
    private Paint bgPaint;
    private String currentShape = "Rect";
    private String currentColor = "#FFFFFFFF";
    private int bold;
    private boolean full;

    private Stack<Shape> shapes;

    public PaintView(Context context) {
        super(context);
        shapes = new Stack<>();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        bgPaint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(12);
        bgPaint.setColor(Color.rgb(255,255,255));

    }


    public void setStrokeWidth(int width)
    {
        paint.setStrokeWidth(width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(bgPaint);
        for (int i = 0; i < shapes.size(); i++)
            if (shapes.get(i)!=null) {
                shapes.get(i).draw(canvas, paint);
            }
    }

    Shape shape;
    AreaShape shapee;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(currentShape.equals("Rect"))
            {
                shape = new RectShape((int)event.getX(),(int)event.getY(),currentColor,getBold(),getFull());
            }
            if(currentShape.equals("Line"))
            {
                shape = new LineShape((int)event.getX(),(int)event.getY(),currentColor,getBold());
            }
            if(currentShape.equals("Circle"))
            {
                shape = new CircleShape((int)event.getX(),(int)event.getY(),currentColor,getBold(),getFull());
            }
            if(currentShape.equals("Path"))
            {
                shape = new PathShape((int)event.getX(),(int)event.getY(),currentColor,getBold());
            }
            shapes.push(shape);
            invalidate();
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE)
        {
            shape.updatePoint((int)event.getX(),(int)event.getY());
            invalidate();
        }
        return true;
    }

    public void addLine() {
        currentShape = "Line";
    }

    public void addRect() {
        currentShape = "Rect";
    }

    public void addCircle() {
        currentShape = "Circle";
    }

    public void addPath() {
        currentShape = "Path";
    }

    public void setColor(String color)
    {
        currentColor = color;
    }

    public void setBold(int bold2)
    {
        bold = bold2;
    }

    public int getBold(){
        return this.bold;
    }

    public boolean getFull(){return this.full;}

    public void setFull(boolean full5){full=full5;}

    public void undo()
    {
        if(!shapes.empty())
        {
            shapes.pop();
        }
        invalidate();
    }
    public void undoo()
    {
        Stack<Shape> shapess=new Stack<Shape>();
        while(!shapes.isEmpty())
        {
            if(!(shapes.peek() instanceof PathShape))
                shapess.push(shapes.pop());
            else
                shapes.pop();
        }
        while(!shapess.isEmpty())
        {
            shapes.push(shapess.pop());
        }
    }

    public void deleteMaxShape()
    {
        int max=0;
        int area;
        Stack<Shape> shapess=new Stack<Shape>();
        while(!shapes.isEmpty())
        {
            if(shapes.peek() instanceof AreaShape)
            {
                area=((AreaShape) shapes.peek()).areaa();
                if(area>max)
                    max=area;
            }
            shapess.push(shapes.pop());
        }
        while(!shapess.isEmpty())
        {
            if(shapess.peek() instanceof AreaShape)
            {
                area=((AreaShape) shapess.peek()).areaa();
                if(max==area)
                    shapes.push(shapess.pop());
            }
            shapess.pop();
        }
    }
}
