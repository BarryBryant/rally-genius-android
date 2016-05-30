package com.b3sk.rallygenius.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.b3sk.rallygenius.R;

/**
 * Created by Joopkins on 5/25/16.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public View signView;
    public ImageView signImage;
    public TextView signNumber;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        signView = itemView;
        signImage = (ImageView) itemView.findViewById(R.id.sign_image);
        signNumber = (TextView) itemView.findViewById(R.id.number);
    }
}
