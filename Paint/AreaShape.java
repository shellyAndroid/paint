package com.example.paint;

abstract class AreaShape extends Shape{
    protected int area;

    public AreaShape(int x, int y, String color, int bold) {
        super(x, y, color, bold);
    }

    public int areaa(){
        return 0;
    }

    @Override
    public abstract void updatePoint(int xe, int ye) ;
}
