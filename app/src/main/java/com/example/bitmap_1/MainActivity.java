package com.example.bitmap_1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Canvas canvas;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageview);
        Bitmap pic = BitmapFactory.decodeResource(getResources(),
                R.drawable.bluejay);
//        Bitmap dstBitmap = Bitmap.createBitmap(
//                pic.getWidth() , // Width
//                pic.getHeight(), // Height
//                Bitmap.Config.ARGB_8888 // Config
//        );
//       Bitmap dstBitmap=Bitmap.createScaledBitmap(pic,100,100,true);

        Matrix mirrorMatrix = new Matrix();
        mirrorMatrix.preRotate(-90);
        mirrorMatrix.preScale(-1, 1);
        Bitmap dstBitmap = Bitmap.createBitmap(pic, 0, 0,
                pic.getWidth(), pic.getHeight(), mirrorMatrix, false);
       // canvas = new Canvas(dstBitmap);
        //canvas.drawBitmap(pic, 0, 0, null);
//         Display the newly created bitmap on app interface
        imageView.setImageBitmap(dstBitmap);
    }


}