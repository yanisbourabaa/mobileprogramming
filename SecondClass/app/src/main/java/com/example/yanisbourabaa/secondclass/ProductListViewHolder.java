package com.example.yanisbourabaa.secondclass;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yanisbourabaa on 10/02/2017.
 */
public class ProductListViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView name;
    TextView price;
    TextView quantity;
    private Button addButton;
    private Button removeButton;
    private QuantityListener quantityListener;
    private int position;

    public ProductListViewHolder(View itemView) {
        super(itemView);
        this.image = (ImageView) itemView.findViewById(R.id.cell_iv_image);
        this.name = (TextView) itemView.findViewById(R.id.cell_tv_name);
        this.quantity = (TextView) itemView.findViewById(R.id.cell_tv_quantity);
        this.price = (TextView) itemView.findViewById(R.id.cell_tv_price);
        this.addButton = (Button) itemView.findViewById(R.id.cell_btn_add);
        this.removeButton = (Button) itemView.findViewById(R.id.cell_btn_remove);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityListener.addProduct(position);
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityListener.removeProduct(position);
            }
        });
    }

    public void setQuantityListener(QuantityListener quantityListener) {
        this.quantityListener = quantityListener;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
