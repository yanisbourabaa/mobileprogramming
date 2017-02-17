package com.example.yanisbourabaa.houseproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanisbourabaa on 17/02/2017.
 */
public class MyGridAdapter extends BaseAdapter {
    public static final String RATE = "RATE";
    Context context;

    List<House> houses = new ArrayList<>();

    public MyGridAdapter(Context context) {
        this.context = context;

        houses.add(new House("https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 234362.45, "Single family house"));
        houses.add(new House("https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 234362.45, "Single family house"));
        houses.add(new House("https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 234362.45, "Single family house"));
        houses.add(new House("https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 234362.45, "Single family house"));
        houses.add(new House("https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 234362.45, "Single family house"));
        houses.add(new House("https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 234362.45, "Single family house"));
        houses.add(new House("https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 234362.45, "Single family house"));
        houses.add(new House("https://s-media-cache-ak0.pinimg.com/736x/73/de/32/73de32f9e5a0db66ec7805bb7cb3f807.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 234362.45, "Single family house"));
    }

    @Override
    public int getCount() {
        return houses.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.cell_house, parent, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.cell_image);
        TextView address = (TextView) v.findViewById(R.id.cell_address);
        TextView highlight = (TextView) v.findViewById(R.id.cell_highlights);
        TextView price = (TextView) v.findViewById(R.id.cell_price);
        LinearLayout container = (LinearLayout) v.findViewById(R.id.cell_text_container);

        Glide.with(context).load(houses.get(position).getImageUrl()).into(imageView);
        address.setText(houses.get(position).getAddress());
        highlight.setText(houses.get(position).getHighlight());
        String finalPrice = houses.get(position).getPrice() + "$";
        price.setText(finalPrice);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "http://maps.google.co.in/maps?q=" + houses.get(position).getAddress();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                context.startActivity(i);
            }
        });
        container.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, RatingActivity.class);
                context.startActivity(i);
            }
        });
        return v;
    }
}
