package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ImageDescription extends AppCompatActivity {

    ImageView image;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_description);

        image = findViewById(R.id.imageView);
        text = findViewById(R.id.textView);

        Intent intent = getIntent();

        String imageID = intent.getStringExtra("imageID");
        String desc = intent.getStringExtra("imageDes");

        text.setText(desc);

        String url = "https://muthosoft.com/univ/photos/";
        Picasso.get().load(url+imageID).into(image);
    }
}