package com.example.abhik.part1_abhiksarkar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicDisplay extends AppCompatActivity {
    ImageView img;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_display);
        img = (ImageView) findViewById(R.id.img_full);
        String url = getIntent().getStringExtra("intent");
        Picasso.with(context).load(url).into(img);
    }
}
