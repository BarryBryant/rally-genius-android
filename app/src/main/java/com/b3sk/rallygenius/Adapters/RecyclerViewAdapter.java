package com.b3sk.rallygenius.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.rallygenius.Activities.SignInfoActivity;
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
    private final LayoutInflater layoutInflater;

    private final String SIGN_INDEX = "com.b3sk.rallygenius.intent.index";


    public RecyclerViewAdapter(Context context, List<Sign> signs) {
        this.context = context;
        this.signs = new ArrayList<>(signs);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View signView = layoutInflater.inflate(R.layout.sign_list_item, parent, false);
        return new RecyclerViewHolder(signView);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        TypedArray signImgs = context.getResources().obtainTypedArray(R.array.signs);
        holder.signImage.setImageDrawable(signImgs.getDrawable(position));
        signImgs.recycle();
        holder.signView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignInfoActivity.class);
                intent.putExtra(SIGN_INDEX, position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return signs.size();
    }
}
