package com.example.yanisbourabaa.firstclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.tv_second_act);

        String result = getString(R.string.tv_second_act_title) + " " + getIntent().getStringExtra(MainActivity.NAME) + " !";
        textView.setText(result);
    }
}
