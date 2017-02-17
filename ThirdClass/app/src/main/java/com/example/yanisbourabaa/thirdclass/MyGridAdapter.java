package com.example.yanisbourabaa.thirdclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/**
 * Created by yanisbourabaa on 17/02/2017.
 */
public class MyGridAdapter extends BaseAdapter {
    private final Context context;
    private int[] layouts = { R.layout.cell_image,
            R.layout.cell_price,
            R.layout.cell_map,
            R.layout.cell_highlight,
            R.layout.cell_pictures,
            R.layout.cell_rating};

    public MyGridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(layouts[position], parent, false);
        return v;
    }
}
