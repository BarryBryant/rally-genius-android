package com.b3sk.rallygenius.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.b3sk.rallygenius.R;

/**
 * Created by Joopkins on 5/25/16.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public View signView;
    public TextView signId;
    public TextView signName;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        signView = itemView;
        signId = (TextView) itemView.findViewById(R.id.sign_id);
        signName = (TextView) itemView.findViewById(R.id.sign_name);
    }
}
