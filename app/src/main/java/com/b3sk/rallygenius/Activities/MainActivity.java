package com.b3sk.rallygenius.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.b3sk.rallygenius.Adapters.RecyclerViewAdapter;
import com.b3sk.rallygenius.Model.Sign;
import com.b3sk.rallygenius.Model.SignRepository;
import com.b3sk.rallygenius.Presenter.SignListPresenterImpl;
import com.b3sk.rallygenius.R;
import com.b3sk.rallygenius.View.SignListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SignListView{

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private SignListPresenterImpl signListPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        signListPresenter = new SignListPresenterImpl(new SignRepository(), this);

        recyclerView = (RecyclerView) findViewById(R.id.sign_list_recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onResume() {
        super.onResume();
        signListPresenter.loadSigns();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ShowSigns(@NonNull List<Sign> signs) {
        recyclerViewAdapter = new RecyclerViewAdapter(this, signs);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void ShowSignDetail(@NonNull Sign sign) {

    }

    @Override
    public void ShowSignSession() {

    }
}
