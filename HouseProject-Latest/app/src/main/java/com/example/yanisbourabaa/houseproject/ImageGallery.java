package com.example.yanisbourabaa.houseproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * Created by jvalerio on 2/26/2017.
 */

public class ImageGallery extends AppCompatActivity implements View.OnClickListener {

    Button nextBtn, prevBtn;
    ImageView currImg;
    int currentIndex = 0;
    String[] imageURLs;
    TextView imageStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_gallery);
        setTitle("Image Gallery");

        Intent intent = getIntent();
        House selHouse = (House) intent.getSerializableExtra("House");
        imageURLs = selHouse.getImageURLs();

        if (imageURLs == null) {
            return;
        }

        imageStat = (TextView) findViewById(R.id.image_stat);

        prevBtn = (Button) findViewById(R.id.previous_btn);
        prevBtn.setOnClickListener(this);

        nextBtn = (Button) findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(this);

        currImg = (ImageView) findViewById(R.id.current_image);

        if (imageURLs.length >= 1) {
            showImage(imageURLs[0]);
        }
    }

    public void onClick (View v) {
        switch (v.getId()) {

            case (R.id.previous_btn):

                currentIndex--;

                if (currentIndex < 0) {
                    currentIndex = imageURLs.length - 1; // array size - 1
                }

                showImage(imageURLs[currentIndex]);

                break;

            case (R.id.next_btn):

                currentIndex++;

                if (currentIndex == imageURLs.length) { // array size
                    currentIndex = 0;
                }

                showImage(imageURLs[currentIndex]);

                break;

        }
    }

    private void showImage(String img) {

        Glide.with(this).load(img).into(currImg);

        imageStat.setText("Image " + (currentIndex + 1) + " out of " + imageURLs.length);
    }

}
