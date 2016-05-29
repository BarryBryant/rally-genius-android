package com.b3sk.rallygenius.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b3sk.rallygenius.Adapters.RecyclerViewAdapter;
import com.b3sk.rallygenius.Adapters.SignClickListener;
import com.b3sk.rallygenius.Model.Sign;
import com.b3sk.rallygenius.Model.SignRepository;
import com.b3sk.rallygenius.Presenter.SignListPresenterImpl;
import com.b3sk.rallygenius.R;
import com.b3sk.rallygenius.View.SignListView;

import java.util.List;

/**
 * Created by Joopkins on 5/29/16.
 */
public class MainActivityFragment extends Fragment implements SignListView {

    public MainActivityFragment() {}

    private RecyclerView recyclerView;
    private SignListPresenterImpl signListPresenter;

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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        signListPresenter.loadSigns();
        setHasOptionsMenu(true);

    }

    @Override
    public void ShowSigns(@NonNull List<Sign> signs) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(
                getActivity(), signs, (SignClickListener)getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void ShowSignDetail(@NonNull Sign sign) {

    }

    @Override
    public void ShowSignSession() {

    }
}
