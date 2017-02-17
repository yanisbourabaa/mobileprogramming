package com.example.yanisbourabaa.thirdclass;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new MyGridAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        String address = "http://maps.google.co.in/maps?q=" + getString(R.string.address);
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                        startActivity(i);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        });
    }
}
