package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;

public class PaintActivity extends AppCompatActivity {
    private static final String TAG = "PaintActivity";
    private FrameLayout frame;
    private PaintView paintView;
    public Button btnPoint;
    public Button bold;
    public Button full;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        frame = findViewById(R.id.frm);
        Switch bold=(Switch) findViewById(R.id.bold);
        Switch full=(Switch) findViewById(R.id.full);
        paintView = new PaintView(this);
        frame.addView(paintView);
        btnPoint=findViewById(R.id.btnPoint);
        bold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    paintView.setBold(24);
                } else {
                    paintView.setBold(12);
                }
            }
        });
        full.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    paintView.setFull(true);
                } else {
                    paintView.setFull(false);
                }
            }
        });
       btnPoint.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               paintView.undoo();
               return true;
           }
       });
    }




    public void addLine(View view) {
        paintView.addLine();
    }
    public void addRect(View view) {
        paintView.addRect();
    }
    public void addPath(View view) {
        paintView.addPath();
    }
    public void addCircle(View view) {
        paintView.addCircle();
    }




    public void changeColor(View view)
    {
        String color = view.getTag().toString();
        paintView.setColor(color);
    }

    public void Bolder(View view)
    {
        int bold = paintView.getBold();
        paintView.setStrokeWidth(bold);
    }

    public void delBig(View view)
    {
        paintView.deleteMaxShape();
    }

    public void clear(View view) {
        paintView.undo();
        }
}
