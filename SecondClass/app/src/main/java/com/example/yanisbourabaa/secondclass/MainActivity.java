package com.example.yanisbourabaa.secondclass;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yanisbourabaa.secondclass.cart.CartActivity;
import com.example.yanisbourabaa.secondclass.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Product> productList1 = getProductList1();
        final List<Product> productList2 = getProductList2();
        final List<Product> productList3 = getProductList3();

        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("SecondClass");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, ProductListFragment.newInstance(productList1)).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_starters:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.main_container, ProductListFragment.newInstance(productList1)).commit();
                                break;
                            case R.id.action_entrees:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.main_container, ProductListFragment.newInstance(productList2)).commit();
                                break;
                            case R.id.action_drinks:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.main_container, ProductListFragment.newInstance(productList3)).commit();
                                break;
                        }
                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_pay) {
            startActivity(new Intent(this, CartActivity.class));
        }
        return true;
    }

    private List<Product> getProductList3() {
        final List<Product> productList3 = new ArrayList<>();
        productList3.add(new Product(3, "smoothie", "http://www.rd.com/wp-content/uploads/sites/2/2016/05/06-best-worst-drinks-diabetes-fruit.jpg", 3.34f));
        productList3.add(new Product(3, "smoothie", "http://www.rd.com/wp-content/uploads/sites/2/2016/05/06-best-worst-drinks-diabetes-fruit.jpg", 3.34f));
        productList3.add(new Product(3, "smoothie", "http://www.rd.com/wp-content/uploads/sites/2/2016/05/06-best-worst-drinks-diabetes-fruit.jpg", 3.34f));
        productList3.add(new Product(3, "smoothie", "http://www.rd.com/wp-content/uploads/sites/2/2016/05/06-best-worst-drinks-diabetes-fruit.jpg", 3.34f));
        productList3.add(new Product(3, "smoothie", "http://www.rd.com/wp-content/uploads/sites/2/2016/05/06-best-worst-drinks-diabetes-fruit.jpg", 3.34f));
        return productList3;
    }

    private List<Product> getProductList2() {
        List<Product> productList2 = new ArrayList<>();
        productList2.add(new Product(2, "pasta", "http://assets.simplyrecipes.com/wp-content/uploads/2016/02/shrimp-pasta-vodka-horiz-a-1600.jpg", 2.45f));
        productList2.add(new Product(2, "pasta", "http://assets.simplyrecipes.com/wp-content/uploads/2016/02/shrimp-pasta-vodka-horiz-a-1600.jpg", 2.45f));
        productList2.add(new Product(2, "pasta", "http://assets.simplyrecipes.com/wp-content/uploads/2016/02/shrimp-pasta-vodka-horiz-a-1600.jpg", 2.45f));
        productList2.add(new Product(2, "pasta", "http://assets.simplyrecipes.com/wp-content/uploads/2016/02/shrimp-pasta-vodka-horiz-a-1600.jpg", 2.45f));
        productList2.add(new Product(2, "pasta", "http://assets.simplyrecipes.com/wp-content/uploads/2016/02/shrimp-pasta-vodka-horiz-a-1600.jpg", 2.45f));
        return productList2;
    }

    private List<Product> getProductList1() {
        List<Product> productList1 = new ArrayList<>();
        productList1.add(new Product(1, "Salmon", "https://static01.nyt.com/images/2016/04/13/dining/13PAIRING/13PAIRING-superJumbo.jpg", 5.29f));
        productList1.add(new Product(1, "Salmon", "https://static01.nyt.com/images/2016/04/13/dining/13PAIRING/13PAIRING-superJumbo.jpg", 5.29f));
        productList1.add(new Product(1, "Salmon", "https://static01.nyt.com/images/2016/04/13/dining/13PAIRING/13PAIRING-superJumbo.jpg", 5.29f));
        productList1.add(new Product(1, "Salmon", "https://static01.nyt.com/images/2016/04/13/dining/13PAIRING/13PAIRING-superJumbo.jpg", 5.29f));
        productList1.add(new Product(1, "Salmon", "https://static01.nyt.com/images/2016/04/13/dining/13PAIRING/13PAIRING-superJumbo.jpg", 5.29f));
        productList1.add(new Product(1, "Salmon", "https://static01.nyt.com/images/2016/04/13/dining/13PAIRING/13PAIRING-superJumbo.jpg", 5.29f));
        return productList1;
    }
}
