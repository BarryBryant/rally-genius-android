package com.b3sk.rallygenius.Activities;

import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.b3sk.rallygenius.Adapters.RecyclerViewAdapter;
import com.b3sk.rallygenius.Adapters.SignClickListener;
import com.b3sk.rallygenius.Animation.DetailsTransition;
import com.b3sk.rallygenius.Fragments.MainActivityFragment;
import com.b3sk.rallygenius.Fragments.SignInfoActivityFragment;
import com.b3sk.rallygenius.Model.Sign;
import com.b3sk.rallygenius.Model.SignRepository;
import com.b3sk.rallygenius.MyApplication;
import com.b3sk.rallygenius.Presenter.SignListPresenterImpl;
import com.b3sk.rallygenius.R;
import com.b3sk.rallygenius.View.SignListView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.List;

public class MainActivity extends AppCompatActivity implements android.support.v4.app.FragmentManager.OnBackStackChangedListener {


    private boolean twoPane;
    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(findViewById(R.id.container_two)!=null) {
            twoPane = true;
        }


        if (savedInstanceState == null && !twoPane) {
            MainActivityFragment fragment = new MainActivityFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment).commit();
        }else if(savedInstanceState == null) {
            MainActivityFragment fragment = new MainActivityFragment();
            SignInfoActivityFragment signInfoActivityFragment = new SignInfoActivityFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .add(R.id.container_two, signInfoActivityFragment)
                    .commit();
        }

        getSupportFragmentManager().addOnBackStackChangedListener(this);

        MobileAds.initialize(getApplicationContext(),
                getResources().getString(R.string.banner_ad_app_id));
        MyApplication application = (MyApplication) getApplication();
        tracker = application.getDefaultTracker();

    }

    @Override
    public void onResume() {
        super.onResume();
        tracker.setScreenName("Image~" + "Main Activity");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onBackStackChanged() {
        if(getSupportActionBar() != null && !twoPane) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        }
    }
}
