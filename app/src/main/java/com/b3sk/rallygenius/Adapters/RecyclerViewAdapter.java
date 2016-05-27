package com.b3sk.rallygenius.Adapters;

import android.content.Context;
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

    private List<Sign> signs;
    private final LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context, List<Sign> signs) {
        this.signs = new ArrayList<>(signs);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View signView = layoutInflater.inflate(R.layout.sign_list_item, parent, false);
        return new RecyclerViewHolder(signView);    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.signId.setText(String.valueOf(signs.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return signs.size();
    }
}
