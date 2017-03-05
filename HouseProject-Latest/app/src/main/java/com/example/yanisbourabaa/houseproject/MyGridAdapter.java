package com.example.yanisbourabaa.houseproject;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by yanisbourabaa on 17/02/2017.
 */
public class MyGridAdapter extends BaseAdapter {
    public static final String RATE = "RATE";
    Context context;

    List<House> houses = new ArrayList<>();

    // https://ap.rdcpix.com/1921824389/00809caf94ce1da6e7c4d0d7defb99cdl-w3xd-w1020_h770_q80.jpg
    // https://ap.rdcpix.com/1055769603/00809caf94ce1da6e7c4d0d7defb99cdl-w11xd-w1020_h770_q80.jpg
    // https://ap.rdcpix.com/375700450/00809caf94ce1da6e7c4d0d7defb99cdl-w13xd-w1020_h770_q80.jpg
    // https://ap.rdcpix.com/1936285694/00809caf94ce1da6e7c4d0d7defb99cdl-w17xd-w1020_h770_q80.jpg
    // https://ap.rdcpix.com/641816327/00809caf94ce1da6e7c4d0d7defb99cdl-w22xd-w1020_h770_q80.jpg


    public MyGridAdapter(Context context) {
        this.context = context;

        houses.add(new House("https://ap.rdcpix.com/889617711/00809caf94ce1da6e7c4d0d7defb99cdl-w0xd-w1020_h770_q80.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 659000.00, "Single family house", imageURLList ()));
        houses.add(new House("https://ap.rdcpix.com/1188432387/9c41f8d51f3b77faf1412789deaefb87l-m0xd-w1020_h770_q80.jpg", "4039 Mira Costa St, Oceanside, CA 92056", 3, 310000.45, "New granite counters", null));
        houses.add(new House("https://ap.rdcpix.com/1938597178/153b22f607a1d4a1040c19f0c1be185fl-w0xd-w1020_h770_q80.jpg", "5075 Viewridge Way, Oceanside, CA 92056", 3, 650000.75, "Washer/dryer included", null));
        houses.add(new House("https://ap.rdcpix.com/436252174/7fb4e7b52d883cb3c35bb22eca6e5c2fl-m0xd-w1020_h770_q80.jpg", "4039 Mira Costa St, Oceanside, CA 92056", 3, 250428.45, "Single family house", null));
        houses.add(new House("https://ap.rdcpix.com/75940783/c688c88d9b61dad01b7cdd261f297098l-m0xd-w1020_h770_q80.jpg", "1401 Calle Marbella, Oceanside, CA 92056", 3, 231369.45, "New granite counters", null));
        houses.add(new House("https://ap.rdcpix.com/1938597178/153b22f607a1d4a1040c19f0c1be185fl-w0xd-w1020_h770_q80.jpg", "4039 Mira Costa St, Oceanside, CA 92056", 3, 358922.45, "Washer/dryer included", null));
        houses.add(new House("https://ap.rdcpix.com/889617711/00809caf94ce1da6e7c4d0d7defb99cdl-w0xd-w1020_h770_q80.jpg", "815 Palo alto Ct, San Marcos, CA 92069", 3, 450000.45, "Single family house", null));
        houses.add(new House("https://ap.rdcpix.com/1188432387/9c41f8d51f3b77faf1412789deaefb87l-m0xd-w1020_h770_q80.jpg", "4039 Mira Costa St, Oceanside, CA 92056", 3, 196556.45, "New granite counters", null));
        houses.add(new House("https://ap.rdcpix.com/1938597178/153b22f607a1d4a1040c19f0c1be185fl-w0xd-w1020_h770_q80.jpg", "5075 Viewridge Way, Oceanside, CA 92056", 3, 548202.45, "Washer/dryer included", null));
        houses.add(new House("https://ap.rdcpix.com/436252174/7fb4e7b52d883cb3c35bb22eca6e5c2fl-m0xd-w1020_h770_q80.jpg", "1401 Calle Marbella, Oceanside, CA 92056", 3, 750698.00, "Single family house", null));
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
        Button calcMortgage = (Button) v.findViewById(R.id.calc_mortgage);
        LinearLayout container = (LinearLayout) v.findViewById(R.id.cell_text_container);

        Glide.with(context).load(houses.get(position).getImageUrl()).into(imageView);
        address.setText(houses.get(position).getAddress());
        highlight.setText(houses.get(position).getHighlight());

        String finalPrice = String.format("%.2f", houses.get(position).getPrice());
        finalPrice = "$ " + NumberFormat.getNumberInstance(Locale.US).format(Double.parseDouble(finalPrice));

        price.setText(finalPrice);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (houses.get(position).getImageURLs() == null || houses.get(position).getImageURLs().length == 0) {
                    Toast.makeText(context, "This house does not offer additional images", Toast.LENGTH_SHORT).show();

                    return;
                }

                Intent i = new Intent(context, ImageGallery.class);
                i.putExtra("House", (Serializable) houses.get(position));

                context.startActivity(i);
            }


        });

        address.setOnClickListener(new View.OnClickListener() {
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

        calcMortgage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double price = Double.valueOf(houses.get(position).getPrice());

                Intent i = new Intent(context, MortgageCalculator.class);
                i.putExtra("HousePrice", price);

                context.startActivity(i);
            }


        });

        return v;
    }

    public String[] imageURLList () {
        String[] imageURLs = new String[5];
        imageURLs[0] = "https://ap.rdcpix.com/1921824389/00809caf94ce1da6e7c4d0d7defb99cdl-w3xd-w1020_h770_q80.jpg";
        imageURLs[1] = "https://ap.rdcpix.com/1055769603/00809caf94ce1da6e7c4d0d7defb99cdl-w11xd-w1020_h770_q80.jpg";
        imageURLs[2] = "https://ap.rdcpix.com/375700450/00809caf94ce1da6e7c4d0d7defb99cdl-w13xd-w1020_h770_q80.jpg";
        imageURLs[3] = "https://ap.rdcpix.com/1936285694/00809caf94ce1da6e7c4d0d7defb99cdl-w17xd-w1020_h770_q80.jpg";
        imageURLs[4] = "https://ap.rdcpix.com/641816327/00809caf94ce1da6e7c4d0d7defb99cdl-w22xd-w1020_h770_q80.jpg";

        return imageURLs;
    }
}
