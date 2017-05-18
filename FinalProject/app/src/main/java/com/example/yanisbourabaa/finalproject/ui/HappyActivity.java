package com.example.yanisbourabaa.finalproject.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yanisbourabaa.finalproject.R;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManager;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManagerImpl;

public class HappyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy);

        TextView textView = (TextView) findViewById(R.id.happy_activity_text);
        String happy = "You should\n" + DataManagerImpl.getInstance().getRandomHappy();
        textView.setText(happy);
    }
}
