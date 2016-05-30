package com.b3sk.rallygenius.Fragments;

import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.b3sk.rallygenius.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SignInfoActivityFragment extends Fragment {

    private final String SIGN_INDEX = "com.b3sk.rallygenius.intent.index";

    public SignInfoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sign_info, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.sign_image);
        TextView textView = (TextView) rootView.findViewById(R.id.sign_info);

        TypedArray signImgs = this.getResources().obtainTypedArray(R.array.signs);
        TypedArray signDesc = this.getResources().obtainTypedArray(R.array.sign_descriptions);

        imageView.setImageDrawable(signImgs.getDrawable(getArguments().getInt(SIGN_INDEX)));
        textView.setText(signDesc.getText(getArguments().getInt(SIGN_INDEX)));

        signImgs.recycle();
        signDesc.recycle();

        return rootView;
    }
}
