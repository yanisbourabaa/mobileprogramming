package com.example.yanisbourabaa.secondclass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class ProductListAdapter extends RecyclerView.Adapter<ProductListViewHolder> implements QuantityListener {
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
        Glide.with(context).load(currentProduct.getImage()).into(holder.image);

        holder.setPosition(position);
        holder.setQuantityListener(this);
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
}
