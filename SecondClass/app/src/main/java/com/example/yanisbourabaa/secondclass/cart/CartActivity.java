package com.example.yanisbourabaa.secondclass.cart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yanisbourabaa.secondclass.ProductListFragment;
import com.example.yanisbourabaa.secondclass.R;
import com.example.yanisbourabaa.secondclass.finish.FinishActivity;
import com.example.yanisbourabaa.secondclass.manager.CartManager;

public class CartActivity extends AppCompatActivity {

    CartManager mCartmanager;
    public static String PRICE = "PRICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mCartmanager = CartManager.getInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cart_container, ProductListFragment.newInstance(mCartmanager.getCart()))
                .commit();

        Button btn = (Button) findViewById(R.id.cart_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this, FinishActivity.class);
                i.putExtra(PRICE, mCartmanager.getFinalPrice());
                mCartmanager.clearCart();
                startActivity(i);
            }
        });
    }
}
