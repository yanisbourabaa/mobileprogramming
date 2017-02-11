package com.example.yanisbourabaa.secondclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yanisbourabaa.secondclass.manager.CartManager;
import com.example.yanisbourabaa.secondclass.model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductListFragment extends Fragment {

    RecyclerView recyclerView;
    CartManager mCartManager;
    ProductListAdapter productListAdapter;

    private List<Product> productList = new ArrayList<>();

    public ProductListFragment() {
        // Required empty public constructor
    }

    public static ProductListFragment newInstance(List<Product> productList) {
        ProductListFragment productListFragment = new ProductListFragment();
        productListFragment.setProductList(productList);
        return productListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_product_list, container, false);

        mCartManager = CartManager.getInstance();

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        productListAdapter = new ProductListAdapter(getContext(), productList, mCartManager);
        recyclerView.setAdapter(productListAdapter);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        productListAdapter.notifyDataSetChanged();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
