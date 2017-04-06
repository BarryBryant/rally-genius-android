package com.b3sk.rallygenius.Adapters;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.rallygenius.Model.Sign;
import com.b3sk.rallygenius.R;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Joopkins on 5/25/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private Context context;
    private List<Sign> signs;
    private SignClickListener callback;
    private final LayoutInflater layoutInflater;


    public RecyclerViewAdapter(Context context, List<Sign> signs, SignClickListener clickListener) {
        this.context = context;
        this.signs = new ArrayList<>(signs);
        callback = clickListener;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View signView = layoutInflater.inflate(R.layout.sign_list_item, parent, false);
        return new RecyclerViewHolder(signView);

    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        Sign sign = signs.get(position);
        String number = String.valueOf(sign.getId());
        String signNumber = "sign" + number;
        int resourceId = context.getResources().getIdentifier(signNumber, "drawable", context.getPackageName());
        holder.signImage.setImageResource(resourceId);
        ViewCompat.setTransitionName(holder.signImage, String.valueOf(position) + "_image");
        holder.signNumber.setText(number);

        holder.signView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onSignClicked(position, holder.signImage);
            }
        });
    }

    @Override
    public int getItemCount() {
        return signs.size();
    }

    @Override
    public long getItemId(int position) { return position;}
}
