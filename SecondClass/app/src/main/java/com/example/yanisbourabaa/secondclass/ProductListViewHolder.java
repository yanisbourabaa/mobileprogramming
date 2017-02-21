package com.example.yanisbourabaa.secondclass;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by yanisbourabaa on 10/02/2017.
 */
public class ProductListViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView name;
    TextView price;
    TextView quantity;
    RatingBar ratingBar;
    private Button addButton;
    private Button removeButton;
    private QuantityListener quantityListener;
    private int position;
    private ImageClickedListener imageClickedListener;
    private RatingListener ratingListener;

    public ProductListViewHolder(View itemView) {
        super(itemView);
        this.image = (ImageView) itemView.findViewById(R.id.cell_iv_image);
        this.name = (TextView) itemView.findViewById(R.id.cell_tv_name);
        this.quantity = (TextView) itemView.findViewById(R.id.cell_tv_quantity);
        this.price = (TextView) itemView.findViewById(R.id.cell_tv_price);
        this.addButton = (Button) itemView.findViewById(R.id.cell_btn_add);
        this.removeButton = (Button) itemView.findViewById(R.id.cell_btn_remove);
        this.ratingBar = (RatingBar) itemView.findViewById(R.id.cell_rating_bar);

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

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClickedListener.onImageClicked(position);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser)
                    ratingListener.onRateChange(position, (int)rating);
            }
        });

    }

    public void setQuantityListener(QuantityListener quantityListener) {
        this.quantityListener = quantityListener;
    }

    public void setImageClickedListener(ImageClickedListener imageClickedListener) {
        this.imageClickedListener = imageClickedListener;
    }

    public void setOnRatingChangeListener(RatingListener ratingListener) {
        this.ratingListener = ratingListener;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
