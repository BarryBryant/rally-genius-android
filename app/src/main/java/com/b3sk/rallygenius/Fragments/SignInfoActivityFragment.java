package com.b3sk.rallygenius.Fragments;

import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.b3sk.rallygenius.Model.Sign;
import com.b3sk.rallygenius.Model.SignRepository;
import com.b3sk.rallygenius.Model.SignSerializer;
import com.b3sk.rallygenius.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

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
        List<Sign> signs = new SignRepository(new SignSerializer((getContext()))).getSigns();

        if(getArguments() != null) {
            int index = getArguments().getInt(SIGN_INDEX);
            Sign sign = signs.get(index);

            String signNumber = "sign" + sign.getId();
            int resourceId = getContext().getResources()
                    .getIdentifier(signNumber, "drawable", getContext().getPackageName());

            imageView.setImageResource(resourceId);
            textView.setText(sign.getDescription());
        }else {
            Sign sign = signs.get(0);

            String signNumber = "sign" + sign.getId();
            int resourceId = getContext().getResources()
                    .getIdentifier(signNumber, "drawable", getContext().getPackageName());

            imageView.setImageResource(resourceId);
            textView.setText(sign.getDescription());
        }

        return rootView;
    }
}
