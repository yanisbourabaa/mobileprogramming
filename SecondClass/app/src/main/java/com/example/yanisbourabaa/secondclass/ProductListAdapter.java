package com.example.yanisbourabaa.secondclass;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.yanisbourabaa.secondclass.manager.CartManager;
import com.example.yanisbourabaa.secondclass.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanisbourabaa on 10/02/2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListViewHolder> implements QuantityListener, ImageClickedListener, RatingListener {
    private CartManager mCartManager;
    private Context context;
    List<Product> products = new ArrayList<>();

    public ProductListAdapter(Context context, List<Product> products, CartManager cartManager) {
        this.context = context;
        this.products = products;
        this.mCartManager = cartManager;
    }

    @Override
    public ProductListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cell_product, parent, false);
        return new ProductListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductListViewHolder holder, int position) {
        bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    private void bind(ProductListViewHolder holder, int position) {
        Product currentProduct = products.get(position);
        holder.name.setText(currentProduct.getName());
        String quantity = "" + mCartManager.getQuantity(currentProduct.getId());
        holder.quantity.setText(quantity);
        String price = currentProduct.getPrice().toString() + "$";
        holder.price.setText(price);
        holder.ratingBar.setRating(currentProduct.getRate());


        Glide.with(context).load(currentProduct.getImage()).into(holder.image);

        holder.setPosition(position);
        holder.setQuantityListener(this);
        holder.setImageClickedListener(this);
        holder.setOnRatingChangeListener(this);
    }

    @Override
    public void addProduct(int position) {
        Product currentProduct = products.get(position);
        mCartManager.addProduct(currentProduct);
        notifyDataSetChanged();
    }

    @Override
    public void removeProduct(int position) {
        Product currentProduct = products.get(position);
        mCartManager.removeProduct(currentProduct);
        notifyDataSetChanged();
    }

    @Override
    public void onImageClicked(int position) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(products.get(position).getRecipeUrl()));
        context.startActivity(i);
    }

    @Override
    public void onRateChange(int position, int rate) {
        products.get(position).setRate(rate);
    }
}
