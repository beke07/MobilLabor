package com.example.labor.main.view.create;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.labor.R;
import com.example.labor.main.model.Civilization;
import com.example.labor.main.view.list.MainActivity;
import com.example.labor.main.view.list.MainScreen;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class CreateActivity extends AppCompatActivity implements CreateScreen {

    @Inject
    CreatePresenter createPresenter;
    Civilization civilization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        civilization = new Civilization();

        configureBackButton();
        configureCreateButton();
    }

    private void configureBackButton(){
        Button backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void configureCreateButton(){
        Button createButton = (Button) findViewById(R.id.create);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCivilization();
            }
        });
    }

    @Override
    public void createCivilization() {
        createPresenter.createCivilization(civilization);
    }
}
