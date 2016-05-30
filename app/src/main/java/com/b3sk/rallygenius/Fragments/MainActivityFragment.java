package com.b3sk.rallygenius.Fragments;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.b3sk.rallygenius.Adapters.ExtendedGridLayoutManager;
import com.b3sk.rallygenius.Adapters.RecyclerViewAdapter;
import com.b3sk.rallygenius.Adapters.SignClickListener;
import com.b3sk.rallygenius.Animation.DetailsTransition;
import com.b3sk.rallygenius.Model.Sign;
import com.b3sk.rallygenius.Model.SignRepository;
import com.b3sk.rallygenius.Presenter.SignListPresenterImpl;
import com.b3sk.rallygenius.R;
import com.b3sk.rallygenius.View.SignListView;

import java.util.List;

/**
 * Created by Joopkins on 5/29/16.
 */
public class MainActivityFragment extends Fragment implements SignListView, SignClickListener {

    public MainActivityFragment() {}

    private RecyclerView recyclerView;
    private SignListPresenterImpl signListPresenter;


    private final String SIGN_INDEX = "com.b3sk.rallygenius.intent.index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.content_main, container, false);

        signListPresenter = new SignListPresenterImpl(new SignRepository(), this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.sign_list_recycler);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        int columns = getActivity().getResources().getInteger(R.integer.grid_columns);
        GridLayoutManager gridLayoutManager
                = new GridLayoutManager(getActivity(), columns);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        signListPresenter.loadSigns();
        setHasOptionsMenu(true);

    }

    @Override
    public void ShowSigns(@NonNull List<Sign> signs) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(
                getActivity(), signs, this);
        recyclerViewAdapter.setHasStableIds(true);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void ShowSignDetail(@NonNull Sign sign) {

    }

    @Override
    public void ShowSignSession() {

    }

    @Override
    public void onSignClicked(int position, ImageView reference) {
        Bundle bundle = new Bundle();
        bundle.putInt(SIGN_INDEX, position);

        SignInfoActivityFragment fragment = new SignInfoActivityFragment();
        fragment.setArguments(bundle);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.setSharedElementReturnTransition(new DetailsTransition());
            this.setExitTransition(new Fade());

            fragment.setSharedElementEnterTransition(new DetailsTransition());
            fragment.setEnterTransition(new Slide());
            fragment.setReturnTransition(new Fade());
        }

        if(getActivity().findViewById(R.id.container_two) == null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .addSharedElement(reference, "sign")
                    .commit();
        }else {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_two, fragment)
                    .addToBackStack(null)
                    .addSharedElement(reference, "sign")
                    .commit();
        }
    }
}
