package com.b3sk.rallygenius;

import com.b3sk.rallygenius.Model.Sign;
import com.b3sk.rallygenius.Model.SignRepository;
import com.b3sk.rallygenius.Presenter.SignListPresenter;
import com.b3sk.rallygenius.Presenter.SignListPresenterImpl;
import com.b3sk.rallygenius.View.SignListView;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class SignListPresenterTest {

    SignListPresenterImpl signListPresenter;
    SignListView signListView;
    SignRepository signRepository;

    @Before
    public void setup() {
        signListView = mock(SignListView.class);
        signRepository = mock(SignRepository.class);
        signListPresenter = new SignListPresenterImpl(signRepository, signListView);
    }

    @Test
    public void loadSignsFromRepositoryAndLoadIntoView() {
        signListPresenter.loadSigns();
        when(signRepository.getSigns()).thenCallRealMethod();
        verify(signRepository).getSigns();
        verify(signListView).ShowSigns(anyListOf(Sign.class));
    }

    @Test
    public void clickOnSignLaunchesDetail() {
        signListPresenter.openSignInfo(any(Sign.class));
        verify(signListView).ShowSignDetail(any(Sign.class));
    }

    @Test
    public void clickLaunchSessionOpenSession() {
        signListPresenter.openSession();
        verify(signListView).ShowSignSession();
    }

    @Test
    public void clickAddSignAddsSignToSession() {
        signListPresenter.addSignToSession(any(Sign.class));
        verify(signRepository).addSignToSession(any(Sign.class));
    }
}