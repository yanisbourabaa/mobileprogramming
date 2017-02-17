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
        productList3.add(new Product(10, "Smoothie", "http://www.rd.com/wp-content/uploads/sites/2/2016/05/06-best-worst-drinks-diabetes-fruit.jpg", 3.34f, "http://allrecipes.com/recipes/138/drinks/smoothies/"));
        productList3.add(new Product(11, "MilkShake", "https://blog.banggood.com/wp-content/uploads/2014/08/1721923933.jpg", 8.80f, "http://allrecipes.com/recipe/228324/oreo-milkshake/?internalSource=hub%20recipe&referringContentType=search%20results&clickId=cardslot%201"));
        productList3.add(new Product(12, "Ice Tea", "http://www.demotivateur.fr/images-buzz/6538/iced-tea-1.jpg", 9.32f, "http://allrecipes.com/recipes/16363/drinks/tea/iced/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        productList3.add(new Product(13, "Mojito", "http://www.masculin.com/images/article/12863/variante-mojito.jpg", 8.23f, "http://allrecipes.com/recipes/15045/drinks/cocktails/mojitos/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        return productList3;
    }

    private List<Product> getProductList2() {
        List<Product> productList2 = new ArrayList<>();
        productList2.add(new Product(5, "Pasta", "http://assets.simplyrecipes.com/wp-content/uploads/2016/02/shrimp-pasta-vodka-horiz-a-1600.jpg", 2.45f, "http://allrecipes.com/recipes/565/side-dish/sauces-and-condiments/sauces/pasta-sauces/meat-sauce/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        productList2.add(new Product(6, "Burger", "https://media.timeout.com/images/102945700/image.jpg", 10.30f, "http://allrecipes.com/recipes/473/main-dish/burgers/hamburgers/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        productList2.add(new Product(7, "Tacos", "https://d1doqjmisr497k.cloudfront.net/~/media/Recipe-Photos/McCormick/Main-Dishes/1007x545/Fiesta-Tacos.ashx?vd=20130326T192320Z&hash=0F1DDE4989DDB046E627CF0BF5437C999A647714", 6.60f, "http://allrecipes.com/recipes/17874/main-dish/tacos/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        productList2.add(new Product(8, "Ratatouille", "http://2.bp.blogspot.com/-5GYzMWWLQTc/VRFsvXeQWjI/AAAAAAAAMSk/dRly2w1HOi4/s1600/French%2BRatatouille%2BRecipe.JPG", 8.30f, "http://allrecipes.com/recipe/222006/disneys-ratatouille/?internalSource=hub%20recipe&referringContentType=search%20results&clickId=cardslot%203"));
        productList2.add(new Product(9, "Couscous", "http://photos1.blogger.com/blogger/6339/1978/1600/couscous%20poulet-agneau.jpg", 2.45f, "http://allrecipes.com/recipe/220423/couscous-gourmet/?internalSource=hub%20recipe&referringContentType=search%20results&clickId=cardslot%209"));
        return productList2;
    }

    private List<Product> getProductList1() {
        List<Product> productList1 = new ArrayList<>();
        productList1.add(new Product(1, "Soup", "http://static.cuisineaz.com/680x357/i70854-soupe-a-la-tomate-rapide.jpg", 5.3f, "http://allrecipes.com/recipes/16369/soups-stews-and-chili/soup/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        productList1.add(new Product(2, "Eggs mayo", "https://static.restovisio.com/uploads/2015/09/Oeufs-Durs-Mayonnaise.jpg", 3.30f, "http://allrecipes.com/recipes/17508/appetizers-and-snacks/deviled-eggs/no-mayo-deviled-eggs/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        productList1.add(new Product(3, "Salad", "https://www.wagamama.com/-/media/WagamamaMainsite/hero-pod-images/salads.jpg", 5.40f, "http://allrecipes.com/recipes/96/salad/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        productList1.add(new Product(4, "Sushi", "https://i.ytimg.com/vi/jPLJbSp6vKY/maxresdefault.jpg", 5.40f, "http://allrecipes.com/recipes/17498/world-cuisine/asian/japanese/main-dishes/sushi/?internalSource=hubcard&referringContentType=search%20results&clickId=cardslot%201"));
        return productList1;
    }
}
