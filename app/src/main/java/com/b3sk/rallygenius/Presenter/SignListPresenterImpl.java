package com.b3sk.rallygenius.Presenter;

import android.support.annotation.NonNull;

import com.b3sk.rallygenius.Model.Sign;
import com.b3sk.rallygenius.Model.SignRepository;
import com.b3sk.rallygenius.View.SignListView;

import java.util.List;

/**
 * Created by Joopkins on 5/25/16.
 */
public class SignListPresenterImpl implements SignListPresenter {

    private SignRepository signRepository;
    private SignListView signListView;

    public SignListPresenterImpl(SignRepository signRepository, SignListView signListView) {
        this.signRepository = signRepository;
        this.signListView = signListView;
    }

    @Override
    public void loadSigns() {
        List<Sign> signs = signRepository.getSigns();
        signListView.ShowSigns(signs);
    }

    @Override
    public void openSignInfo(@NonNull Sign sign) {
        signListView.ShowSignDetail(sign);
    }

}
