package com.example.labor.main.view.list;

import android.content.Intent;
import android.os.Bundle;

import com.example.labor.R;
import com.example.labor.main.model.Civilization;
import com.example.labor.main.view.create.CreateActivity;
import com.example.labor.main.view.details.DetailsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainScreen, CivilizationAdapter.OnCivilizationListener {

    @Inject
    MainPresenter mainPresenter;

    private RecyclerView recyclerViewCivilizations;
    private SwipeRefreshLayout swipeRefreshLayoutCivilizations;
    private List<Civilization> civilizationList;
    private CivilizationAdapter civilizationAdapter;
    private TextView tvEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmpty = this.findViewById(R.id.tvEmpty);

        recyclerViewCivilizations = this.findViewById(R.id.recyclerViewCivilizations);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCivilizations.setLayoutManager(llm);

        civilizationList = new ArrayList<>();
        civilizationAdapter = new CivilizationAdapter(this, civilizationList, this, mainPresenter);
        recyclerViewCivilizations.setAdapter(civilizationAdapter);

        swipeRefreshLayoutCivilizations = this.findViewById(R.id.swipeRefreshLayoutCivilizations);

        swipeRefreshLayoutCivilizations.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.refreshCivilizations();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateActivity.class));
            }
        });
    }

    @Override
    public void showCivilizations(List<Civilization> civilizations) {
        if (swipeRefreshLayoutCivilizations != null) {
            swipeRefreshLayoutCivilizations.setRefreshing(false);
        }

        civilizationList.clear();
        civilizationList.addAll(civilizations);
        civilizationAdapter.notifyDataSetChanged();

        if (civilizationList.isEmpty()) {
            recyclerViewCivilizations.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            recyclerViewCivilizations.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mainPresenter.refreshCivilizations();
    }

    @Override
    public void showNetworkError(String errorMsg) {
        if (swipeRefreshLayoutCivilizations != null) {
            swipeRefreshLayoutCivilizations.setRefreshing(false);
        }

        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCivilizationClick(int position) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("civilization", gson.toJson(civilizationList.get(position)));
        startActivity(intent);
    }
}
