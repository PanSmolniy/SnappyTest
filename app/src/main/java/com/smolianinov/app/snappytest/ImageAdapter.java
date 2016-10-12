package com.smolianinov.app.snappytest;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

class ImageAdapter extends BaseAdapter {

    private Context mContext;

    private List<Bitmap> listBmp;

    public ImageAdapter(Context c, List<Bitmap> listBmp) {
        mContext = c;
        this.listBmp = listBmp;
    }

    public int getCount() {
        return listBmp.size();
    }

    public Object getItem(int position) {
        return listBmp.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(listBmp.get(position));
        return imageView;
    }
}
