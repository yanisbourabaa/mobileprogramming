package com.example.yanisbourabaa.secondclass.finish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yanisbourabaa.secondclass.R;
import com.example.yanisbourabaa.secondclass.cart.CartActivity;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Float finalPrice = getIntent().getFloatExtra(CartActivity.PRICE, 0.0f);

        String finalPriceString = String.format("%.2f$", finalPrice);
        ((TextView)findViewById(R.id.finish_price)).setText(finalPriceString);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
